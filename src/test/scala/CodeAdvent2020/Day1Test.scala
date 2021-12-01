package CodeAdvent2020


import CodeAdvent2020.Day1.{Sum1, Sum3, extension1, extension2, product2, product3}
import org.scalatest.{FlatSpec, Matchers}

class Day1Test extends FlatSpec with Matchers {

  "sum1" should "return the 2 numbers that sum to 30" in {
    val input= Array("10","20","30","15","12","18")
    val sum1Result = Sum1(input, 30)
    sum1Result should contain(Some(10,20))
    sum1Result should contain(Some(12,18))
  }

  "sum3" should "return the 2 numbers that sum to 30" in {
    val input= Array("10","20","30","15","12","18")
    val sum3Result = Sum3(input, 30)
    sum3Result should contain(Some(10,20))
    sum3Result should contain(Some(12,18))
  }

  "extensions1" should "return the 3 numbers that sum to 30" in {
    val input = Array("10","20","30","15","12","18","8")
    val extensionResult = extension1(input,30)
    extensionResult should contain(Some(10,10,10))
    extensionResult should contain(Some(10,12,8))
  }

  "extensions2" should "return the 3 numbers that sum to 30" in {
    val input= Array("10","20","30","15","12","18","8")
    extension2(input, 30) should contain(Some((10,12,8)))
  }

  "product2" should "return the product between 2 numbers" in {
    val input= Array(Some(1,2), None, Some(2,3))
    product2(input) shouldBe Seq(2,6)
  }

  "product3" should "return the product between 3 numbers" in {
    val input= Array(Some(1,2,3), None, Some(2,3,4))
    product3(input) shouldBe Seq(6,24)
  }

}
