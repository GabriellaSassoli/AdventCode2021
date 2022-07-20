package aperiodic

import aperiodic.mergeSort.mergeSort

object QuickSort {
  //  It works by selecting a 'pivot' element from the array and partitioning the other elements
  //  into two sub-arrays, according to whether they are less than or greater than the pivot.
  // O(n log n)
  // choosing pivot in the middle of the list for my sake
  // List(0,1,12,23,4,5,2)

  def quickSort(input: List[Int]): List[Int]= {
    if (input.length <= 1) input
    else {
      val pivot = input(input.length / 2)
      List.concat(quickSort(input.filter(_ < pivot)), input.filter(_ == pivot), quickSort(input.filter(_ > pivot)))

    }

  }

  def main(args: Array[String]): Unit = {
    val input = List(5, 9, 8, 3, 1, 22)
    println(quickSort(input))
  }
}
