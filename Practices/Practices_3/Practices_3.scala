// We import bookstores.
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.attribute.Attribute

// To display data from the DataFrame.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Add metadata to the label column, Fit to the entire dataset.
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
val indexed =  labelIndexer.transform(data)

// Identify categorical features and indexelas, MaxCategories (4).val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Training and testing teams.
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// RandomForest model training.
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)

// Convert indexed tags back to original tags.
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels) 

//In a Pipeline.
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))

/ Modelo de entrenamiento
val model = pipeline.fit(trainingData)

// Make predictions.
val predictions = model.transform(testData)

// Select (5) rows.
predictions.select("predictedLabel", "label", "features").show(5)

// Select the prediction and calculate the test error.
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]

println(s"Learned classification forest model:\n ${rfModel.toDebugString}")