import java.io.FileNotFoundException

object ArrayHopperMain {

  def main(args: Array[String]) {
    if(args == null || args.length == 0){
      System.out.println("Please specify the input file")
      System.exit(0)
    }

    var numbers = new Array[Int](0)
    try{
      numbers = FileReader.getIntegerArrayFromFile(args(0))
    }
    catch {
      case a: FileNotFoundException =>
        System.out.println("File not found")
        System.exit(0)
      case b: NumberFormatException =>
        System.out.println("Error parsing the file")
        System.exit(0)
      case _: Throwable =>
        System.out.println("An error occurred while trying to read values from the file")
        System.exit(0)

    }
    val numOfHops = ArrayHopper.findMinimumHops(numbers)
    println (numOfHops)
  }
}
