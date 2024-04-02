object ReplaceThirdQ2 {
  def main(args: Array[String]): Unit = {
    val strings = List(("apple", "banana", "cherry"), ("orange", "grape", "kiwi"))
    val doubles = List(10.5, 20.7)

    val replaced = replaceThird(strings, doubles)

    println(replaced)
  }

  def replaceThird(strings: List[(String, String, String)], doubles: List[Double]): List[(String, String, Double)] = {
    var result: List[(String, String, Double)] = List()

    // Ensure both lists have the same size
    if (strings.length == doubles.length) {
      // Iterate over the indices of the lists
      for (i <- strings.indices) {
        // Destructure the tuple into its components
        val (str1, str2, _) = strings(i)
        val double = doubles(i)

        // Append the modified tuple to the result list
        result = result :+ (str1, str2, double)
      }
    } else {
      println("Error: Lists have different sizes.")
    }

    result
  }
}

// Certainly! Let's break down the line `val (str1, str2, _) = strings(i)`:

// 1. **Pattern Matching**: This line utilizes pattern matching in Scala.

// 2. **Tuple Destructuring**: The left-hand side of the assignment (`val (str1, str2, _)`) is a pattern that matches the structure of a tuple `(String, String, String)`.

// 3. **Assignment from Tuple**: The right-hand side (`strings(i)`) is an access to the `i`-th element of the `strings` list. This element is expected to be a tuple of three strings.

// 4. **Destructuring Assignment**: The pattern `(str1, str2, _)` destructures the tuple returned by `strings(i)` into three variables `str1`, `str2`, and `_`. Here, `_` is a wildcard that means "ignore this value". Since we're only interested in the first two strings of the tuple and want to ignore the third one, we use `_` to match and discard it.

// 5. **Variable Assignment**: After pattern matching, the variables `str1` and `str2` hold the first and second strings of the tuple respectively. The third string is ignored due to the `_` wildcard.

// In summary, `val (str1, str2, _) = strings(i)` allows us to destructure a tuple stored in the `i`-th position of the `strings` list into individual variables `str1` and `str2`, discarding the third string of the tuple.