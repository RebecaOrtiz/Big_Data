//Develop a scala algorithm that shows Number is prime or not prime

//We creat a function call '"primo"
def Primo(i :Int) : Boolean = {
     if (i <= 1)
       false
     else if (i == 2)
       true
     else
      !(2 to (i-1)).exists(x => i % x == 0)
   }
//we initiate primo whit the number 4 
Primo(4)

//The result is 
//scala> primo(4)
//res42: Boolean = false