package CodeAdvent2021

import CodeAdvent2021.Day4.solution

import scala.annotation.tailrec
import scala.io.Source

object Day4 {

  case class MarkedNumber(value:Int, mark: Int)
  type row = Seq[MarkedNumber]
  case class Boards(board: Seq[row], boardIndex: Int) // would be nice to delete seq now that is unused
  case class Winner(board: Seq[row], lastExtractedNumber: Option[Int], winnerBoardNumber: Option[Int])


 def solution(input:List[String]): (Int,Int) ={

   val boards = getBoards(input)
   val extractionNumbers: Seq[Int] = getExtractionNumber(input)
   val winner: Winner = extractionWinner(extractionNumbers,boards,List.empty, -1)
   val unMarkedNumbers = getUnmarkedNumbers(winner.board)
   val sum = sumUnmarkedNumbers(unMarkedNumbers)
   val resultPart1 = winner.lastExtractedNumber match {
     case Some(extractedNumber) => sum * extractedNumber
     case None => 0
   }

   //part2 use part 1 but run winner without old board that has won, in the previous round. when no board is found then stop and get last result.
   val winnerPart2 = getLastWinningBoard(extractionNumbers,boards, -1)
   val unMarkedNumbersPart2 = getUnmarkedNumbers(winnerPart2.board)
   val sumPart2 = sumUnmarkedNumbers(unMarkedNumbersPart2)
   val resultPart2 = winnerPart2.lastExtractedNumber match {
     case Some(extractedNumberPart2) => sumPart2 * extractedNumberPart2
     case None => 0
   }

   (resultPart1, resultPart2)
 }

  def getLastWinningBoard(extractionNumbers: Seq[Int], boards: Seq[Boards], winnerBoardNumber: Int): Winner ={

    val boardWinner = extractionWinner(extractionNumbers, boards, Seq.empty, -1)
    val boardsWithoutWinner = boards.collect{
                              case value if (value.boardIndex != boardWinner.winnerBoardNumber.get) => Boards(value.board,value.boardIndex)
                            }

    boardWinner.winnerBoardNumber match {
      case Some(boardNumber) =>{
        println(boardNumber)
        if (boardNumber == winnerBoardNumber) Winner(boardWinner.board, boardWinner.lastExtractedNumber, Some(winnerBoardNumber))
        else getLastWinningBoard(extractionNumbers, boardsWithoutWinner, boardNumber)
      }
      case None => {Winner(boardWinner.board, boardWinner.lastExtractedNumber, Some(winnerBoardNumber))}
    }
  }

  def sumUnmarkedNumbers(unmarkedNumbers: Seq[Int]): Int =
    unmarkedNumbers.sum

  def getUnmarkedNumbers(winnerBoard: Seq[row]): Seq[Int]= {
    winnerBoard.collect{value =>
        value.filter{number => number.mark == 0}
        .map(number => number.value)}
        .flatten
  }

  @tailrec
  def extractionWinner(extractionNumbers:Seq[Int], boards: Seq[Boards], winningBoard: Seq[Int], lastExtractedNumber: Int ): Winner ={
      winningBoard match {
        case Nil => {
                      val markedBoards: Seq[Boards] = mark(extractionNumbers.head, boards)
                      extractionWinner(extractionNumbers.tail, markedBoards, getWinningBoard(markedBoards), extractionNumbers.head)
                    }
        case List(winner) => Winner(WinningBoard(boards, winner), Some(lastExtractedNumber), Some(winner))

      }
  }

  private def WinningBoard(boards: Seq[Boards], winnerBoard: Int) = {
    boards.collect {
      case board if (board.boardIndex == winnerBoard) => board.board
    }.flatten
  }

  def getWinningBoard(boards: Seq[Boards]): Seq[Int] = // checking only that the line is marked and not the column as well hence why I have the wrong answer for part 2.
    boards.collect{
      boardMatrix => boardMatrix.board
        .map { line => line.map(value => value.mark) }
        .flatMap { value => if (value.sum == 5) Some(boardMatrix.boardIndex) else None }
    }.flatten


  def mark(extractedNumber: Int, boards: Seq[Boards]): Seq[Boards] = {
      boards.map{ boardMatrix =>
        boardMatrix.board.map{line =>
          line.map{value =>
            if(value.value == extractedNumber) value.copy(mark = 1)
            else value
          }
        }
      }.zipWithIndex
        .map(value => Boards(value._1,value._2))
  }

  def getExtractionNumber(input: List[String]): List[Int]={
    input.splitAt(1)._1.flatMap(_.split(",")).map{_.toInt}
  }

  def getBoards(input: List[String]): Seq[Boards] = {

    val noSelection = Array.fill(input.length * 5)(0)
    val boards: Seq[Int] = input.splitAt(1)._2.filter(_.size > 0).flatMap(_.split(" +").toList.flatMap(_.toIntOption))

    val indexBoards: Seq[(List[row], Int)] = boards
      .grouped(25)
      .map{ lines => lines.grouped(5)
        .map{
        value => value.zip(noSelection)
        }.map{
        value => value.map{
          numbermark => MarkedNumber(numbermark._1,numbermark._2)
        }
      }.toList
      }.toList.zipWithIndex

    indexBoards.map{
      board =>
      Boards(board._1,board._2)
    }
  }
}

object Day4Main {

  def main(args: Array[String]): Unit = {
    val input = getInput("src/main/resources/2021/Day4Input")
    println(solution(input))
  }

  def getInput(fileLocation:String): List[String] =
    Source.fromFile(fileLocation).getLines.toList
}
