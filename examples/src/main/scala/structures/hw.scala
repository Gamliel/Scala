package structures

object Hi { 
  def main(args: Array[String]) = {
    println(getGreetings())
  }
  
  def getGreetings(): String = {
    "Hi!"
  }
  
  def getList(inf:Integer, sup:Integer): List[Integer] = {
    if (sup < inf)
      throw new IllegalArgumentException("Sup must be >= Inf")

    if (inf == sup) List(inf)
    else {
      inf:: getList(inf+1,sup)
    }
  }
}
