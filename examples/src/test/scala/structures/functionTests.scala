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
}