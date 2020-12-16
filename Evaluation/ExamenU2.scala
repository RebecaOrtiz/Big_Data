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

//Make the pertinent transformation for the categorical data which will be our labels to be classified.
val data3 = data2.randomSplit(Array(0.07, 0.03), seed = 1234L)
val train = splits(0)
val test = splits(1)

println("Training Set =", train.count())
println("Test Set =", test.count())

//Build the classification model and explain its architecture.
val layers = Array[Int](4, 5, 4, 3)
val trainer = new 
MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).set
seed(1234L).setMaxIter(100)
val ModelML = trainer.fit(train)
val result = ModelML.transform(test)

val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print the results of the model.
println(s"Test Set Accuracy = ${evaluator.evaluate(predictionAndLabels)}")