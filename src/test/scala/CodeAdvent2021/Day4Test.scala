package CodeAdvent2021
import CodeAdvent2021.Day4.Boards
import CodeAdvent2021.Day4Main.getInput
import org.scalatest.{FlatSpec, FunSuite, Matchers}

class Day4Test extends FlatSpec with Matchers {

  val testFilePath = "src/test/resources/test-input-4"
  val input= getInput(testFilePath)

  behavior of "get Extraction numbers"
  it should "return the extraction numbers" in {
    Day4.getExtractionNumber(input) shouldBe List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
  }

  behavior of "get Boards"
  it should "split the input into boards" in {
    println(Day4.getBoards(input))
    Day4.getBoards(input) shouldBe Boards(List((List(List((22,0), (13,0), (17,0), (11,0), (0,0)), List((8,0), (2,0), (23,0), (4,0), (24,0)), List((21,0), (9,0), (14,0), (16,0), (7,0)), List((6,0), (10,0), (3,0), (18,0), (5,0)), List((1,0), (12,0), (20,0), (15,0), (19,0))),0), (List(List((3,0), (15,0), (0,0), (2,0), (22,0)), List((9,0), (18,0), (13,0), (17,0), (5,0)), List((19,0), (8,0), (7,0), (25,0), (23,0)), List((20,0), (11,0), (10,0), (24,0), (4,0)), List((14,0), (21,0), (16,0), (12,0), (6,0))),1), (List(List((14,0), (21,0), (17,0), (24,0), (4,0)), List((10,0), (16,0), (15,0), (9,0), (19,0)), List((18,0), (8,0), (23,0), (26,0), (20,0)), List((22,0), (11,0), (13,0), (6,0), (5,0)), List((2,0), (0,0), (12,0), (3,0), (7,0))),2)))

 }

}
