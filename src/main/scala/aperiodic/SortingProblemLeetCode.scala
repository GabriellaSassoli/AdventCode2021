package aperiodic

object SortingProblemLeetCode {

  def quickSort(input: List[Int]): List[Int]= {
    if(input.length <= 1) input
    else {
      val pivot = input(input.length/2)
      List.concat(quickSort(input.filter(_ < pivot)), input.filter( _ == pivot), quickSort(input.filter(_ > pivot)))
    }

  }

//  def otherSolution(input: List[Int]): List[Int] ={
//    input.groupBy(identity)
//  }

  def main(args: Array[String]): Unit = {
    val input = List(2, 0, 2, 1, 1, 0)

    println(input.groupBy(identity).toList.collect{case(_, values) => values}.flatten)
    println(quickSort(input))
  }

}
