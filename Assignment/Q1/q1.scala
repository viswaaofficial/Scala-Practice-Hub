object RunningTotal {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4)
    val list2 = List(-5, 0, -22, 18, 55)

    println(runningTotal(list1))
    println(runningTotal(list2))
  }

  def runningTotal(numbers: List[Int]): List[Int] = {
    var total = 0
    numbers.map { num =>
      total += num
      total
    }
  }
}
