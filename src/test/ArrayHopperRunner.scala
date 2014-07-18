object ArrayHopperRunner {

  def main(args: Array[String]) = {
    val arrayHopperTests = new ArrayHopperUnitTest
    arrayHopperTests.checkForAllNegativeArray()
    arrayHopperTests.checkForBigNumbersInArray()
    arrayHopperTests.checkForEmptyArray()
    arrayHopperTests.checkForMinimumHops()
    arrayHopperTests.checkForNegativeNumbers()
    arrayHopperTests.checkForUnreachableEndOfArray()
    arrayHopperTests.checkForNullArray()

    val fileReaderTests = new FileReaderUnitTest
    fileReaderTests.checkFileToArray
  }
}
