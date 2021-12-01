package CodeAdvent2020

import scala.::
import scala.io.Source

object day3 {
  def main(args: Array[String]): Unit = {

    val input = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/scala/CodeAdvent2020/Day3Input").getLines.toArray
    val grill: Array[Array[Char]] = input.map(line => line.toArray)
    val height: Int = input.length
    val length: Array[Int] = input
                              .map{line => line.length}
                              .distinct

    if (length.length > 1) println("The lines are not all the same length, please insert new input")
    else {
      val trees: Seq[Char] = for {
        lineMove <- 0 to length.head by 3 /// I need to start from 0 everytime 31 is reached.
        heightMove <- 0 to height by 1
        if (grill(lineMove)(heightMove) == "#")
      } yield {
        grill(lineMove)(heightMove)
      }

      println(trees.length)
      println(height)

      length.foreach(println)
    }
  }

}
