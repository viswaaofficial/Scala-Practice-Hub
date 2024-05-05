object factorial
{
    def main(args:Array[String])=
    {
        println("Factorial of 5 is "+fact(5))
    }

    def fact(x:BigInt):BigInt=
    {
        if(x==0)
        {
            1
        }
        else
        {
            x*fact(x-1)
        }
    }
}