Se creo la carpeta Evaluation

# Development 

This exam consists of 11 questions, which were answered one by one, below is a question, answer, and explanation of each question.


**1.- Comienza una simple sesión spark**

//Sparksession library is imported
>import org.apache.spark.sql.SparkSession

//Creating spark sessions
>val spark = SparkSession.builder().getOrCreate()

**2.- Cargue el archivo Netflix Stock CSV, haga que Spark infiera los tipos datos** 

//With spark.read.option you let us read all the data that contains the csv that we want to open 

>val netflix = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

**3.- ¿Cuáles son los nombres de las columnas?**

//With .columns it helps you show all the columns of the data frame

>netflix.columns

**4.- ¿Cómo es el esquema?**

//With .printSchema() helps us to show the whole schema of our data frame

>netflix.printSchema()

**5.- Imprime las primeras 5 columnas** 

//With the .head it helps us to show the columns and the number (5) serves to know how many columns we want to show

>netflix.head(5)

**6.- Usa describe() para aprender sobre el Data Frame** 

//The .describe helps us describe the information that has data frame

>netflix.describe().show()

**7.- Crear un nuevo data frame con una columna nueva llamada “HV Ratio” que es la relación entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día . (Hint : Es una operación de columnas)**

//Another variable was created to display the new data frame by adding the two columns for creating the new "HVRatio"

>val netflix_2 = netflix.withColumn("HVRatio", netflix("High")+ netflix("Volume"))

//The .describe helps us describe the information in the new data frame.

>netflix_2.describe().show

**8.-  ¿Qué día tuvo el pico más alto en la columna “Close”?** 

//An .ordeby was used to sort the data collected from "Close"

>netflix.orderBy($"Close".desc).show(1)

**9.- Escribe con tus propias palabras en un comentario de tu código ¿Cuál es el significado de la columna Cerrar “Close”?**

>//What my partner and I could notice is that the Close column is the average of the high and low columns

**10.- ¿Cuál es el máximo y mínimo de la columna “Volume”?** 

//A .agg was used that serves to group the data, we also use max and min that help us to collect the maximum data and the minimum data of the selected columns


>netflix.agg(max(netflix(netflix.columns(1))), min(netflix(netflix.columns(1)))).show


**11.- Con Sintaxis Scala/Spark $ conteste los siguiente: Hint: Básicamente muy parecido a la session de dates, tendrán que crear otro data frame para contestar algunos de los incisos.** 

//The scala / spark $ library is imported to be able to use the syntax

>import spark.implicits._

**a.-¿Cuántos días fue la columna “Close” inferior a $ 600?**

//With .filter we can filter the information that comes out of the operation ("Close" <600)

>netflix.filter($"Close"<600).count()

**b.- ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?** 

//With .filter we can filter the information that comes out of the operation ("High> 500) then you also have to multiply by 100 to get the percentage

>(netflix.filter($"High">500).count()*1.0/netflix.count())*100

**c.- ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?** 

//With (corr) we can draw the correlation between the two columns 

>netflix.select(corr("High","Volume")).show()

**d.- ¿Cuál es el máximo de la columna “High” por año**

//The .groupby is used to group the data we are looking for from "Date" and the "High"

>netflix.groupBy(year(netflix("Date")).alias("Año"))
.max("High").sort(asc("Año")).show();


e.- ¿Cuál es el promedio de columna “Close” para cada mes del calendario? 

//The .group by is used to group the data we are looking for from "Date" and "Close" and is also used (.max) to calculate the maximum of the data

>netflix.groupBy(month(netflix("Date")).alias("Mes")).avg("Close").sort(asc("Mes")).show();



# Conclusion 

Conducting this exam helped us a lot to realize that we need to improve in the field of Mass Data and in general programming, to know what our strengths are as a team and individual, it helped us to seek solutions to our doubts and above all to work as a team, we hope that this document will be the most complete and understandable.
