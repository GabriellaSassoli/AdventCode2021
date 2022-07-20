//package aperiodic
//
//object QuantexaExercise extends App{
//
//  val stockPricesYesterday: List[Int] = List(10, 7, 5, 8, 11, 9, 3, 4)
//
//  def get_max_profit(stockPricesYesterday: List[Int], result: Int ) : Int = {
//
//    stockPricesYesterday match {
//      case stock1 :: tail if ((tail.max - stock1) > result) => {get_max_profit(tail, tail.max - stock1 :: result)
//        case
//    }
//
//
//    result.toList.max
//  }
//
//  println(get_max_profit(stockPricesYesterday))
//
//}


//val result: IndexedSeq[Int] = for{
//  i <- 0 until stockPricesYesterday.length - 1
//  j <- i until stockPricesYesterday.length
//  }yield {
//  stockPricesYesterday(j) - stockPricesYesterday(i)
//  }