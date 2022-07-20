package aperiodic

import scala.collection.immutable.HashMap

class twoSum {


  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    nums.indices.iterator
      .scanLeft(HashMap.empty[Int, Int]) { (map, i) =>
        map + (nums(i) -> i)
      }
      .zipWithIndex
      .collectFirst(Function.unlift { case (indexByValue, i) =>
        indexByValue.get(target - nums(i)).filter(_ != i).map(Array(i, _))
      })
      .getOrElse(Array(-1, -1))
  }


  def twoSumMyWay(nums: Array[Int], target: Int): Array[Int] = {

    implicit val numsList: List[Int] = nums.toList

    recursion(0,target).sorted.toArray

  }

  def recursion(currentIndex: Int, target: Int, lookUp: HashMap[Int, Int] = HashMap.empty[Int, Int])(implicit numsList: List[Int]): List[Int] = {
    if (currentIndex == (numsList.length) ) List.empty

    else{
      lookUp.get(numsList(currentIndex)) match{
        case Some(matchedIndex) =>
          List(currentIndex,matchedIndex)
        case None =>
          recursion(currentIndex + 1,target,lookUp + ((target - numsList(currentIndex)) -> currentIndex))
      }}
  }

}
