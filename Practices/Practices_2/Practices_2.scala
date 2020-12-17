// Importing this libraries.
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

// Start a simple spark session
import org.apache.spark.sql.SparkSession

//SparkSession.builder.getOrCreate

object DecisionTree {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("dtree")
      .getOrCreate()

// Load the data stored in LIBSVM format as a DataFrame.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")