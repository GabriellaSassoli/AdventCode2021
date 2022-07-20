package aperiodic

object ex3 {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8)
    val list2 = List("Hi","THis","Is","something")
    val k = 5

    println(list(k))
    println(getKthElement(k,list))
    println(nthRecursive(0,list))
    println(nthRecursive(k,list))
    println(nthRecursive(k,list2))

    def getKthElement[A](k: Int, list: List[A]): A = {
      if (list.length -1 < k) throw new NoSuchElementException
      else list(k)
    }
    def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
      case (0, h :: _   ) => h
      case (n, _ :: tail) => nthRecursive(n - 1, tail)
      case (_, Nil      ) => throw new NoSuchElementException
    }

  }
}
