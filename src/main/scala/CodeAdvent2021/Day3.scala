package CodeAdvent2021

import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

import java.security.Identity
import scala.io.Source

object Day3 {

  def main(args: Array[String]): Unit = {
    /// dividere strings into array of ones, count how many 1 present in first element of every array and ( other function) finally if count is greater than half height gamma 1 epsilon 0 or other way round
    val input: List[String] = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/resources/Day3Input").getLines.toList
    println(convertBinaryToDecimal(findGammaRate(input)) * convertBinaryToDecimal(findEpsilonRate(input)))

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

  private def findMostCommonElementInCollection[A](coll: Seq[A]): A = {
    coll.groupBy(identity).view.mapValues(_.size).maxBy(_._2)._1
  }

  private def findLeastCommonElementInCollection[A](coll: Seq[A]): A = { //read more on this notation.
    coll.groupBy(identity).view.mapValues(_.size).minBy(_._2)._1
  }

}









//  def getOnesPerLine(input:Array[Array[Char]])={
//
//
//    for{
//      i <- 0 to (input(0).length - 1)
//      line <- input
//      if( line(i) == '1')
//    }yield{
////      println(s"the line is  ${line(i)} : ${line(i) == '1'}, the i is $i")
//      (i,line(i))/// put elements in dictionary and sum
//    }
//  }





//    input match {
//
//      case inputHello :: Nil =>
//        println(inputHello)
//
//
//      case inputHello :: tail =>
//        println(inputHello)
//
//    }

//}
