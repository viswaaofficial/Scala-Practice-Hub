object practise{
    def main(args:Array[String]):Unit = {
        println("Hello")
    }
}

object mymap{
    def mymap(f:(Int=>Int),arr:Array[Int]):Unit={
        var b = List[Int]()
        for(i<-0 until arr.length){
            b = b :+ f(arr(i))
        }
        b.foreach(println)
    }   
    def main(args:Array[String])={
        var v = Array(1,3,45,6)
        mymap((_*3),v)
    }
}

object labques{
    def myques(lf:List[(Int=>Int)],x:Int):Unit={
        var b = List[Int]()
        for(i<- lf){
            b = b:+ i(x)
        }
        b.foreach(println)
    }
    def main(args:Array[String])={
        var f = List[Int=>Int]((_*3),(_+3),(_-1))
        myques(f,5)
    }
}

object labques2{
    def composition(f:List[(Int=>Int)],x:Int)={
        var b:Int = f(0)(x)
        for(i<-1 until f.length){
            b = (f(i))(b)
        }
        println(b)
    }
    def main(args:Array[String])={
        var func = List[(Int=>Int)]((_*3),(_+5),(_-1))
        composition(func,3)
    }
}

object labques3{
    def secondmax(a:Array[Int]):Int={
        var vals = a.min
        for(i<- a){
            if(i>vals && i<a.max){
                vals = i
            }
        }
        return vals
    }
    def secondmin(a:Array[Int]):Int={
        var vals = a.max
        for(i<- a){
            if(i<vals && i>a.min){
                vals = i
            }
        }
        return vals
    }

    def prodmax(a:Array[Int]):Unit={
        var min1 = a.min
        var min2 = secondmin(a)
        var max1 = a.max
        var max2 = secondmax(a)
        var val1 = min1*min2
        var val2 = max1*max2
        if(val1>=val2){
            println((min1,min2))
            print("Product is ")
            println(val1)
        } else if(val1<val2){
            println((max1,max2))
            print("Product is ")
            println(val2)
        }

    }

    def main(args:Array[String]):Unit={
        prodmax(Array(1,4,56,8,-50,-25))
    }
}

object odev{
    def odev(a:Array[Int],f:(Int=>Int),g:(Int=>Int)):Unit={
        var b = new Array[Int](a.length)
        for (i<- 0 until a.length){
            if(i%2==0){
                b(i) = f(a(i))
            } else{
                b(i) = g(a(i))
            }
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        var list=Array(1,2,3,4,5,6)
        odev(list,(_+1),(_+2))
    }
}

object myfilter{
    def myfilter(l:Array[Int],f:(Int=>Boolean)):Unit={
        var b = List[Int]()
        for(i<- l){
            if(f(i)){
                b = b :+ i
            }
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        var list = Array(1,2,3,4,5,6)
        myfilter(list,(_%2==0))
    }
}

object zipwith{
    def myzipwith(a:Array[Int],b:Array[Int],f:((Int,Int)=>Int))={
        var c = new Array[Int](a.length)
        for(i<-0 until a.length){
            c(i) = f(a(i),b(i))
        }
        c.foreach(println)
    }

    def main(args:Array[String])={
        var a = Array(1,2,3,4,5)
        var b = Array(1,2,3,4,5)
        myzipwith(a,b,(_+_))
    }
}