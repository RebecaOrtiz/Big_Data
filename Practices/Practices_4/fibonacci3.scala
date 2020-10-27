//Algorithm 3 

//Create function
def fibonacci(num:Int):Int=
{
//Give value to variable   
    var x=0
    var y=1
    var z=0
//the instruction will continue executing until the condition is finish 
    for (k<- Range(0,num))
    {
        z = y+x
        x = y
        y = z
    }
//Return value of x    
    return x
}
//The result is
//scala> fibonacci(13)
//res3: Int = 233
