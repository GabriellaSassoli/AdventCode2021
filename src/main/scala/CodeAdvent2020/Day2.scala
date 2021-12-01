package CodeAdvent2020

import scala.collection.immutable.BitSet.empty.size
import scala.io.Source


object Day2 {

  def main(args: Array[String]): Unit = {

    val input = Source.fromFile("/Users/sassolig/StudingProjects/CodeAdvent2021/src/main/scala/CodeAdvent2020/Day2Input").getLines.toArray

    case class Policy(low: Int, high: Int, char: Char)

    val lineRegex = "(\\d+)-(\\d+) (\\w): (\\w+)".r

    def parse(line: String): (Policy, String) =
      line match {
        case lineRegex(low, high, ch, pwd) => Policy(low.toInt, high.toInt, ch.head) -> pwd
      }

    val parsedInput: Array[(Policy, String)] = input.map{ x =>
      parse(x)
      }

    val validPasswords = for {
      lines <- parsedInput
      count = lines._2.toSeq.count(_ == lines._1.char)
      if (lines._1.low <= count && count <= lines._1.high)
    } yield lines._2

    println(validPasswords.size)
  }



}
