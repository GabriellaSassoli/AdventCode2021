package aperiodic

object ex9 {
  def main(args: Array[String]): Unit = {
    val packedList = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    println(packedList)
     println(encode(packedList))

  }

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }
  def encode[A](list: List[List[A]]): List[(Int, A)] = {
    list map (ls => (ls.length, ls.head))
  }
}
