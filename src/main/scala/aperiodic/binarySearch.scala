package aperiodic

object binarySearch {
  def main(args: Array[String]): Unit = {
    //binary search is an algorithm that retrieves, from a sorted list,the requested value in O(log n) time where n is the length of the sortedList
    val sortedList: List[Int] = List(1,2,3,4,5,6,7,8,9)
    implicit val valueToFind: Int = 8

    def binarySearch(sortedList: List[Int], min: Int, max: Int)(implicit valueToFind: Int): Int = {
      if (sortedList.isEmpty) -1
      else {
        val indexMiddleList = (sortedList.size - 1) / 2

        sortedList(indexMiddleList) match {
          case value if value == valueToFind => indexMiddleList + min
          case value if value < valueToFind => binarySearch(sortedList.drop(indexMiddleList), min = min + indexMiddleList, max)
          case value if value > valueToFind => binarySearch(sortedList.take(indexMiddleList - 1), min, max = max + indexMiddleList)
        }
      }
    }
    println(binarySearch(sortedList, 0,sortedList.size - 1 ))
    println(binarySearch(List(2,3,8,4),0, 3))
  }


}
