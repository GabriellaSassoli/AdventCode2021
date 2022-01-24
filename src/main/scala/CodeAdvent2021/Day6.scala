package CodeAdvent2021

import CodeAdvent2021.Day5.{filterCoordinates, getVentilatorsPosition, parse, readInput}

import scala.::
import scala.io.Source

object Day6 {

  type Lanternfishes = Seq[Int]

  def main(args: Array[String]): Unit = {
    val input: Lanternfishes = readInput("2021/Day6Input.txt")
    println(input)
    println(lanternfishCycle(input,0,80).size)
  }

  // idea recursive function that takes one -1 off except if 0 then becomes 6 and adds a new entry.
  def readInput(filepath: String): Lanternfishes =
    Source.fromResource(filepath).getLines.toList.flatMap(lanternfish=> lanternfish.split(",")).map(_.toInt)

  //returns the new fishes
  def lanternfishCycle(lanternfishes: Lanternfishes, day: Int, nDaysTotal: Int): Seq[Int] ={
    if (day < nDaysTotal){
      val newLanternfishes: Seq[Int] = (0 to (lanternfishes.length - 1)).flatMap{
         lanternfishIndex =>
           if (lanternfishes(lanternfishIndex) == 0){
            Seq(6,8)
           } else {
            Seq(lanternfishes(lanternfishIndex) - 1)
           }
      }
      lanternfishCycle(newLanternfishes,day + 1, nDaysTotal)
    }
    else{
      lanternfishes
    }

  }
}
