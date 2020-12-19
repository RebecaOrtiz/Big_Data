//We import the libraries
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//Load sample_libsvm_data.txt.
var inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

//Generate the train / test split.
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))

//Instantiate base classifier
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)

//Create an instance of the One Vs Rest classifier.
val ovr = new OneVsRest().setClassifier(classifier)

//Trains the multiclass model.
val ovrModel = ovr.fit(train)

//Score the model on the test data.
val predictions = ovrModel.transform(test)

//Get evaluator.
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Calculates the classification error in the test data.
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")