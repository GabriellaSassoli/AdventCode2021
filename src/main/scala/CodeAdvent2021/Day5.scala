package CodeAdvent2021



import scala.io.Source


object Day5 {

  val lineRegex = "(\\d+),(\\d+) -> (\\d+),(\\d+)".r

  case class Coordinates(x: Int, y: Int)
  type Grill = Array[Array[Int]]
  type VentilatorCoordinates = Seq[(Coordinates, Coordinates)]

  // Step 1: Read input using regex
  // Step 2: create Grill
  // Step 3: put input into (x,y, value) case class
  // Step 4: find max value of value field
  // Step 5: find how many time number is present.


  def main(args: Array[String]): Unit = {

    val input: Seq[String] = readInput("2021/Day5Input.txt")
    val coordinates: VentilatorCoordinates = grillCoordinates(input)
    val initialGrill = createGrill(coordinates)
    val coordinatesToConsider = coordinatesConsidered(coordinates)
    val grill = fillGrill(initialGrill,coordinatesToConsider)
    println(getOverlapsPoints(grill))

  }

  def readInput(filepath: String): Seq[String] =
    Source.fromResource(filepath).getLines.toList

  // manipulating input

  def parse(line: String): (Coordinates,Coordinates) =
    line match {
      case lineRegex(x1, y1, x2,y2) => (Coordinates(x1.toInt,y1.toInt), Coordinates(x2.toInt, y2.toInt))
    }

  def grillCoordinates(input:Seq[String]): VentilatorCoordinates = {
    input
      .map{ line => parse(line)}
  }

  def createGrill(coordinates: Seq[(Coordinates, Coordinates)]): Grill = {

    //could start empty
    val rows = coordinates.flatMap(coordinates => List(coordinates._1.x, coordinates._2.x)).max
    val cols = coordinates.flatMap(coordinates => List(coordinates._1.y, coordinates._2.y)).max

    Array.ofDim[Int](rows + 1, cols + 1)

  }

  def fillGrill(grill: Grill, fillingCoordinates: VentilatorCoordinates ): Grill ={
    //fillingCoordinates are already filtered coordinates
    fillingCoordinates.collect {
      case coordinates if coordinates._1.x == coordinates._2.x  && coordinates._2.y > coordinates._1.y =>
        (coordinates._1.y to coordinates._2.y)
          .foreach(cell => grill(coordinates._1.x)(cell) = add(grill,Coordinates(coordinates._1.x,cell)))
      case coordinates if coordinates._1.x == coordinates._2.x  && coordinates._1.y > coordinates._2.y =>
        (coordinates._2.y to coordinates._1.y)
          .foreach(cell => grill(coordinates._1.x)(cell) = add(grill,Coordinates(coordinates._1.x,cell)))
      case coordinates if coordinates._1.y == coordinates._2.y  && coordinates._2.x > coordinates._1.x =>
        (coordinates._1.x to coordinates._2.x)
          .foreach(cell => grill(cell)(coordinates._1.y) = add(grill,Coordinates(cell,coordinates._1.y)))
      case coordinates if coordinates._1.y == coordinates._2.y && coordinates._1.x > coordinates._2.x =>
        (coordinates._2.x to coordinates._1.x)
          .foreach(cell => grill(cell)(coordinates._1.y) = add(grill,Coordinates(cell,coordinates._1.y)))
    }
    grill.transpose
  }

  def coordinatesConsidered(grillCoordinates: VentilatorCoordinates ): VentilatorCoordinates ={
    grillCoordinates.filter{
      coordinate =>
        (coordinate._1.x == coordinate._2.x || coordinate._1.y == coordinate._2.y)
    }
  }

  def add(grill: Grill, coordinates: Coordinates): Int ={
    grill(coordinates.x)(coordinates.y) match {
      case 0 =>  1
      case value => value + 1
    }
  }

  def getOverlapsPoints(grill:Grill) ={
    grill.flatMap(value => value.filter(_ > 1)).length
  }
}
