import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

/** Project */
name := "auxlib-log"

version := "0.1"

organization := "com.github.anskarl"

scalaVersion := "2.10.4"

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


// Logging with slf4j and logback
libraryDependencies ++= Seq(
	"ch.qos.logback" % "logback-classic" % "1.1.2",
	"ch.qos.logback" % "logback-core" % "1.1.2",
	"org.slf4j" % "slf4j-api" % "1.7.7"
)
