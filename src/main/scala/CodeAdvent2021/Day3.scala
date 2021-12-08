package CodeAdvent2021

import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

import java.security.Identity
import scala.::
import scala.io.Source

object Day3 {

  def main(args: Array[String]): Unit = {
    val input: List[String] = readInput("src/main/resources/Day3Input")
    println(solution(input))
    println(solutionPart2(input))

  }

  def readInput(filepath: String) = {
    Source.fromFile(filepath).getLines.toList
  }

  def findGammaRate(input: List[String]): Seq[Char] = {
    input.transpose.map(findMostCommonElementInCollection)
  }

  def findEpsilonRate(input: List[String]): Seq[Char] = {
    input.transpose.map(findLeastCommonElementInCollection)
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
    convertBinaryToDecimal(findGammaRate(input).mkString) * convertBinaryToDecimal(findEpsilonRate(input).mkString)
  }

  def solutionPart2(input:List[String]): Int = {
    convertBinaryToDecimal(OxygenGeneratorRating(input)) * convertBinaryToDecimal(CO2ScrubberRating(input))
  }

  def OxygenGeneratorRating(input:List[String]): String = {
    // need to do a getOxygenRating function. I'll start with doing just the first one :)
    getRating(mostCommonNumber = findGammaRate,input = input)
    }

  def CO2ScrubberRating(input:List[String]): String = {
    getRating(mostCommonNumber = findEpsilonRate,input = input)
  }


  //recursive function calling different function as required
  def getRating(result: Seq[Any] = Seq.empty,
                      mostCommonNumber: List[String] => Seq[Char],
                      input: List[String]
                     ): String = {
    mostCommonNumber(input) match {

      case _ :: Nil =>

        result.mkString

      case commonNumber :: _ =>

        val filteredValues: List[String] = input.filter{ number => number.startsWith(commonNumber.toString) }.collect(x => x.tail)
        getRating(result :+ commonNumber, mostCommonNumber, filteredValues)
    }
  }

}

