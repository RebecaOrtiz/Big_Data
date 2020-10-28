Responder las siguientes preguntas con Spark DataFrames utilizando el “CSV”
Netflix_2011_2016.csv.

/////1. Comienza una simple sesión Spark.

//the sparksession library is imported
import org.apache.spark.sql.SparkSession

//spark session creation
val spark = SparkSession.builder().getOrCreate()


/////2. Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos de datos.

//with spark.read.option it lets us read all the data contained in the csv that we want to open
val netflix = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")



/////3. ¿Cuáles son los nombres de las columnas?

//with .columns it helps you show all the columns of the data frame
netflix.columns

/////4. ¿Cómo es el esquema?

//with .printSchema()helps us to show all the schema of our data frame
netflix.printSchema()

/////5. Imprime las primeras 5 columnas.

//With the .head it helps us to show the columns and the number (5) is used to know how many columns we want to show
netflix.head(5)


/////6. Usa describe () para aprender sobre el DataFrame.

//The .describe helps us to describe the information that the data frame has
netflix.describe().show()

/////7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).

//Another variable was created to show the new data frame adding the two columns for the creation of the new "HVRatio"
val netflix_2 = netflix.withColumn("HVRatio", netflix("High")+ netflix("Volume"))

//The .describe helps us to describe the information of the new data frame
netflix_2.describe().show


/////8. ¿Qué día tuvo el pico mas alto en la columna “Close”?

//An .ordeby was used to sort the data collected from "Close"
netflix.orderBy($"Close".desc).show(1)

/////9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el
//significado de la columna Cerrar “Close”?

//Para nosotros es el promedio de entre alto y bajo 

/////10. ¿Cuál es el máximo y mínimo de la columna “Volume”?

//A .agg was used that serves to group the data, we also use max and min that help us to collect the maximum data and the minimum data of the selected columns
netflix.agg(max(netflix(netflix.columns(1))), min(netflix(netflix.columns(1)))).show

/////11.Con Sintaxis Scala/Spark $ conteste los siguiente:
//◦ Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
//dataframe para contestar algunos de los incisos.

//The scala / spark $ library is imported to be able to use the syntax
import spark.implicits._

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?

//With .filter we can filter the information that comes out of the operation ("Close" <600)
netflix.filter($"Close"<600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?

//With .filter we can filter the information that comes out of the operation ("High> 500) then it also has to be multiplied by 100 to get the percentage
(netflix.filter($"High">500).count()*1.0/netflix.count())*100

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?

//With (corr) we can get the correlation between the two columns
netflix.select(corr("High","Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?

//The .group by is used to group the data we are looking for from "Date" and "Close" and it was also used (.max) to calculate the maximum of the data
netflix.groupBy(year(netflix("Date")).alias("Año")).max("High").sort(asc("Año")).show();

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?

//The .groupby is used to group the data we are looking for from "Date" and "Close" and it was also used (avg) to calculate the average of the data
netflix.groupBy(month(netflix("Date")).alias("Mes")).avg("Close").sort(asc("Mes")).show();
