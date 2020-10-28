def fibonacci(num:Int):Float=
{
    var vector = new  Array[Float](num+1)
    if(num<2)
    {
        return num
    }
        else
    { 
        vector(0) = 0
        vector(1) = 1
        for (k<- Range(2,num+1)){
            vector(k)=vector(k-1)+vector(k-2)
        }
        return vector(num)
    }
    
}
//The result is
//scala> fibonacci(13)
//res5: Int = 233.0


