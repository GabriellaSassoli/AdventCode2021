package aperiodic

import scala.collection.mutable.HashMap

object Anagram extends App{

//  def getAnagams(input: List[List[Char]], output: List[List[String]] = List.empty): List[List[String]] = {
//    input match {
//      case word :: tail => {
//        val requiredLength = word.length
//        val tempOutput: List[String] = tail.takeWhile{ nextWord =>
//          nextWord.length == requiredLength && word.map{letter => nextWord.contains(letter)}.forall(_ == true)
//        }.map{word => word.mkString}
//
//        getAnagams(tail.filter(word => output.contains(word)), output ++ List(tempOutput))
//      }
//
//      case word :: Nil => {
//        println("What is going on ")
//        List(List(word.mkString)) ++ output}
//      case Nil => {
//        println(s"In Here $input")
//        List(List(""))
//      }
//    }
//  }

  def groupAnagrams(input: List[String]): List[List[String]] = {
    var anagramsMap: HashMap[String, List[String]] = HashMap.empty
    input.foreach{
      word =>
        val sortedWord = word.sorted
        anagramsMap.get(sortedWord) match{
          case Some(words) =>{println(s"IN here $sortedWord")
            anagramsMap += (sortedWord -> (word :: words))}
          case None => {
            println(s"Or in here up to you: $sortedWord")
            anagramsMap += (sortedWord -> List(word)) }
        }
    }
    anagramsMap.values.toList
  }

  val input = List("tea", "eat", "tan", "ate", "nat", "bat")
  println(groupAnagrams(input))

}
