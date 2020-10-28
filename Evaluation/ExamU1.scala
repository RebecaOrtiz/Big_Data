Responder las siguientes preguntas con Spark DataFrames utilizando el “CSV”
Netflix_2011_2016.csv.



/////1. Comienza una simple sesión Spark.

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()


/////2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.

val netflix = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")



/////3. ¿Cuáles son los nombres de las columnas?

netflix.columns

/////4. ¿Cómo es el esquema?

netflix.printSchema()

/////5. Imprime las primeras 5 columnas.

netflix.head(5)

for(column <- netflix.head(5)){
    println(column)
}

/////6. Usa describe () para aprender sobre el DataFrame.

netflix.describe().show()

/////7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
relación entre el precio de la columna “High” frente a la columna “Volume” de
acciones negociadas por un día. (Hint: Es una operación de columnas).

val netflix_2 = netflix.withColumn("HVRatio", netflix("High")+ netflix("Volume"))

netflix_2.describe().show


/////8. ¿Qué día tuvo el pico mas alto en la columna “Close”?
netflix.orderBy($"Close".desc).show(1)

/////9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//Para nosotros es el promedio de entre alto y bajo 

/////10. ¿Cuál es el máximo y mínimo de la columna “Volume”?

netflix.agg(max(netflix(netflix.columns(1))), min(netflix(netflix.columns(1)))).show

/////11.Con Sintaxis Scala/Spark $ conteste los siguiente:
//◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
//dataframe para contestar algunos de los incisos.

import spark.implicits._

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?
netflix.filter($"Close"<600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
(netflix.filter($"High">500).count()*1.0/netflix.count())*100

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
netflix.select(corr("High","Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?
netflix.groupBy(year(netflix("Date")).alias("Año")).max("High").sort(asc("Año")).show();

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?
netflix.groupBy(month(netflix("Date")).alias("Mes")).avg("Close").sort(asc("Mes")).show();
