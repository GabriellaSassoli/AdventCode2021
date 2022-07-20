package aperiodic

import aperiodic.ex6.isPalindrome
import org.scalatest.{FlatSpec, Matchers}

class Ex6Test extends FlatSpec with Matchers{

  "Is Palindrome" should "return true if a list is palindrome" in {
    val palindrome = List(1, 2, 3, 2, 1)
    val notPalindrome = List(3,4)
    isPalindrome(palindrome) shouldBe true
    isPalindrome(notPalindrome) shouldBe false

  }
}
