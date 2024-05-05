object CollectionFunctions {

  def map[A, B](list: List[A], f: A => B): List[B] = list match {
    case Nil => Nil
    case head :: tail => f(head) :: map(tail, f)
  }

  def filter[A](list: List[A], predicate: A => Boolean): List[A] = list match {
    case Nil => Nil
    case head :: tail if predicate(head) => head :: filter(tail, predicate)
    case _ :: tail => filter(tail, predicate)
  }

  def reduceLeft[A](list: List[A], f: (A, A) => A): A = list match {
    case Nil => throw new UnsupportedOperationException("empty.reduceLeft")
    case head :: Nil => head
    case head :: tail => f(head, reduceLeft(tail, f))
  }

  def reduceRight[A](list: List[A], f: (A, A) => A): A = list match {
    case Nil => throw new UnsupportedOperationException("empty.reduceRight")
    case head :: Nil => head
    case head :: tail => f(reduceRight(tail, f), head)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5)

    val squaredNumbers = map(numbers, (x: Int) => x * x)
    println(s"Squared numbers: $squaredNumbers")

    val evenNumbers = filter(numbers, (x: Int) => x % 2 == 0)
    println(s"Even numbers: $evenNumbers")

    val sum = reduceLeft(numbers, (x: Int, y: Int) => x + y)
    println(s"Sum of numbers (reduceLeft): $sum")

    val product = reduceRight(numbers, (x: Int, y: Int) => x * y)
    println(s"Product of numbers (reduceRight): $product")
  }
}