package CodeAdvent2021

import CodeAdvent2021.Day7.getFuelPerPositionPart2
import org.scalatest.{FlatSpec, Matchers}

class Day7Test extends FlatSpec with Matchers{

  val testFilePath = "test-input-7"
  val input: Seq[Int] = Day6.readInput(testFilePath)

  behavior of "getFuelPerPosition"
  it should "return fuel need by all crab to get to position x weighting position" in {
    Day7.getFuelPerPosition(input, 1) shouldBe 41
    Day7.getFuelPerPosition(input, 2) shouldBe 37
    Day7.getFuelPerPosition(input, 3) shouldBe 39
    Day7.getFuelPerPosition(input, 5) shouldBe 45

  }

  behavior of "getFuelPerPosition2"
  it should "return fuel need by all crab to get to position x weighting position" in {
    Day7.getFuelPerPositionPart2(input, 5) shouldBe 168
    Day7.getFuelPerPositionPart2(input, 2) shouldBe 206
    (input.min to input.max).map{position=> getFuelPerPositionPart2(input,position)}.foreach(println)
    (input.min to input.max).map{position=> getFuelPerPositionPart2(input,position)}.min shouldBe 168 // didn't consider position in the middle of crabs where no crabs are present
  }

}
