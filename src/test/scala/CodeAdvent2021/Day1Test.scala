package CodeAdvent2021

import org.scalatest.{FlatSpec, Matchers}
import CodeAdvent2021.Day1
import CodeAdvent2021.Day1.numberOfIncreases


class Day1Test extends FlatSpec with Matchers{

  "numberOfIncreased" should "return numbers of times a value has been increased" in {
    val input= Array(10,20,30,15,12,18)
    numberOfIncreases(1, input) shouldBe 3
    numberOfIncreases(2, input) shouldBe 2
  }
}
