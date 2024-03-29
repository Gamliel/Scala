package structures
import org.scalatest.FlatSpec
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

/**
 * @author devtopic
 */
class functionTests extends FlatSpec with GeneratorDrivenPropertyChecks{
  
  val upperBound = for (n <- Gen.choose(1, 100)) yield n * 10000  
  
  "A function" should "return 'Hi!'" in {
    assert( Hi.getGreetings() === "Hi!")
  }
  
  "A list function" should "return a list with a range" in{
    assert ( Hi.getList(3,7) === List(3,4,5,6,7))
  } 

  "A list function" should "fail generate 100000 elements" in{
    intercept[java.lang.StackOverflowError] {
      Hi.getList(1,100000)
    }
  } 

  "An Optimised list function" should "generate 100000 elements" in{
    val elements = Hi.getListOptimised(1,100000,List.empty)
    assert ( elements.length  === 100000)
  }
  
  "List function" should "accept generated valid ranges" in {
    forAll(upperBound) { (n:Int) => 
      assert ( Hi.getListOptimised(0, n, List.empty).length == n + 1)
    }
  }
  
  "Range" should "generate a list" in {
    forAll(upperBound) { (n:Int) =>
      assert ( Hi.getListSimple(0, n).length == n + 1)
    }
  }
  
  "Method" should "apply a function for each element" in {
    forAll(upperBound) { (n:Int) =>
      val resultingList = Hi.getMappedList(0, n, e => e * 2, List.empty)
      assert ( resultingList.length == n + 1)
      assert ( resultingList.forall(_ % 2 == 0))
    }
  }

  "Method" should "apply a different function for each element" in {
    forAll(upperBound) { (n:Int) =>
      val resultingList = Hi.getMappedList(0, n, e => e * 2 + 1, List.empty)
      assert ( resultingList.length == n + 1)
      assert ( resultingList.forall(_ % 2 == 1))
    }
  }

  "Simpler Method" should "apply a function for each element" in {
    forAll(upperBound) { (n:Int) =>
      val resultingList = Hi.getSimplerMappedList(0, n, e => e * 2)
      assert ( resultingList.length == n + 1)
      assert ( resultingList.forall(_ % 2 == 0))
    }
  }

  "Simpler Method" should "apply a different function for each element" in {
    forAll(upperBound) { (n:Int) =>
      val resultingList = Hi.getSimplerMappedList(0, n, e => e * 2 + 1)
      assert ( resultingList.length == n + 1)
      assert ( resultingList.forall(_ % 2 == 1))
    }
  }

  "Fold Left" should "apply a function for each element" in {
    val result = Hi.getFoldedLeftResult(0, 4, (a1:Int, a2:Int) => a1 + a2,0)
    assert ( result == 10)
  }

  "Fold Left" should "apply a different function for each element" in {
    val result = Hi.getFoldedLeftResult(1, 5, (a1:Int, a2:Int) => a1 * a2,1)
    assert ( result == 120)
  }
  
  "Fold Left" should "apply a subtraction" in {
    val result = Hi.getFoldedLeftResult(1, 3, (a1:Int, a2:Int) => a1 - a2,10)
    assert ( result == 4)
  }

  "Fold Right" should "apply a subtraction" in {
    val result = Hi.getFoldedRightResult(1, 3, (a1:Int, a2:Int) => a1 - a2,10)
    assert ( result == -8)
  }
  
}