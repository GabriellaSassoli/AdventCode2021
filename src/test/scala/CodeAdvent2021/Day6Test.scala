package CodeAdvent2021

import org.scalatest.{FlatSpec, Matchers}

class Day6Test extends FlatSpec with Matchers{

  val testFilePath = "test-input-6"
  val input: Seq[Int] = Day6.readInput(testFilePath)

  behavior of "readInput"
  it should "return the input in a list of Int" in {
    Day6.readInput(testFilePath) shouldBe Seq(3,4,3,1,2)
  }

  behavior of "lanternfishCycle"
  it should "return the fish after n days" in {
    val lanternFish = Seq(3,4,3,1,2)
    val newLanternfish = Day6.lanternfishCycle(lanternFish,0,18)
    newLanternfish.size shouldBe 26
    newLanternfish shouldBe Seq(6, 8, 1, 1, 3, 0, 2, 2, 4, 6, 8, 1, 1, 3, 4, 6, 6, 8, 6, 8, 1, 5, 7, 0, 0, 2)
  }
}
