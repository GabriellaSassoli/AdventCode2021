package aperiodic

object ex6 {

  def main(args: Array[String]): Unit = {
    println(isPalindrome(List(1,2,3,2,1)))

  }

  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

  def isPalindromeLongWay[A](palindrome: List[A]): Boolean = {
    val palindromeLength = palindrome.size - 1

    val palindromeValues = for {
      i <- 0 to (palindromeLength / 2)
      if palindrome(i) == palindrome(palindromeLength - i)
    } yield i

    if (palindromeValues.length - 1 == (palindromeLength / 2)) true
    else false
  }

}
