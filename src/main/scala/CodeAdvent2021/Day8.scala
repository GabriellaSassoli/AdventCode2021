package CodeAdvent2021

import CodeAdvent2021.Day6.{Lanternfishes, createLanternfishMap, lanternfishCycle, lanternfisheGrowpart2, readInput, sumMapValues}

import scala.io.Source

object Day8 {
  // read input
  def main(args: Array[String]): Unit = {
    val input: Lanternfishes = readInput("2021/Day6Input.txt")
  }

  def readInput(filepath: String): Lanternfishes =
    Source.fromResource(filepath).getLines.toList.flatMap(lanternfish=> lanternfish.split(",")).map(_.toInt)


}
