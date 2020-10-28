Responder las siguientes preguntas con Spark DataFrames utilizando el “CSV”
Netflix_2011_2016.csv.



/////1. Comienza una simple sesión Spark.

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()


/////2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016")



/////3. ¿Cuáles son los nombres de las columnas?
 
 df.columns

/////4. ¿Cómo es el esquema?

df.printSchema()

/////5. Imprime las primeras 5 columnas.

df.head(5)

for(column <- df.head(5)){
    println(column)
}

/////6. Usa describe () para aprender sobre el DataFrame.

df.describe().show()

/////7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
relación entre el precio de la columna “High” frente a la columna “Volume” de
acciones negociadas por un día. (Hint: Es una operación de columnas).

val newdf = df.withColumn("HVRatio", df("High")+df("“Volume”"))



/////8. ¿Qué día tuvo el pico mas alto en la columna “Close”?

9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el
significado de la columna Cerrar “Close”?

10. ¿Cuál es el máximo y mínimo de la columna “Volume”?

11.Con Sintaxis Scala/Spark $ conteste los siguiente:
◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
dataframe para contestar algunos de los incisos.
a. ¿Cuántos días fue la columna “Close” inferior a $ 600?

b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?

c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?

d. ¿Cuál es el máximo de la columna “High” por año?

e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?