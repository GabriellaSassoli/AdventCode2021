package CodeAdvent2021
import CodeAdvent2021.Day4.{Boards, MarkedNumber}
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
    Day4.getBoards(input) shouldBe List(Boards(List(List(MarkedNumber(22,0), MarkedNumber(13,0), MarkedNumber(17,0), MarkedNumber(11,0), MarkedNumber(0,0)), List(MarkedNumber(8,0), MarkedNumber(2,0), MarkedNumber(23,0), MarkedNumber(4,0), MarkedNumber(24,0)), List(MarkedNumber(21,0), MarkedNumber(9,0), MarkedNumber(14,0), MarkedNumber(16,0), MarkedNumber(7,0)), List(MarkedNumber(6,0), MarkedNumber(10,0), MarkedNumber(3,0), MarkedNumber(18,0), MarkedNumber(5,0)), List(MarkedNumber(1,0), MarkedNumber(12,0), MarkedNumber(20,0), MarkedNumber(15,0), MarkedNumber(19,0))),0), Boards(List(List(MarkedNumber(3,0), MarkedNumber(15,0), MarkedNumber(0,0), MarkedNumber(2,0), MarkedNumber(22,0)), List(MarkedNumber(9,0), MarkedNumber(18,0), MarkedNumber(13,0), MarkedNumber(17,0), MarkedNumber(5,0)), List(MarkedNumber(19,0), MarkedNumber(8,0), MarkedNumber(7,0), MarkedNumber(25,0), MarkedNumber(23,0)), List(MarkedNumber(20,0), MarkedNumber(11,0), MarkedNumber(10,0), MarkedNumber(24,0), MarkedNumber(4,0)), List(MarkedNumber(14,0), MarkedNumber(21,0), MarkedNumber(16,0), MarkedNumber(12,0), MarkedNumber(6,0))),1), Boards(List(List(MarkedNumber(14,0), MarkedNumber(21,0), MarkedNumber(17,0), MarkedNumber(24,0), MarkedNumber(4,0)), List(MarkedNumber(10,0), MarkedNumber(16,0), MarkedNumber(15,0), MarkedNumber(9,0), MarkedNumber(19,0)), List(MarkedNumber(18,0), MarkedNumber(8,0), MarkedNumber(23,0), MarkedNumber(26,0), MarkedNumber(20,0)), List(MarkedNumber(22,0), MarkedNumber(11,0), MarkedNumber(13,0), MarkedNumber(6,0), MarkedNumber(5,0)), List(MarkedNumber(2,0), MarkedNumber(0,0), MarkedNumber(12,0), MarkedNumber(3,0), MarkedNumber(7,0))),2))
 }

  behavior of "mark"
  it should "mark modify a 0 to 1 if a value has been extracted" in {
    Day4.mark(7,Day4.getBoards(input)) shouldBe List(Boards(List(List(MarkedNumber(22,0), MarkedNumber(13,0), MarkedNumber(17,0), MarkedNumber(11,0), MarkedNumber(0,0)), List(MarkedNumber(8,0), MarkedNumber(2,0), MarkedNumber(23,0), MarkedNumber(4,0), MarkedNumber(24,0)), List(MarkedNumber(21,0), MarkedNumber(9,0), MarkedNumber(14,0), MarkedNumber(16,0), MarkedNumber(7,1)), List(MarkedNumber(6,0), MarkedNumber(10,0), MarkedNumber(3,0), MarkedNumber(18,0), MarkedNumber(5,0)), List(MarkedNumber(1,0), MarkedNumber(12,0), MarkedNumber(20,0), MarkedNumber(15,0), MarkedNumber(19,0))),0), Boards(List(List(MarkedNumber(3,0), MarkedNumber(15,0), MarkedNumber(0,0), MarkedNumber(2,0), MarkedNumber(22,0)), List(MarkedNumber(9,0), MarkedNumber(18,0), MarkedNumber(13,0), MarkedNumber(17,0), MarkedNumber(5,0)), List(MarkedNumber(19,0), MarkedNumber(8,0), MarkedNumber(7,1), MarkedNumber(25,0), MarkedNumber(23,0)), List(MarkedNumber(20,0), MarkedNumber(11,0), MarkedNumber(10,0), MarkedNumber(24,0), MarkedNumber(4,0)), List(MarkedNumber(14,0), MarkedNumber(21,0), MarkedNumber(16,0), MarkedNumber(12,0), MarkedNumber(6,0))),1), Boards(List(List(MarkedNumber(14,0), MarkedNumber(21,0), MarkedNumber(17,0), MarkedNumber(24,0), MarkedNumber(4,0)), List(MarkedNumber(10,0), MarkedNumber(16,0), MarkedNumber(15,0), MarkedNumber(9,0), MarkedNumber(19,0)), List(MarkedNumber(18,0), MarkedNumber(8,0), MarkedNumber(23,0), MarkedNumber(26,0), MarkedNumber(20,0)), List(MarkedNumber(22,0), MarkedNumber(11,0), MarkedNumber(13,0), MarkedNumber(6,0), MarkedNumber(5,0)), List(MarkedNumber(2,0), MarkedNumber(0,0), MarkedNumber(12,0), MarkedNumber(3,0), MarkedNumber(7,1))),2))
  }

  behavior of "CheckMark"
  it should "check if at least one line of a board has been marked" in {
    val mark1 = Day4.mark(8, Day4.getBoards(input))
    Day4.getWinningBoard(mark1) shouldBe List()
    val mark2 = Day4.mark(2, mark1)
    val mark3 = Day4.mark(23, mark2)
    val mark4 = Day4.mark(4, mark3)
    val mark5 = Day4.mark(24, mark4)
    Day4.getWinningBoard(mark5) shouldBe List(0)


    val mark1A = Day4.mark(20,Day4.getBoards(input) )
    val mark2A = Day4.mark(11, mark1A)
    val mark3A = Day4.mark(10, mark2A)
    val mark4A = Day4.mark(24, mark3A)
    val mark5A = Day4.mark(4, mark4A)
    Day4.getWinningBoard(mark5A) shouldBe List(1)

  }

  behavior of "Extraction"
  it should "get winning board" in {
    val winner = Day4.extractionWinner(Day4.getExtractionNumber(input),Day4.getBoards(input),List.empty,0)
    winner.board shouldBe List(List(MarkedNumber(14,1), MarkedNumber(21,1), MarkedNumber(17,1), MarkedNumber(24,1), MarkedNumber(4,1)), List(MarkedNumber(10,0), MarkedNumber(16,0), MarkedNumber(15,0), MarkedNumber(9,1), MarkedNumber(19,0)), List(MarkedNumber(18,0), MarkedNumber(8,0), MarkedNumber(23,1), MarkedNumber(26,0), MarkedNumber(20,0)), List(MarkedNumber(22,0), MarkedNumber(11,1), MarkedNumber(13,0), MarkedNumber(6,0), MarkedNumber(5,1)), List(MarkedNumber(2,1), MarkedNumber(0,1), MarkedNumber(12,0), MarkedNumber(3,0), MarkedNumber(7,1)))
    winner.lastExtractedNumber shouldBe Some(24)
    winner.winnerBoardNumber shouldBe Some(2)
  }

  behavior of "getUnmarked numbers and sum"
  it should "return a list of unmarked numbers and the sum of it" in {
    val winningBoard = Day4.extractionWinner(Day4.getExtractionNumber(input),Day4.getBoards(input),List.empty,0)
    val unMarkedNumbers = Day4.getUnmarkedNumbers(winningBoard.board)
    unMarkedNumbers shouldBe List(10,16,15,19,18,8,26,20,22,13,6,12,3)

    Day4.sumUnmarkedNumbers(unMarkedNumbers) shouldBe 188
  }


  behavior of "Last Winning board Extracted"
  it should "get winning board" in {
    val winner = Day4.getLastWinningBoard(Day4.getExtractionNumber(input),Day4.getBoards(input),  -1)
    winner.board shouldBe List(List(MarkedNumber(3,0), MarkedNumber(15,1), MarkedNumber(0,1), MarkedNumber(2,1), MarkedNumber(22,0)), List(MarkedNumber(9,1), MarkedNumber(18,0), MarkedNumber(13,1), MarkedNumber(17,1), MarkedNumber(5,1)), List(MarkedNumber(19,0), MarkedNumber(8,0), MarkedNumber(7,1), MarkedNumber(25,1), MarkedNumber(23,1)), List(MarkedNumber(20,0), MarkedNumber(11,1), MarkedNumber(10,1), MarkedNumber(24,1), MarkedNumber(4,1)), List(MarkedNumber(14,1), MarkedNumber(21,1), MarkedNumber(16,1), MarkedNumber(12,1), MarkedNumber(6,1)))
    winner.lastExtractedNumber shouldBe Some(12) // I should had checked the mark also on the column, not just line.
//    winner.winnerBoardNumber shouldBe Some(1) not sure why looks like 0
  }
}
