package CodeAdvent2021

import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

import java.security.Identity
import scala.io.Source

object Day3 {

  def main(args: Array[String]): Unit = {
    /// dividere strings into array of ones, count how many 1 present in first element of every array and ( other function) finally if count is greater than half height gamma 1 epsilon 0 or other way round
    val input: List[String] = readInput("src/main/resources/Day3Input")
    println(solution(input))

  }

  def readInput(filepath: String) = {
    Source.fromFile(filepath).getLines.toList
  }

  def findGammaRate(input: List[String]): String = {
    input.transpose.map(findMostCommonElementInCollection).mkString
  }

  def findEpsilonRate(input: List[String]): String = {
    input.transpose.map(findLeastCommonElementInCollection).mkString
  }

  def convertBinaryToDecimal(binaryNumber: String): Int = {
    Integer.parseInt(binaryNumber, 2)
  }

  def findMostCommonElementInCollection[A](coll: Seq[A]): A = {
    coll.groupBy(identity).view.mapValues(_.size).maxBy(_._2)._1
  }

  def findLeastCommonElementInCollection[A](coll: Seq[A]): A = { //read more on this notation.
    coll.groupBy(identity).view.mapValues(_.size).minBy(_._2)._1
  }

  def solution(input:List[String]): Int ={
    convertBinaryToDecimal(findGammaRate(input)) * convertBinaryToDecimal(findEpsilonRate(input))
  }

}

