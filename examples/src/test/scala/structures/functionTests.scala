package structures
import org.scalatest.FlatSpec

/**
 * @author devtopic
 */
class functionTests extends FlatSpec{
  
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
}