package CodeAdvent2021

import CodeAdvent2021.Day4.solution

import scala.annotation.tailrec
import scala.io.Source

object Day4 {

  case class Boards(board: List[(List[Seq[(Int, Int)]], Int)])

 def solution(input:List[String])={


   val boards = getBoards(input)
  val extractionNumbers: Seq[Int] = getExtractionNumber(input)


//   println(extractionNumbers(0))
//   println(mark(extractionNumbers(0),boards))
//   println(checkMark(mark(extractionNumbers(0),boards)))
   //step 1 unwrap input
   //step 2 mark
   //step 3 check marks
   // if row is marked then calculate not marked numbers of the board else go on

   //To do:
   //1. recursive function to loop through extracted number until one line is marked
   //2. get board numbers and some the not marked ones.


 }

  @tailrec
  def extractionWinner(extractionNumbers:List[Int], boards: Boards, winningBoard: Seq[Int] ): List[Seq[(Int, Int)]] ={
      winningBoard match {
        case Nil => {
                      val markedBoards: Boards = mark(extractionNumbers.head,boards)
                      extractionWinner(extractionNumbers.tail, markedBoards,getWinningBoard(markedBoards))
                    }
        case List(winner) => boards.board(winner)._1
      }
  }

  def getWinningBoard(boards: Boards): Seq[Int] ={
    boards.board.collect{
      boardMatrix => boardMatrix._1
        .map{ line => line.map(value => value._2)}
        .map{value => if(value.sum == 5) Some(boardMatrix._2) else None}
        .flatten
    }.flatten
  }

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
    solution(input)
  }

  def getInput(fileLocation:String): List[String] =
    Source.fromFile(fileLocation).getLines.toList
}
