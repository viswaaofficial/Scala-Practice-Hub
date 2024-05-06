//Assignment Questions

// 1.	Write a procedure named running-total that takes a non-empty list of numbers as an argument and returns another list that contains the running total which is computed as follows: 
// The first number in the resulting list should be the first number of the argument list, the second number in the resulting list should be the sum of the first and second numbers of the original list and the third number in the resulting list should be the sum of the first, second, and third numbers of the original list, and so on.                                                                          
// For example: 
// > (running-total ‘(1 2 3 4)) returns ‘(1 3 6 10) 
// > (running-total ‘(-5 0 –22 18 55)) returns ‘(-5 –5 –27 –9 46)

object runningtotal{
    def runningtotal(a:List[Int]):Unit = {
        var b = List[Int]()
        var value = 0
        for(i<- 0 until a.length){
            b=b :+ (a(i)+value)
            value = a(i) + value
        }
        b.foreach(println)
    }

    def main(args:Array[String]) = {
        var a = List(1,2,4,5,6,7)
        runningtotal(a)
    }
}

// 2.	Suppose you have two lists, one of (String, String, String) and one of Double. They are of equal size. 
// You want to replace the third string in each tuple with its corresponding Double. 
// Write a function replaceThird that accomplishes this task.

object replacethird {
    def replacethird(a: List[(String,String,String)],b: List[Double]):Unit = {
        var f = List[(String,String,Double)]()
        for(i<- 0 until a.length){
            f = f:+ (a(i)(0),a(i)(1),b(i))
        }
        f.foreach(println)
    }

    def main(args:Array[String])={
        var a = List(("a","b","c"),("d","e","f"),("g","h","i"))
        var b = List(1.1,2.2,3.3)
        replacethird(a,b)
    }
}

// 3.	Write a Scala function noduplicates that takes a list and returns a new list that drops any duplicate elements. 
// The new list can be in any order. You can use the built-in Scheme function member if you would like. 
// Here are some examples. (The value returned by your function should contain the same elements but can be in a different order.)
//  (noduplicates '(a b c d c d d)) => (a b c d)
//  (noduplicates '(a b c )) => (a b c) 
// (noduplicates '()) => ()

object nodupe{
    def nodupe(a: List[Int]):Unit ={
        var b =List[Int]()
        for(i<- 0 until a.length){
            if(b.contains(a(i))){

            }
            else{
                b = b:+ a(i)
            }
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        var a = List(1,2,4,5,6,2,4,5,32)
        nodupe(a)
    }    
}

// 4. Define the function toZeroOneList which takes a list of type (List Int) then turns every even integer to 0 and every odd integer to 1.

object toZeroOneList{
    def toZeroOneList(a : List[Int]):Unit = {
        var b = List[Int]()
        for (i<- 0 until a.length){
            if(a(i)%2==0){
                b=b :+ 0
            }
            else{
                b=b :+ 1
            }
        }
        b.foreach(print)
    }

    def main(args:Array[String])={
        var li = List(1,2,4,5,6,7)
        toZeroOneList(li)
    }
}

object twoho{
    def twoho(a : List[Int],fn: ((x:Int)=>Int),gn: ((x:Int)=>Int)):Unit = {
        var f = List[Int]()
        for(i<- 0 until a.length){
            if(a(i)%2==0){
                f = f:+ (fn(a(i)))
            }
            else{
                f = f:+ (gn(a(i)))
            }
        }
        f.foreach(println)
    }

    def main(args:Array[String])={
        var a = List(1,2,3,4,5,6,7)
        twoho(a,(_*1),(_*2))
    }
}

// a.dropRight(2)
// a.drop(2)

object mymap{
    def mymap(a: List[Int],fn: ((x:Int) => Int)):Unit ={
        var b = List[Int]()
        for(i<- 0 until a.length){
            b = b :+ fn(a(i))
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        var x = List(1,2,4,5,6)
        mymap(x,(_+3))
    }
}

object myfilter{
    def myfilter(a: List[Int],fn: ((x:Int) => Boolean)):Unit ={
        var b = List[Int]()
        for(i<- 0 until a.length){
            if(fn(a(i))){
                b = b:+ a(i)
            }
        }
        b.foreach(println)
    }

    def main(args:Array[String])={
        var x = List(1,2,4,5,6)
        myfilter(x,(_%2==0))

    }
}

object myreduceleft{
    def myreduceleft(x:List[Int],fn: ((x:Int,y:Int)=>Int)):Int = {
        x match{
            case Nil => 0
            case x::Nil => x
            case x::xs => fn(x,myreduceleft(xs,fn))
        }
    }

    def main(args:Array[String])={
        var a = List(1,2,3,4)
        print(myreduceleft(a,(_+_)))
    }
}

object eval1{
    def eval1(a:Array[Int]):Unit={
        for(i<- 1 until a.length by 2){
            if(i!=a.length-1){
                if(a(i-1)>a(i)){
                    var temp=a(i-1)
                    a(i-1)=a(i)
                    a(i)=temp
                }
                if(a(i+1)>a(i)){
                    var temp=a(i+1)
                    a(i+1)=a(i)
                    a(i)=temp
                }                
            }
            else{
                if(a(i-1)>a(i)){
                    var temp=a(i-1)
                    a(i-1)=a(i)
                    a(i)=temp
                }
            }
        }
        a.foreach(println)
    }

    def main(args:Array[String])={
        var a=Array(1,2,3,4,5,6,7,8)
        eval1(a)
    }
}