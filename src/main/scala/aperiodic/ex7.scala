package aperiodic

object ex7 {
  def main(args: Array[String]): Unit = {
  println(flatten(List(List(List(1,2,3), List(3,4)))))
  }

  def flatten[A](input: List[Any]): List[Any] = input flatMap{
    case nested:List[_] => {
      println(s"flattening $nested")
      flatten(nested)
    }
    case e => {
      println(e)
      List(e)
    }
  }

}
