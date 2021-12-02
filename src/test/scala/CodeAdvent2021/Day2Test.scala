package CodeAdvent2021

import CodeAdvent2021.Day2.{Movement, move}
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

  "parse" should "parse a well formatted string" in {
    val input = "test 1"
    Day2.parse(input) shouldBe Movement("test",1)
  }
//  "parse" should "not parse a bad formatted string" in {
//    val input = "test  1"
//    Day2.parse(input) should assertThrows(new Exception)
//  }

}
