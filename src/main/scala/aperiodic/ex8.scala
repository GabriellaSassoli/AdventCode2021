package aperiodic

object ex8 {
  def main(args: Array[String]): Unit = {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def compress[A](input: List[A], output: List[A] = List.empty): List[A]={
    input match{
      case h:: tail => compress(tail.dropWhile(_ == h), h :: output)
      case Nil => output.reverse
    }
  }

  def compressFunctional[A](ls:List[A]): List[A] =
    ls.foldRight(List[A]()){ (h,r)=>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
}
