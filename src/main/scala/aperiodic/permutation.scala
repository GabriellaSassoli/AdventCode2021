package aperiodic

object permutation {
  def main(args: Array[String]): Unit = {
    val input1: String = "hi"
    val input2: String = "hi"
    println(isPermutation1(input1, input2))

  }

  def isPermutation1(input1: String, input2: String) : Boolean ={
    if (input1.length != input2.length) false
    else if (input1.sorted == input2.sorted) true
    else false
    }



}
