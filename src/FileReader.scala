import scala.io._

object FileReader {

  def getIntegerArrayFromFile(fileName: String) : Array[Int] = {
    Source.fromFile(fileName).getLines.map(str => str.toInt).toArray
    }
}
