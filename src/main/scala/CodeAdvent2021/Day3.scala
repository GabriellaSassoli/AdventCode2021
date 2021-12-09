package CodeAdvent2021

import scala.io.Source
import scala.io.Source.DefaultBufSize.>

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

  def findLeastCommonElementInCollection[A](coll: Seq[A]): A = {
    coll.groupBy(identity).view.mapValues(_.size).minBy(_._2)._1
  }

  def solution(input:List[String]): Int ={
    convertBinaryToDecimal(findGammaRate(input).mkString) * convertBinaryToDecimal(findEpsilonRate(input).mkString)
  }

  //part 2
  def solutionPart2(input:List[String]): Int = {
    convertBinaryToDecimal(OxygenGeneratorRating(input)) * convertBinaryToDecimal(CO2ScrubberRating(input))
  }

  def OxygenGeneratorRating(input:List[String]): String = {
    getRating(mostLeastCommonNumber = findGammaRate,input = input)
    }

  def CO2ScrubberRating(input:List[String]): String = {
    getRating(mostLeastCommonNumber = leastCommon,input = input)
  }

  def leastCommon(input:List[String]) = {
    val sizeMap = input.transpose.map {
          value => value.groupBy(identity).view.mapValues(_.size)}

    sizeMap.collect{
      case value if value.get('1') == value.get('0') => '0'
      case value => value.minBy(_._2)._1
    }
  }

  //recursive function calling different function as required
  def getRating(result: Seq[Any] = Seq.empty,
                mostLeastCommonNumber: List[String] => Seq[Char],
                input: List[String]
                     ): String = {
    mostLeastCommonNumber(input) match {

      case commonNumber :: Nil =>

        (result :+ commonNumber).mkString

      case commonNumber :: _ =>
        val filteredValues: List[String] = input.filter{ number => number.startsWith(commonNumber.toString) }.collect(x => x.tail)
        getRating(result :+ commonNumber, mostLeastCommonNumber, filteredValues)
    }
  }


}

