import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

/** Project */
name := "auxlib-trove"

version := "0.1"

organization := "com.github.anskarl"

crossScalaVersions := Seq("2.10.4", "2.11.4")

autoScalaLibrary := true

managedScalaInstance := true

packageArchetype.java_application


// Append several options to the list of options passed to the Java compiler
javacOptions ++= Seq("-source", "1.7", "-target", "1.7", "-Xlint:unchecked", "-Xlint:deprecation")

// Append scalac options
scalacOptions ++= Seq(
	"-optimise",
	"-Yclosure-elim",
	"-Yinline",
	"-feature",
	"-target:jvm-1.7",
	"-language:implicitConversions"
)

// fork a new JVM for 'run' and 'test:run'
fork := true

// fork a new JVM for 'test:run', but not 'run'
fork in Test := true

libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value

// For unit testing
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"

// GNU Trove4j for high performance and memory efficient data-structures
libraryDependencies += "net.sf.trove4j" % "trove4j" % "3.0.3"
