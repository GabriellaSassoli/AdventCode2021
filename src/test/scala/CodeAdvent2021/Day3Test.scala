package CodeAdvent2021


import CodeAdvent2021.Day3.{findEpsilonRate, findGammaRate}
import org.scalatest.{FlatSpec, Matchers}

class Day3Test extends FlatSpec with Matchers {

    val testFilePath = "src/test/resources/test-input-3"
    val testInput: List[String] = Day3.readInput(testFilePath)

    behavior of "binary number converter"
    it should "convert binary to decimal - 1" in {
      Day3.convertBinaryToDecimal("10110") should equal(22)
    }
    it should "convert binary to decimal - 2" in {
      Day3.convertBinaryToDecimal("01001") should equal(9)
    }


    behavior of "collection helpers"
    it should "find most common element in a collection" in {
      val coll = List(1, 2, 2, 3, 3, 3, 1, 1, 1, 1, 1)
      Day3.findMostCommonElementInCollection(coll) should equal(1)
    }

    it should "find least common element in a collection" in {
      val coll = List(1, 2, 2, 3, 3, 3, 1, 1, 1, 1, 1)
      Day3.findLeastCommonElementInCollection(coll) should equal(2)
    }


    behavior of "rate finders"
    it should "find gamma rate" in {
      Day3.findGammaRate(testInput) shouldBe List('1', '0', '1', '1', '0')
    }

    it should "find epsilon rate" in {
      Day3.findEpsilonRate(testInput) shouldBe List('0', '1', '0', '0', '1')
    }

    behavior of "solution finder"
    it should "test solution" in {
      val input = Day3.readInput(testFilePath)
      Day3.solution(input) should equal(198)
    }

   behavior of "solution2"
   it should "return the product of oxygen and CO2" in {
    val input = Day3.readInput(testFilePath)
    Day3.solutionPart2(input) should equal(198)
   }

  behavior of "getRating"
  it should "get Oxygen rating when findGamma funcion passed" in {
    val input = Day3.readInput(testFilePath)
    Day3.getRating(mostCommonNumber = findGammaRate,input = input) shouldBe "10111"
  }

  it should "get CO2ScrubberRating rating when findGammaEpsilonRate passed" in {
    val input = Day3.readInput(testFilePath)
    Day3.getRating(mostCommonNumber = findEpsilonRate,input = input) shouldBe "01010"
  }



}
