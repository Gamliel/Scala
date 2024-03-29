package structures

object Hi { 
  def main(args: Array[String]) = {
    println(getGreetings())
  }
  
  def getGreetings(): String = {
    "Hi!"
  }
  
  def getList(inf:Int, sup:Int): List[Int] = {
    if (sup < inf)
      throw new IllegalArgumentException("Sup must be >= Inf")

    if (inf == sup) List(inf)
    else {
      inf :: getList(inf+1,sup)
    }
  }

  def getListOptimised(inf:Int, sup:Int, curList:List[Int]): List[Int] = {
    if (sup < inf)
      throw new IllegalArgumentException("Sup must be >= Inf")

    if (inf == sup) inf::curList
    else {
      getListOptimised(inf+1, sup, inf::curList)
    }
  }
  
  def getListSimple (inf:Int, sup:Int): List[Int] = {
    if (sup < inf)
      throw new IllegalArgumentException(s"$sup must be >= $inf")
    List.range(inf, sup + 1)
  }
  
  def getMappedList[T] (inf:Int, sup:Int, f: ((Int)=> T), curList:List[T]): List[T] = {
    if (sup < inf)
      throw new IllegalArgumentException("Sup must be >= Inf")

    if (inf == sup) f(inf)::curList
    else {
      getMappedList(inf+1, sup, f, f(inf)::curList)
    }
  }

    def getSimplerMappedList[T] (inf:Int, sup:Int, f: ((Int)=> T)): List[T] = {
      if (sup < inf)
        throw new IllegalArgumentException("Sup must be >= Inf")
  
      List.range(inf, sup + 1).map { f }
    }

    def getFoldedLeftResult[T] (inf:Int, sup:Int, f: ((T,Int)=> T), z:T): T = {
      if (sup < inf)
        throw new IllegalArgumentException("Sup must be >= Inf")
  
      List.range(inf, sup + 1).foldLeft(z)(f)
    }

    def getFoldedRightResult(inf:Int, sup:Int, f: ((Int,Int)=> Int), z:Int): Int = {
      if (sup < inf)
        throw new IllegalArgumentException("Sup must be >= Inf")
  
      List.range(inf, sup + 1).foldRight(z)(f)
    }
}