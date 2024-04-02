object ToZeroOneListQ5 {
  def main(args: Array[String]): Unit = {
    val inputList = List(1, 2, 3, 4, 5)
    val translist = toZeroOneList(inputList)
    println(translist)
  }

  def toZeroOneList(list: List[Int]): List[Int] = {
    list.map { num =>
      if (num % 2 == 0) 0 else 1
    }
  }
}
