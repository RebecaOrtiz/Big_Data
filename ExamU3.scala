// Import a simple Spark session.
import org.apache.spark.sql.SparkSession

// Lines of code to minimize errors.
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Spark session instance.
val spark = SparkSession.builder().getOrCreate()

// Kmeans library for the grouping algorithm.
import org.apache.spark.ml.clustering.KMeans

// We load the Wholesale Customers Data dataset.
val Wholesale = spark.read.option("header","true").option("inferSchema","true").csv("Whole_sale_customers_data.csv")

// We select the columns :Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen y la llamamos el conjunto feature_data
val  feature_data  = dataset.select("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")

// We import Vectorassembler and Vector.
import org.apache.spark.ml.feature.VectorAssembler

// We create a new assemble vector object for feature columns.
val assembler = new VectorAssembler().setInputCols(Array("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")).setOutputCol("features")

// Assembler object to transform feature_data.
val  features = assembler.transform(feature_data)

// Creation of the Kmeans model with a value of K x 3.
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)

// Evaluating groups using Within Set Sum of Squared Errors WSSS.
val WSSSE = model.computeCost(features)
println(s"Within Set Sum of Squared Errors = $WSSSE")

// Print cluster centers.
println("Cluster Centers: ")
model.clusterCenters.foreach(println)