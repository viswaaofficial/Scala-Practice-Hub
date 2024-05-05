// object ho {
//   def mymap(a: Array[Int], fn: ((x:Int) => Int)): Unit = {
//     var b = new Array[Int](a.length)
//     for (i <- 0 to a.length-1){
//         b(i)=fn(a(i))
//     }
//     b.foreach(println)
//   }
  
//   def main(args: Array[String]): Unit = {
//     mymap(args.map(_.toInt),(_+3)) // Convert args from String to Int
//   }
// }






