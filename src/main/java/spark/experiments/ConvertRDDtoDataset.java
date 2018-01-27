package spark.experiments;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import spark.experiments.*;

import scala.Tuple2;
import org.apache.spark.SparkContext.*;
import org.apache.spark.api.*;

import java.util.Collections;

public class ConvertRDDtoDataset {

	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().master("local[*]").appName("Conversion Example").getOrCreate();

		JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());
	
		JavaRDD<Person> javaRDD = sc.parallelize(Collections.singletonList(new Person(1, "test", "test"))); 

		Dataset<Person> ds = spark.createDataset(javaRDD.rdd(), Encoders.bean(Person.class))); 
				
	}

}