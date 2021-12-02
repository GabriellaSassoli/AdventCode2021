package CodeAdvent2021

import scala.io.Source

object Day1 {

  def main(args: Array[String]): Unit = {
    val input = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/scala/CodeAdvent2021/Day1Input").getLines.toArray
    val inputNumbers: Array[Int] = input.map(number => number.toInt)

    println(s"Step of one: ${numberOfIncreases(1, inputNumbers)}")
    println(s"Step of three: ${numberOfIncreases(3, inputNumbers)}")
  }

    def numberOfIncreases(step: Int, values: Seq[Int]): Int = {
      (0 to (values.length - 1 - step))
        .collect{case i if values.slice(i, i + step).sum < values.slice(i + 1, i + 1 + step).sum => values(i)}
        .length
    }



}
