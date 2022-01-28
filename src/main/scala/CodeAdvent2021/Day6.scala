package CodeAdvent2021

import scala.io.Source

object Day6 {

  type Lanternfishes = Seq[Int]
  type LanternfishNumber = BigInt
  type RemainingDays = Int

  def main(args: Array[String]): Unit = {
    val input: Lanternfishes = readInput("2021/Day6Input.txt")
    println(s"Lantern fish after 80 days: Method1 ${lanternfishCycle(input,0,80).size}, Method2 ${sumMapValues(lanternfisheGrowpart2(createLanternfishMap(input),0,80))}")
    println(s"lanternfish after 256 days ${sumMapValues(lanternfisheGrowpart2(createLanternfishMap(input),0,256))}")
  }

  def readInput(filepath: String): Lanternfishes =
    Source.fromResource(filepath).getLines.toList.flatMap(lanternfish=> lanternfish.split(",")).map(_.toInt)

  //returns the new fishes
  def lanternfishCycle(lanternfishes: Lanternfishes, day: Int, nDaysTotal: Int): Seq[Int] = {
    if (day < nDaysTotal){
      val newLanternfishes: Seq[Int] = (0 to (lanternfishes.length - 1)).flatMap{
         lanternfishIndex =>
           if (lanternfishes(lanternfishIndex) == 0){
            Seq(6,8)
           } else {
            Seq(lanternfishes(lanternfishIndex) - 1)
           }
      }
      lanternfishCycle(newLanternfishes,day + 1, nDaysTotal)
    }
    else{
      lanternfishes
    }

  }

  //part 2

  def createLanternfishMap(lanternfishes: Lanternfishes): Map[RemainingDays, LanternfishNumber] =
    lanternfishes.groupBy(identity).mapValues(value => BigInt(value.size)).toMap
  def sumMapValues(lanternfishMap: Map[RemainingDays, LanternfishNumber]): BigInt = {
    lanternfishMap.collect{
      case (_,value) => value
    }.sum
  }

  def lanternfisheGrowpart2(lanternfishes: Map[RemainingDays,LanternfishNumber], day: Int, nDaysTotal: Int): Map[RemainingDays, LanternfishNumber] = {
    if (day < nDaysTotal){
      lanternfisheGrowpart2(newLanternFishMap(lanternfishes),day + 1, nDaysTotal)
    }
    else{
      lanternfishes
    }
  }

  def newLanternFishMap(lanternfishes: Map[RemainingDays, LanternfishNumber]): Map[RemainingDays, LanternfishNumber] = {
    lanternfishes.flatMap{
      case (dayLeft0, nFish) if dayLeft0 == 0 => Map((6,nFish),(8,nFish))
      case (dayLeft7, nFish7) if dayLeft7 == 7 => Map((6,nFish7 + lanternfishes.get(0).getOrElse(0)))
      case (dayLeft, nFish) => Map((dayLeft - 1,nFish))
    }
  }
}
