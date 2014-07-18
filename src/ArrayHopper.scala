object ArrayHopper {

  def findMinimumHops(numbers: Array[Int]): String = {

    // return max value if the array is null or empty or has negative values
    if(numbers == null || numbers.isEmpty || !allElementsAreGreaterThanOrEqualToZero(numbers))
     "failure\n"

   else {
    val inputLength = numbers.length

    val jumps: Array[Int] = new Array[Int](inputLength)
    val hopsPath:Array[Int] = new Array[Int](inputLength)

    //min number of hops to reach last element from last element is zero
    jumps(inputLength - 1) = 0
    hopsPath(inputLength -1) = inputLength - 1


    for (i: Int <- inputLength - 2 to 0 by -1) {

      //if the number at the current position is zero, the last element cannot be reached from here
      if (numbers(i) == 0) {
        jumps(i) = Int.MaxValue
        hopsPath(i) = -1
      }
      //if the number at the current position is greater/equal to the difference between its position and total
      //array length then only 1 hop is required to reach the end of the array
      else if (numbers(i) >= inputLength - i - 1){
        jumps(i) = 1
        hopsPath(i) = inputLength - 1

      }
      else
        calculateHops(i, numbers, inputLength, jumps, hopsPath)
    }
    getHopsIndices(hopsPath)
   }
 }

  private def calculateHops(currentPosition: Int, numbers: Array[Int], length: Int, jumps: Array[Int], hopsPath: Array[Int]) =  {

    var min = Int.MaxValue

    //From the current position, move forward in the array till the pointer is not greater to the value in
    //the current position and find the min for each position from the jumps value
    for (j: Int <- currentPosition + 1  to length
         if j < length && j <= (numbers(currentPosition) + currentPosition)) {
        if (min > jumps(j)){
          min = jumps(j)
          hopsPath(currentPosition) = j
        }
      }

    //Taking the min value from all the traversed array positions and setting the current position value
    //to min+1
      if (min != Int.MaxValue) {
       jumps(currentPosition) = min + 1
      }
      else{
        jumps(currentPosition) = min
        hopsPath(currentPosition) = -1
      }
    }

  def allElementsAreGreaterThanOrEqualToZero(numbers: Array[Int]): Boolean = {
    var isNotLessThanZero = true
    for( i <- 0 to numbers.length-1) {
      if(numbers(i) < 0)
        isNotLessThanZero = false
    }
    isNotLessThanZero
  }
  
  def getHopsIndices(hopsPath: Array[Int]) : String = {
    if(hopsPath(0) == -1 )
      "failure\n"
    else{
    var i = 0
    var path = "0,"
    while (i < hopsPath.length - 1){
      path =  path + hopsPath(i) + ","
      i = hopsPath(i)
    }
      path + "out"
    }
  }

}

