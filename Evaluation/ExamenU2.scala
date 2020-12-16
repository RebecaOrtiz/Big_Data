/* We use Spark's Mllib library is a very complete library that contains numerous Machine Learning 
algorithms, both clustering, classification, regression, etc. It allows us, in a friendly way, 
to be able to use Machine Learning algorithms. We also make use of the Machine Learning algorithm 
corresponding to Multilayer Perceptron*/
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer} 
import org.apache.spark.ml.linalg.Vectors 

//We start the session with spark
import org.apache.spark.sql.SparkSession


//We load our dataset with the corresponding .cvs file
val data = spark.read.option("header","true").option("inferSchema","true").format("cvs").load("iris.cvs")


//We show the columns that the dataset contains.
data.columns

//We send to display the schema in the following code.
data.printSchema()


//We send to show the first 5 columns with the following code.
data.show(5)


//With the following method we can see more detailed information about our dataset.
data.describe().show()

