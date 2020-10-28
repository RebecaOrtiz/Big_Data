// Practice 3, analyse the following code with your own words
 
 
//The function is defined with the name "listEvens", 
//a cycle is used in which it is defined whether the number 
//is even or odd, ending with the impression of "Done"
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
 
//Lists 1 and list 2 are defined with their respective values 
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
 
//The function is executed using each of the lists
listEvens(l)
listEvens(l2)
 
//3 7 afortunado
 
//The function "Lucky" is defined, 
//the variable res with value is declared to zero, 
//if the number entered is equal to 7 adds that value plus 14, 
//if it is not added to the variable res, res plus the number entered, 
//ends up returning the variable res
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}
 
//The variable "af" is declared and the function is printed using it
val af= List(1,7,7)
println(afortunado(af))

//
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0
 
    segunda = list.sum
 
    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)
 
        if(primera == segunda){
            return true
        }
    }
    return false 
}
 
//
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)
 
balance(bl)
balance(bl2)
balance(bl3)
 
//
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}
 
//
val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"
 
println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
 
