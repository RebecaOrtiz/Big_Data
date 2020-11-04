//Add 5 more elements to "Lista" "Verde","Amarillo","Azul","Naranja","Perla"

//The list that we are going to add the new elements
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

//The result is 
//scala> ele5
//res5: List[String] = List(Perla, Naranja, Azul, amarillo, Verde, rojo, blanco, negro)