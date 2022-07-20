package aperiodic

import scala.annotation.tailrec

object mergeSort {

//Merge sort repeatedly breaks down a list into several sublists until each
// sublist consists of a single element and merging those sublists in a manner
// that results into a sorted list.

  def mergeSort(listToSort: List[Int]): List[Int] = {
    listToSort match {
      case Nil => Nil
      case value :: Nil => List(value)
      case _ =>
        val (left,right) = listToSort splitAt listToSort.length/2
        merge(mergeSort(left), mergeSort(right))

  }

  }

  @tailrec
  def merge(list1: List[Int], list2: List[Int], accumulator: List[Int] = List.empty): List[Int] ={
    (list1, list2) match {
      case (Nil, _) => accumulator ++ list2
      case (_,Nil) => accumulator ++ list1
      case (x :: xs, y :: ys) => {
        if (x > y) merge(list1, ys, accumulator :+ y)
        else merge(xs, list2, accumulator :+ x)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(mergeSort(List(5, 9, 8, 3, 1, 5)))
  }
}
