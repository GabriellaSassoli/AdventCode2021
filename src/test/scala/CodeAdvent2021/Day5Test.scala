package CodeAdvent2021

import CodeAdvent2021.Day4Main.getInput
import CodeAdvent2021.Day5.{Position, VentilatorStartEndPosition}
import org.scalatest.{FlatSpec, Matchers}
import sun.font.TrueTypeFont

import scala.Console.in

class Day5Test extends FlatSpec with Matchers {

  val testFilePath = "src/test/resources/test-input-5"
  val input: Seq[String] = getInput(testFilePath)

  behavior of "parse"
  it should "return parsed input" in {
    Day5.parse("5,5 -> 8,2")
  }


  behavior of "filterCoordinates"
  it should "return a boolean to say if value is valid or not" in {
    val coordinatesToFilterTrue = VentilatorStartEndPosition(Position(1,0), Position(0,0))
    val coordinatesToFilterFalse = VentilatorStartEndPosition(Position(1,1), Position(0,0))

    Day5.filterCoordinates(coordinatesToFilterTrue) shouldBe true
    Day5.filterCoordinates(coordinatesToFilterFalse) shouldBe false
  }

  behavior of "getVentilatorsPosition"
  it should "return list of points with Ventilators" in {
    val coordinatesStartEndPositionsX = VentilatorStartEndPosition(Position(0,0), Position(0,2))
    val coordinatesStartEndPositionsY= VentilatorStartEndPosition(Position(2,0), Position(0,0))
    val coordinatesStartEndPositionsDiagonal = VentilatorStartEndPosition(Position(3,1), Position(0,0))

    Day5.getVentilatorsPosition(coordinatesStartEndPositionsX) shouldBe Seq(Position(0,0), Position(0,1),Position(0,2))
    Day5.getVentilatorsPosition(coordinatesStartEndPositionsY) shouldBe Seq(Position(2,0), Position(1,0), Position(0,0))
    Day5.getVentilatorsPosition(coordinatesStartEndPositionsDiagonal) shouldBe Seq(Position(3,1), Position(2,0))

  }

  behavior of "getStartEndLoop"
  it should "return the smallest value as first value and the biggest as second value" in {

    Day5.getStep(0,4) shouldBe 1
    Day5.getStep(4,0) shouldBe -1
    Day5.getStep(0,0) shouldBe 1

  }

  behavior of "getDiagonalPosition"
  it should "return diagonal points" in {

    Day5.getDiagonalPosition(VentilatorStartEndPosition(Position(1,1), Position(3,3))) shouldBe Seq(Position(1,1), Position(2,2),Position(3,3))
    Day5.getDiagonalPosition(VentilatorStartEndPosition(Position(9,7), Position(7,9))) shouldBe Seq(Position(9,7), Position(8,8),Position(7,9))
  }

}
