package aperiodic

object isUnique {
  def main(args: Array[String]): Unit = {
    val input: String = ""
    println(isUnique(input))

  }

  def isUnique(input: String) : Boolean ={
    if (input.length > 128) false
    else if (input == "") true
    else{
      recursion(input)
    }

  }

  def recursion(input: String): Boolean = {
    if (input.length == 1) true
    else if (input.substring(1).contains(input.take(1))) false
    else recursion(input.substring(1))
  }

}
