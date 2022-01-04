package CodeAdvent2020

import scala.{+:, ::}
import scala.io.Source

object Day1 {

  def main(args: Array[String]): Unit = {

    val input = Source.fromResource("2020/Day1Input.txt").getLines.toArray
    val sum = 2020

    println("------Sum1-------")
    val sum1Response = Sum1(input,sum)
    product2(sum1Response)


    println("-------Sum3-------")
    val sum3Response = Sum3(input,sum)
    product2(sum3Response)

    //work to make it testable
    println("------extension1 -----")
    extension1(input,sum)

    println("------extension2 -----")
    val extension2Response: Seq[Option[(Int, Int,Int)]] = extension2(input,sum)
    product3(extension2Response)

  }

  def product2(sum1Response: Seq[Option[(Int, Int)]]): Seq[Int] = {
    sum1Response.map(product => product match {
      case Some((value1, value2)) => {
        val product = value1 * value2
        println(s"Sum of ${value1} and ${value2} is 2020, \n Product is ${product}")
        Seq(product)
      }
      case None => Seq.empty
    }).flatMap(x => x)
  }

  def product3(sumResponse: Seq[Option[(Int, Int,Int)]]): Seq[Int] = {
    sumResponse.map(product => product match {
      case Some((value1, value2,value3)) =>{
        val product = value1 * value2 * value3
        println(s"Sum of ${value1} and ${value2} and $value3 is 2020, \n Product is ${product}")
        Seq(product)
      }
      case None => Seq.empty
    }).flatMap(x=> x)
  }

  def Sum1(input: Array[String], sum:Int): Seq[Option[(Int, Int)]] = {
    for {
      i <- 0 until (input.length -1)
      j <- i + 1 until input.length
      if (input(i).toInt + input(j).toInt == sum)
    } yield
        Some(input(i).toInt,input(j).toInt)
  }

  def Sum3(input: Array[String],sum:Int): Seq[Option[(Int, Int)]] = {

    (0 until (input.length-1)).map{i =>
      (i + 1 until input.length).map {
        j =>
          if (input(i).toInt + input(j).toInt == sum) {
            Some(input(i).toInt,input(j).toInt)
          }
          else{
            None
          }
      }
    }.flatMap(x => x)

  }

  def extension1(input:Array[String],sum:Int): Seq[Option[(Int, Int, Int)]] = {
    (0 until (input.length-2)).map{i =>
      (i until input.length-1).map{
        j =>
          (j until input.length).map{ k=>
            if (input(i).toInt + input(j).toInt + input(k).toInt == sum) {
              Some(input(i).toInt,input(j).toInt,input(k).toInt)
            }
            else None
          }
      }
    }.flatMap(x => x).flatMap(x=> x)

  }

  def extension2(input:Array[String],sum:Int): Seq[Option[(Int, Int,Int)]] ={
    for {
      i <- 0 until (input.length -2)
      j <- i + 1 until (input.length -1)
      k <- j + 1 until input.length
      if (input(i).toInt + input(j).toInt + input(k).toInt == sum)
    } yield {
        Some(input(i).toInt,input(j).toInt, input(k).toInt)
    }
  }

}




