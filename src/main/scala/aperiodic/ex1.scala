package aperiodic

object ex1 {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8)
    val list2 = List("Hi","THis")

    println(getLastElementOfList(list2))
    println(list.last)
    println(lastRecursive(list2))
  }

  def getLastElementOfList[A](list:List[A]): A = {
    val lastElementIndex = list.length - 1
    list(lastElementIndex)
  }

  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  }
}
