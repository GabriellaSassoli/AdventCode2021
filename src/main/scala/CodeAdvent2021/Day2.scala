package CodeAdvent2021

import scala.io.Source

object Day2 {

  val lineRegex = "(\\w+) (\\d+)".r
  case class Movement(direction: String, step: Int)

  def main(args: Array[String]): Unit = {
    val input = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/scala/CodeAdvent2021/Day2Input").getLines.toArray

    val finalPosition: (Int, Int) = input
      .map{ line => parse(line)}
      .map{ movement => move(movement)}
      .foldLeft(0,0){case ((a,b),(c,d)) => (a+c,b+d)}

    val product: Int = -(finalPosition._1 * finalPosition._2)
    println(product)
  }

  def move(movement: Movement): (Int, Int) = {
    movement.direction match {
      case "up" => (movement.step, 0)
      case "forward" => (0, movement.step)
      case "down" => (-movement.step, 0)
    }
  }

  def parse(line: String): Movement =
    line match {
      case lineRegex(direction, movement) => Movement(direction, movement.toInt)
    }
}
