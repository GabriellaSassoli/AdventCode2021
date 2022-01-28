package CodeAdvent2021


object Day7 {

  def main(args: Array[String]): Unit = {
    val input: Seq[Int] = Day6.readInput("2021/Day7Input.txt")
    println(s"part 1 result ${(input.min to input.max).map{position => getFuelPerPosition(input,position)}.min}")
    println(s"part 2 result: ${(input.min to input.max).map{position=> getFuelPerPositionPart2(input,position)}.min}")
  }

  def getFuelPerPosition(crabPositions: Seq[Int],position: Int): BigInt={
    crabPositions.map{
      positionCrab2 =>
        math.abs(position - positionCrab2)
    }.sum
  }

  def getFuelPerPositionPart2(crabPositions: Seq[Int],position: Int): BigInt ={
    crabPositions.map{
      positionCrab2 => {
        val distance = math.abs(position - positionCrab2)
        val weightedDistance = (0 to distance).sum
        weightedDistance
      }
    }.sum
  }

}
