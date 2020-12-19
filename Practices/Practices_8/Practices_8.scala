//We import the libraries
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//Load sample_libsvm_data.txt.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
data.show(2)

//Training and test sets 
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)

//Training Naive Bayes.
val model = new NaiveBayes().fit(trainingData)

//Select rows.
val predictions = model.transform(testData)
predictions.show()

//Select prediction and compute test error.
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)

println(s"Test set accuracy = $accuracy")