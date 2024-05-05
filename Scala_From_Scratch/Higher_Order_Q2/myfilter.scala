
// object myfilter {
//   def myfilter(a: Array[Int], fn: Int => Boolean): List[Int] = {
//     var b = List[Int]() // Initialize b outside the loop
//     for (i <- 0 until a.length) {
//       if (fn(a(i))) {
//         b = b ++ List(a(i)) // Append elements to b
//       }
//     }
//     return b // Return b from the function
//   }

//   def main(args: Array[String]): Unit = {
//     val result = myfilter(args.map(_.toInt), _ % 2 == 0)
//     result.foreach(println) // Process b outside the function
//   }
// }

object myfilter{
    def myfilter(a:Array[Int],fn : ((x:Int) => Boolean)) : Unit = {
        var b = List[Int]() //Dont forget to mention the datatype otherwise you will receive errors
        for(i<- 0 to a.length-1){
            if (fn(a(i))){
                b=b :+ a(i)
            }   
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        myfilter(args.map(_.toInt),(_%2==0))
    }
}