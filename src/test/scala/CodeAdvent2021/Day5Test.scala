package CodeAdvent2021

import CodeAdvent2021.Day4Main.getInput
import CodeAdvent2021.Day5.{Coordinates, Grill}
import org.scalatest.{FlatSpec, Matchers}

import scala.Console.in

class Day5Test extends FlatSpec with Matchers {

  val testFilePath = "src/test/resources/test-input-5"
  val input: Seq[String] = getInput(testFilePath)

  behavior of "parse"
  it should "return parsed input" in {
    Day5.parse("5,5 -> 8,2")
  }
  behavior of "GrillCoordinates"
  it should "return tuple of grill coordinates" in  {
    println(Day5.grillCoordinates(input))
    Day5.grillCoordinates(input) shouldBe List((Coordinates(0,9),Coordinates(5,9)), (Coordinates(8,0),Coordinates(0,8)), (Coordinates(9,4),Coordinates(3,4)), (Coordinates(2,2),Coordinates(2,1)), (Coordinates(7,0),Coordinates(7,4)), (Coordinates(6,4),Coordinates(2,0)), (Coordinates(0,9),Coordinates(2,9)), (Coordinates(3,4),Coordinates(1,4)), (Coordinates(0,0),Coordinates(8,8)), (Coordinates(5,5),Coordinates(8,2)))
  }

  behavior of "createGrill"
  it should "return an empty grill of 10 X 10" in {
    val grill: Grill = Day5.createGrill(Day5.grillCoordinates(input))
    grill.length shouldBe 10
    grill.map(_.length) shouldBe Array(10, 10, 10, 10, 10, 10, 10, 10, 10,10)
  }

  behavior of "coordinatesConsidered"
  it should "return a grill filled with every value" in {
    val coordinates = Day5.grillCoordinates(input)
    Day5.coordinatesConsidered(coordinates) shouldBe List((Coordinates(0,9),Coordinates(5,9)), (Coordinates(9,4),Coordinates(3,4)), (Coordinates(2,2),Coordinates(2,1)), (Coordinates(7,0),Coordinates(7,4)), (Coordinates(0,9),Coordinates(2,9)), (Coordinates(3,4),Coordinates(1,4)))
  }

  behavior of "fillGrill"
  it should "return a grill with the correct elements filled" in {
    val grill: Grill = Day5.createGrill(Day5.grillCoordinates(input))
    val coordinates = Day5.grillCoordinates(input)

    Day5.fillGrill(grill,Day5.coordinatesConsidered(coordinates)) shouldBe Array(Array(0, 0, 0, 0, 0, 0, 0, 1, 0, 0), Array(0, 0, 1, 0, 0, 0, 0, 1, 0, 0), Array(0, 0, 1, 0, 0, 0, 0, 1, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 1, 0, 0), Array(0, 1, 1, 2, 1, 1, 1, 2, 1, 1), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(2, 2, 2, 1, 1, 1, 0, 0, 0, 0))
  }

  behavior of "add"
  it should "add a value in the grill" in {
    val grill: Grill = Array(Array(0,5,0,0,2))
    Day5.add(grill, Coordinates(0,1)) shouldBe 6
    Day5.add(grill, Coordinates(0,2)) shouldBe 1
    Day5.add(grill, Coordinates(0,4)) shouldBe 3
  }

  behavior of "getOverlapsPoints"
  it should "Return number of points greater than 1" in {
    val grill: Grill = Array(Array(0,5,0,1,2))
    Day5.getOverlapsPoints(grill) shouldBe 2
  }

}
