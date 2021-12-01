package CodeAdvent2021

import scala.io.Source

object Day1 {

  def main(args: Array[String]): Unit = {
    val input = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/scala/CodeAdvent2021/Day1Input").getLines.toArray
    val inputNumbers: Array[Int] = input.map(number => number.toInt)

//  Refactoring

    println(s"Step of one: ${increase(1, inputNumbers).length}")
    println(s"Step of three: ${increase(3, inputNumbers).length}")

    println(s"Step of one: ${increaseFunctional(1, inputNumbers)}")
    println(s"Step of three: ${increaseFunctional(3, inputNumbers)}")

    def increase(stepNumber: Int, values: Seq[Int]): Seq[Int] = {
      for {
        i <- 0 to (values.length - 1 - stepNumber)
        if sumValues(values.slice(i, i + stepNumber )) < sumValues(values.slice(i + 1, i + 1 + stepNumber))
      } yield {
        values(i)
      }
    }

    def increaseFunctional(stepNumber: Int, values: Seq[Int]): Int = {
      (0 to (values.length - 1 - stepNumber))
        .collect{case i if sumValues(values.slice(i, i + stepNumber )) < sumValues(values.slice(i + 1, i + 1 + stepNumber)) => values(i)}
        .length
    }

    def sumValues(values: Seq[Int]): Int = {
      values.reduceLeft {
        _ + _
      }
    }
  }
}
