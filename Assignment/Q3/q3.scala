object NoDuplicatesQ3 {
  def main(args: Array[String]): Unit = {
    val list1 = List("a", "b", "c", "d", "c", "d", "d")
    val list2 = List("a", "b", "c")
    val list3 = List()

    println(noDuplicates(list1))
    println(noDuplicates(list2))
    println(noDuplicates(list3))
  }

  def noDuplicates(list: List[Any]): List[Any] = {
    var result: List[Any] = List()

    for (elem <- list) {
      if (!result.contains(elem)) {
        result = result :+ elem
      }
    }

    result
  }
}
