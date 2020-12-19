//We import the libraries
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession


 //Object creation
object MultilayerPerceptronClassifierExample {

//Main function
  def main(): Unit = {
    //Creation of sparksession class object.
    val spark = SparkSession
      .builder
      .appName("MultilayerPerceptronClassifierExample")
      .getOrCreate()


    //Load sample_libsvm_data.txt.
    val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

    //Training and test sets 
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)

    //layers of the neural network:
    val layers = Array[Int](4, 5, 4, 3)

    //Training parameters
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)

    //Training model
    val model = trainer.fit(train)

    //Prediction of test data
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator()
      .setMetricName("accuracy")

    //Model print
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")


    spark.stop()
  }
}