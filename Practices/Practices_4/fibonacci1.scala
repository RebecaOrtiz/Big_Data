//Algorithm 1 Descending recursive version 

//Creat a funticon 
def fibonacci(num:Int):Int=
{
//If the condition (if num is less than 2) is met the code will be executed
    if(num<2)
    {
//Returns the value of num     
        return num
    }
//If not 
        else
    {
//Returns 
        return (fibonacci(num-2)+fibonacci(num-1))
    }
    
}
//The result is
//scala> fibonacci(13)
//res1: Int = 233 
