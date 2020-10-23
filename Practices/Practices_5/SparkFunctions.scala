#1.- To import the library
import org.apache.spark.sql.SparkSession

#2.- To create the database where all the functionality hangs
val spark = SparkSession.builder().appName(“MiApp”).master(“local”).getOrCreate()

#3.- To create a dataframe from a text file
val characters = spark.read.json(“/home/vmuser/ficheros/strangersCharacters.json”)

#4.- Function to show the dataframe
characters.show ()

#5.- Function to specifically display column names
characters.columns

#6.- Function to show existing columns and information about them
characters.printSchema ()

#7.- To apply a filter on a dataframe
val children = characters.filter ($. ”age” <13)
children.show

#8.- To display the first 3 elements of the dataframe
children.head (3)
#9.-
#10.-
#11.-
#12.-
#13.-
#14.-
#15.-