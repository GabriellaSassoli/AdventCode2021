package CodeAdvent2021


import org.scalatest.{FlatSpec, Matchers}

class Day3Test extends FlatSpec with Matchers {

    val testFilePath = "test-input-3"
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
      Day3.findGammaRate(testInput) should equal("10110")
    }

    it should "find epsilon rate" in {
      Day3.findEpsilonRate(testInput) should equal("01001")
    }

    behavior of "solution finder"
    it should "test solution" in {
      val input = Day3.readInput(testFilePath)
      Day3.solution(input) should equal(198)
    }

}
