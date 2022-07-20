//package Exercise
//
//import Exercise.ArrayProduct.product
//import org.scalatest.{FlatSpec, Matchers}
//
//class ArrayProductTest extends FlatSpec with Matchers {
//
//
//
//
//  "product" should "return the list of products with j != i where j is products index and i is the starting list aa" in {
//
//    val numb1: List[BigInt] = List(1,2,3,4,5)
//    println(s"Starting number $numb1")
//    val response = product(numb1)
//
//    response shouldBe List( 120, 60,40, 30, 24)
//    response.length shouldBe numb1.length
//
//  }
//
//  it should "do the same" in {
//
//    val numb2: List[BigInt] = List(4,9,10)
//    val response2 = product(numb2)
//
//    response2 shouldBe List(90,40,36)
//    response2.length shouldBe numb2.length
//
//  }
//
//
//
//  "sum up to x" should "check if any 3 integer in input sum up to x" in{
//    val input = List(1,2,3,4,5)
//
//    sumsX(input,10) shouldBe true
//    sumsX(input,2) shouldBe false
//  }
//
//}
