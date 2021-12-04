package CodeAdvent2021

import CodeAdvent2021.Day2.{Movement, finalPosition, finalPosition2, move, move2}
import org.scalatest.{FlatSpec, Matchers}

class Day2Test extends FlatSpec with Matchers{

  "move up" should "return increase the submarine depth" in {
    val input = Movement("up", 10)
    move(input) shouldBe (10,0) // obviously it shouldn't be positive. have to insert condition if I have time.
  }

  "move down" should "return increase submarine depth" in {
    val input = Movement("down", 10)
    move(input) shouldBe (-10,0)
  }

  "move forward" should "return move submarine forward" in {
    val input = Movement("forward", 2)
    move(input) shouldBe (0,2)
  }

  "input result" should "return expected result" in {
    val input = Array("forward 5", "down 5", "forward 8", "up 3", "down 8","forward 2")
    finalPosition(input) shouldBe (-10,15)
  }

  "parse" should "parse a well formatted string" in {
    val input = "test 1"
    Day2.parse(input) shouldBe Movement("test",1)
  }

  "move up 2" should "return increase the submarine depth" in {
    val input = Movement("up", 10)
    move2(input) shouldBe (0,0,-10,false) // obviously it shouldn't be positive. have to insert condition if I have time.
  }

  "move down 2" should "return increase submarine depth" in {
    val input = Movement("down", 10)
    move2(input) shouldBe (0,0,10,false)
  }

  "move forward 2" should "return move submarine forward" in {
    val input = Movement("forward", 2)
    move2(input) shouldBe (2,0,2,true)
  }

  "input result Aim" should "return expected result" in {
    val input = Array("forward 5", "down 5", "forward 8", "up 3", "down 8","forward 2")
    finalPosition2(input) shouldBe (15,60,10,false)
  }

}
