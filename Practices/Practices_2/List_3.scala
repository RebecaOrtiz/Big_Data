//Bring the elements from "lista" "Verde", "Amarillo", "Azul"

//Create List
val lista = List("rojo","blanco","negro")

//Adding element 1 "Verde"
val ele = "Verde" :: lista

//Adding element 2 "Amarillo"
val ele1 = "Amarillo" :: ele

//Adding element 3 "Azul"
val ele2 = "Azul" :: ele1 

//Adding element 4 "Naranja"
val ele3 = "Naranja" :: ele2

//Adding element 5 "Perla"
val ele4 = "Perla" :: ele3 

//The the elements that we are looking for
ele4(4)
ele4(3)
ele4(2)

//The result is 
//scala> ele4(4)
//res7: String = Verde

//scala> ele4(3)
//res8: String = Amarillo

//scala> ele4(2)
//res9: String = Azul