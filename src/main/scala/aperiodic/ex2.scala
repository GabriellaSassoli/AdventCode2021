package aperiodic

object ex2 {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8)
    val list2 = List("Hi","THis")

    println(getPenultimate(list))
    println(penultimateRecursive(list))
    println(list.init.last)

    println(getPenultimate(list2))
    println(penultimateRecursive(list2))
  }

  def getPenultimate[A](list:List[A]): A = {
    val penultimeElementIndex = list.length - 2
    list(penultimeElementIndex)
  }

  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case e :: _ :: Nil  => e
    case _ :: tail => penultimateRecursive(tail)
    case _         => throw new NoSuchElementException
  }

}
