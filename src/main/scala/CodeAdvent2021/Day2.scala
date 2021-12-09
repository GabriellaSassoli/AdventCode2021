package CodeAdvent2021

import scala.io.Source


object Day2 {

  val lineRegex = "(\\w+) (\\d+)".r
  case class Movement(direction: String, step: Int)

  def main(args: Array[String]): Unit = {
    val input: Array[String] = Source.fromResource("2021/Day1Input.txt").getLines.toArray


    val finalPositionSolution = finalPosition(input)
    val product: Int = -(finalPositionSolution._1 * finalPositionSolution._2)
    println(product)

    val finalPositionAim = finalPosition2(input)
    val product2: Int = -(finalPositionAim._1 * finalPositionAim._2)
    println(s"product 2 is :$product2")

  }

  def move(movement: Movement): (Int, Int) = {
    movement.direction match {
      case "up" => (movement.step, 0)
      case "forward" => (0, movement.step)
      case "down" => (-movement.step, 0)
    }
  }

  def finalPosition(input:Array[String])={
    input
      .map{ line => parse(line)}
      .map{ movement => move(movement)}
      .foldLeft(0,0){case ((a,b),(c,d)) => (a+c,b+d)}
  }

  def parse(line: String): Movement =
    line match {
      case lineRegex(direction, movement) => Movement(direction, movement.toInt)
    }


  /// part 2

  def move2(movement: Movement): (Int, Int, Int, Boolean) = {
      movement.direction match {
      case "up" => (0, 0, -movement.step, false)
      case "forward" => (movement.step, 0,0, true)
      case "down" => (0, 0, movement.step, false)
      }
    }



  def finalPosition2(input:Array[String]) = {
    input
      .map{ line => parse(line)}
      .map{ movement => move2(movement)}
      .foldLeft(0,0,0,false){
        case((x1,y1,aim1,isForward1),(x2,y2,aim2,isForward2))
          if isForward2 == true  => {
          (x1 + x2, y1 +y2 + (aim1 * x2), aim2 +aim1,false)
        }
        case ((x1,y1,aim1,isForward1),(x2,y2,aim2,isForward2))
          if isForward2 == false =>{
          (x1 + x2, y1 + y2, aim2 +aim1,false)}
      }
  }

}
