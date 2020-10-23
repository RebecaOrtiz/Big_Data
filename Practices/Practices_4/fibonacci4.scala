def fibonacci(num:Int):Int=
{
    var x=0
    var y=1
    for (k<- Range(0,num))
    {
        y = y+x
        x = y-x
    }
    return x
}
//The result is
//scala> fibonacci(13)
//res4: Int = 233


