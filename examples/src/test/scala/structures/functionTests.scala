package structures
import org.scalatest.FlatSpec

/**
 * @author devtopic
 */
class functionTests extends FlatSpec{
  
  "A function" should "return 'Hi!'" in {
    assert( Hi.getGreetings() === "Hi!")
  }
  
  "A function" should "return a list with 10 elements" in{
    assert ( Hi.getList(3,7) === List(3,4,5,6,7))
  } 
}