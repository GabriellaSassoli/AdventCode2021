package CodeAdvent2021



import CodeAdvent2021.Day5.{getStep, getVentilatorsPosition}

import scala.io.Source


object Day5 {

  val lineRegex = "(\\d+),(\\d+) -> (\\d+),(\\d+)".r

  case class Position(x: Int, y: Int)

  case class VentilatorStartEndPosition(start: Position, end: Position)

  type VentilatorsPositions = Seq[Position]

  def main(args: Array[String]): Unit = {
    val input: Seq[String] = readInput("2021/Day5Input.txt")

    val resultPart1 = input.map { line => parse(line) }
      .filter(positions => filterCoordinates(positions))
      .flatMap(position => getVentilatorsPosition(position))
      .groupBy(obj => obj)
      .count(value => value._2.length >= 2)

    println(s"Result part1: $resultPart1")

    // Note every corner between coordinates is 45 degrees for triangles properties

    val resultPart2 =
      input.map{line => parse(line)}
        .flatMap(position => getVentilatorsPosition(position))
        .groupBy(obj => obj)
        .count(value => value._2.length >= 2)
    println(s"resultPart2 $resultPart2")

  }

  def readInput(filepath: String): Seq[String] =
    Source.fromResource(filepath).getLines.toList

  def parse(line: String): VentilatorStartEndPosition =
    line match {
      case lineRegex(x1, y1, x2, y2) => VentilatorStartEndPosition(Position(x1.toInt, y1.toInt), Position(x2.toInt, y2.toInt))
    }

  def filterCoordinates(position: VentilatorStartEndPosition): Boolean =
    position.start.x == position.end.x || position.start.y == position.end.y

  def getVentilatorsPosition(point: VentilatorStartEndPosition): VentilatorsPositions = {
    if (point.start.x == point.end.x) {
      val loopStep = getStep(point.start.y, point.end.y)

      (point.start.y to point.end.y by loopStep).collect{
        case cell => Position(point.start.x, cell)
      }
    }
    else if (point.start.y == point.end.y) {
      val loopStep = getStep(point.start.x, point.end.x)

      (point.start.x to point.end.x by loopStep).collect {
        case cell => Position(cell, point.start.y)
      }
    }
    else {
      getDiagonalPosition(point)
    }
  }

  def getDiagonalPosition(point: VentilatorStartEndPosition) : VentilatorsPositions = {
    val loopStepX = getStep(point.start.x,point.end.x)
    val loopStepY = getStep(point.start.y,point.end.y)

    ((point.start.x to point.end.x by loopStepX) zip (point.start.y to point.end.y by loopStepY)).collect{
      case cell => Position(cell._1, cell._2)
    }
  }

  def getStep(value1: Int, value2: Int): Int = {
    if (value1 > value2) -1
    else 1
  }

}