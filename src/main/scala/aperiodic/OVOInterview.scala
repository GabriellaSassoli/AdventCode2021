package aperiodic

//object OVOInterview extends App {
//
//  def getUpToNthElements(inputList: List[String], nOfElementsToTake: Int, outputList: List[String], nOfElementsToTake: Int): List[String] =
//  {
//    val nOfLoops: Int = inputList.size % nOfElementsToTake
//    val remaininValues = (nOfLoops * inputList.size - nOfElementsToTake)
//    val result = for{
//      i <- 0 until nOfLoops
//    }yield inputList
//
//    result ++ inputList.take(remaininValues)
//
//    if(inputList.size < nOfElementsToTake) {
//      val difference: Int = nOfElementsToTake - inputList.size
//      getUpToNthElements()}
//    else inputList.take(nOfElementsToTake)
//  }
//
//
//
//  val inputList: List[String] = List("apple", "pear", "lemon", "orange")
//  val nOfElementsToTake: Int = 15
//  println(getUpToNthElements(inputList, nOfElementsToTake))
//}
