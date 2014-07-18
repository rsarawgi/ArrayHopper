import junit.framework.Assert.assertTrue
import org.junit.Test

class FileReaderUnitTest {

  @Test
  def checkFileToArray {
    val actual = FileReader.getIntegerArrayFromFile("/Users/ruchitasarawgi/Desktop/practice/src/sampleFile.txt")
    val expected = Array(5, 6, 0, 4, 2, 4, 1, 0, 0, 4)
    assertTrue(expected.deep == actual.deep)
  }
}
