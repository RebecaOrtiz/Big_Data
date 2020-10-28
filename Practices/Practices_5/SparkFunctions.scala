#1.- To import the library
import org.apache.spark.sql.SparkSession
// 

#2.- To create the database where all the functionality hangs
val spark = SparkSession.builder().appName(“MiApp”).master(“local”).getOrCreate()

// 3 To read the data 
val wine = spark.read.option("header", "true").option("inferSchema","true")csv("wine.csv")

#4.- To create a dataframe from a text file
val characters = spark.read.json(“/home/vmuser/ficheros/strangersCharacters.json”)

#5.- Function to show the dataframe
wine.show ()

//6.- Function to show specific data 
wine.select("country","points").show();

#7.- Function to specifically display column names
wine.columns

#8.- Function to show existing columns and information about them
wine.printSchema ()

#9.- To apply a filter on a dataframe
val children = characters.filter ($. ”age” <13)
children.show

#10.- To display the first 3 elements of the dataframe
children.head (3)

//11.- description of the dataset 
wine.describe().show()

//12.-filter price greater than 300
wine.filter("price > 300").show()

//13.-filter price greater than 300 and points greater than 80
wine.filter("price > 300 AND points > 80").show()

//14.-filter the only ones that have 96 points
wine.filter("points = 96").show()

//15.-The average of the data (price)
wine.select(avg("price")).show()

