import junit.framework.Assert.assertEquals
import org.junit.Test

class ArrayHopperUnitTest  {
  @Test
  def checkForMinimumHops(){
    val numbers = Array(5, 6, 0, 4, 2, 4, 1, 0, 0, 4)
    assertEquals("0,5,9,out", ArrayHopper.findMinimumHops(numbers))
  }

  @Test
  def checkForEmptyArray(){
    val numbers: Array[Int] = new Array[Int](0)
    assertEquals("failure\n", ArrayHopper.findMinimumHops(numbers))
  }

  @Test
  def checkForNullArray(){
    assertEquals("failure\n", ArrayHopper.findMinimumHops(null))
  }

  @Test
  def checkForNegativeNumbers(){
    val numbers = Array(3,3,2,2,-1,100,1)
    assertEquals("failure\n", ArrayHopper.findMinimumHops(numbers))
  }

  @Test
  def checkForUnreachableEndOfArray(){
    val numbers = Array(3,2,0,0,1)
    assertEquals("failure\n",ArrayHopper.findMinimumHops(numbers))
  }

  @Test
  def checkForAllNegativeArray(){
    val numbers = Array(-8,-4,-5,-9,-1)
    assertEquals("failure\n", ArrayHopper.findMinimumHops(numbers))
  }

  @Test
  def checkForBigNumbersInArray() {
    val numbers = Array(1000, 3, 5,8)
    assertEquals("0,3,out",ArrayHopper.findMinimumHops(numbers))
  }
}
