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

  behavior of "createLanternfishMap"
  it should "return a map of lanternfishes" in {
    val lanternFish = Seq(3,4,3,1,2)
    Day6.createLanternfishMap(lanternFish) shouldBe Map((1,1), (2,1), (3,2), (4,1))
  }

  behavior of "newLanternFishMap"
  it should "return a map of lanternfishes" in {
    Day6.newLanternFishMap(Map((1,1), (2,1), (3,2), (4,1))) shouldBe Map((0,1), (1,1), (2,2), (3,1))
    Day6.newLanternFishMap(Map((0,1), (1,1), (2,2), (3,1))) shouldBe Map((6,1), (0,1), (1,2), (2,1),(8,1))
    Day6.newLanternFishMap(Map((0,1), (7,1), (2,2), (3,1))) shouldBe Map((6,2),(8,1),(1,2), (1,2), (2,1))
  }

  behavior of "lanternfisheGrowpart2"
  it should "return the fish after n days" in {
    Day6.lanternfisheGrowpart2(Map((1,1), (2,1), (3,2), (4,1)),0,18) shouldBe Map(0 -> 3, 5 -> 1, 1 -> 5, 6 -> 5, 2 -> 3, 7 -> 1, 3 -> 2, 8 -> 4, 4 -> 2)

  }

  behavior of "sumMapValues"
  it should "return the sum of the map values" in {
    Day6.sumMapValues(Map((1,1), (2,1), (3,2), (4,1))) shouldBe 5
  }
}
