object mymap{
    def mymap(a: Array[Int], fn: (x:Int) => Int) : Unit = {
        var b = new Array[Int](a.length)
        for (i<- 0 to a.length-1){
            b(i) = fn(a(i))
        }
        b.foreach(println)
    }
    def main(args:Array[String])={
        mymap(args.map(_.toInt),(_+3))
    }
}

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

object myzip{
    def myzip(a: List[Int],b:List[Int]):Unit={
        val lena=a.length
        val lenb=b.length
        var c = List[(Int,Int)]()
        if(lena<=lenb){
            for(i<- 0 to a.length-1){
                c= c ++ List((a(i),b(i)))
            }
        }
        else{
            for(i<- 0 to b.length-1){
                c= c ++ List((a(i),b(i)))
            }
        }
        c.foreach(println)
    }

    def main(args:Array[String])={
        var a=List(1,2,4)
        var b=List(1,23,5,6,5,7,8)
        myzip(a,b)
    }
}

object myzipwith {
    def myzipwith(a: List[Int],b: List[Int],fn:((x:Int,y:Int) => Int)):Unit ={
        val lena = a.length
        val lenb = b.length
        var c = List[Int]()
        if (lena<=lenb){
            for(i<- 0 to a.length-1){
                c = c ++ List(fn(a(i),b(i))) 
            }
        }
        else{
            for(i<- 0 to b.length-1){
                c = c ++ List(fn(a(i),b(i))) 
            }
        }
        c.foreach(println)
    }

    def main(args:Array[String]) = {
        var l1 = List(1,2,4,5)
        var l2 = List(1,3,4,5)
        myzipwith(l1,l2,(_+_))
    }
}

object filtercase {
  def filtercase(a: List[Int], fn: Int => Boolean): List[Int] = {
    a match {
      case Nil => Nil
      case x :: xs => if (fn(x)) x :: filtercase(xs, fn) else filtercase(xs, fn)
    }
  }

  def main(args: Array[String]): Unit = {
    val results = filtercase(args.map(_.toInt).toList, _ % 2 == 0)
    results.foreach(println)
  }
}


object myreduceleft {
  def myreduceleft(a: List[Int], fn: (Int, Int) => Int): Int = {
    a match {
      case Nil => 0
      case x :: Nil => x
      case x :: xs => fn(x, myreduceleft(xs, fn))
    }
  }

  def main(args: Array[String]): Unit = {
    val d = myreduceleft(args.map(_.toInt).toList, _ + _)
    println(d)
  }
}

object myreduceright {
  def myreduceright(a: List[Int], fn: (Int, Int) => Int): Int = {
    a match {
      case Nil => 0
      case x :: Nil => x
      case x :: xs => fn(myreduceright(xs, fn), x)
    }
  }

  def main(args: Array[String]): Unit = {
    val d = myreduceright(args.map(_.toInt).toList, _ + _)
    println(d)
  }
}

object myscanleft {
  def myscanleft(a: List[Int], fn: (Int, Int) => Int): List[Int] = {
    a.foldLeft(List.empty[Int]) { (acc, x) =>
      acc match {
        case Nil => List(x)
        case head :: _ =>
          val next = fn(head, x)
          next :: acc
      }
    }.reverse // Reverse the result to get the correct order
  }

  def main(args: Array[String]): Unit = {
    val result = myscanleft(args.map(_.toInt).toList, _ + _)
    result.foreach(println)
  }
}



object myscanright {
  def myscanright(a: List[Int], fn: (Int, Int) => Int): List[Int] = {
    a match {
      case Nil => List(0)
      case x :: xs =>
        val acc = myscanright(xs, fn)
        val head = acc.lastOption.getOrElse(0) // Get the last element of the accumulated list
        val next = fn(x, head)
        acc :+ next // Append next to the end of the accumulated list
    }
  }

  def main(args: Array[String]): Unit = {
    val result = myscanright(args.map(_.toInt).toList, _ + _)
    result.foreach(println)
  }
}



