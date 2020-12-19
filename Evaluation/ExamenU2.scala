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
val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("C:/Users/ivan_/Desktop/Big_Data/Evaluation/iris.csv")
data.show

val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

val Features = (new VectorAssembler (). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")). setOutputCol ("features"))
val data2 = Features.transform (labeltransform)
data2.show

//We show the columns that the dataset contains.
data.columns

//We send to display the schema in the following code.
data.printSchema()


//We send to show the first 5 columns with the following code.
data.show(5)


//With the following method we can see more detailed information about our dataset.
data.describe().show()

//Make the pertinent transformation for the categorical data which will be our labels to be classified.

val data3 = data2.select("features", "label")
data3.show()

val splits = data3.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test = splits(1)

println("training set =",train.count())

println("test set =",test.count())


//Build the classification model and explain its architecture.

val layers = Array[Int](4, 5, 4, 3)

val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

val modelML = trainer.fit(train)
val result = modelML.transform(test)
 val predictionAndLabels = result.select("prediction", "label")
 val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")




//Print the results of the model.
println(s"Test Set Accuracy = ${evaluator.evaluate(predictionAndLabels)}")