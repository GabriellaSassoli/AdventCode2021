package CodeAdvent2021

import CodeAdvent2021.Day4.solution

import scala.annotation.tailrec
import scala.io.Source

object Day4 {

  case class Boards(board: List[(List[Seq[(Int, Int)]], Int)]) // create 2 values second called boardIndex
  case class Winner(board: Seq[Seq[(Int, Int)]], lastExtractedNumber: Option[Int], winnerBoardNumber: Option[Int])


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

  def getLastWinningBoard(extractionNumbers: Seq[Int],boards: Boards, winnerBoardNumber: Int): Winner ={

    val boardWinner = extractionWinner(extractionNumbers, boards, Seq.empty, -1)
    val boardsWithoutWinner = Boards(boards.board.filter{boardMatrix => boardMatrix._2 != boardWinner.winnerBoardNumber.get})

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

  def getUnmarkedNumbers(winnerBoard: Seq[Seq[(Int, Int)]]): Seq[Int]= {
    winnerBoard.collect{value =>
        value.filter{number => number._2 == 0}
        .map(number => number._1)}
        .flatten
  }

  @tailrec
  def extractionWinner(extractionNumbers:Seq[Int], boards: Boards, winningBoard: Seq[Int], lastExtractedNumber: Int ): Winner ={
      winningBoard match {
        case Nil => {
                      if (extractionNumbers.tail == Nil){
                        Winner(Seq.empty, None, None)
                      }else {
                        val markedBoards: Boards = mark(extractionNumbers.head, boards)
                        extractionWinner(extractionNumbers.tail, markedBoards, getWinningBoard(markedBoards), extractionNumbers.head)
                      }
                    }
        case List(winner) => Winner(boards.board(winner)._1, Some(lastExtractedNumber), Some(winner))
      }
  }

  def getWinningBoard(boards: Boards): Seq[Int] = // checking only that the line is marked and not the column as well hence why I have the wrong answer for part 2.
    boards.board.collect{
      boardMatrix => boardMatrix._1
        .map{ line => line.map(value => value._2)}
        .map{value => if(value.sum == 5) Some(boardMatrix._2) else None}
        .flatten
    }.flatten


  def mark(extractedNumber: Int, boards: Boards): Boards = {
      Boards(boards.board.map{boardMatrix =>
        boardMatrix._1.map{line =>
          line.map{value =>
            if(value._1 == extractedNumber) value.copy(_2 = 1)
            else value
          }
        }
      }.zipWithIndex)
  }

  def getExtractionNumber(input: List[String]): List[Int]={
    input.splitAt(1)._1.map(_.split(",")).flatten.map{_.toInt}
  }

  def getBoards(input: List[String]): Boards = {

    val noSelection = Array.fill(input.length * 5)(0)
    val boards: Seq[Int] = input.splitAt(1)._2.filter(_.size>0).map(_.split(" +").toList.map(_.toIntOption).flatten).flatten

    Boards(boards
      .grouped(25)
      .map{ lines => lines.grouped(5)
        .map{
        value => value.zip(noSelection)
        }.toList
      }.toList.zipWithIndex)
  }
}

object Day4Main {

  def main(args: Array[String]): Unit = {
    val input = getInput("src/main/resources/Day4Input")
    println(solution(input))
  }

  def getInput(fileLocation:String): List[String] =
    Source.fromFile(fileLocation).getLines.toList
}
