//Algorithm 4

//Creat a funticon 
def fibonacci(num:Int):Int=
{
 //Give value to variable   
    var x=0
    var y=1
//the instruction will continue executing until the condition is finish 
    for (k<- Range(0,num))
    {
        y = y+x
        x = y-x
    }
//Return value of x   
    return x
}
//The result is
//scala> fibonacci(13)
//res4: Int = 233


