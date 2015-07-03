package structures
import org.scalatest.FlatSpec

/**
 * @author devtopic
 */
class functionTests extends FlatSpec{
  
  "A function" should "return 'Hi!'" in {
    assert( Hi.getGreetings() === "Hi!")
  }
}