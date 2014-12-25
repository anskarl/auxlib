import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

/** Project */
name := "auxlib"

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

lazy val root = Project(id = "auxlib", base = file(".")) aggregate (auxlibOpt, auxlibLog, auxlibTrove) dependsOn (auxlibOpt, auxlibLog, auxlibTrove)

// auxlib-opt
lazy val auxlibOpt = Project(id = "auxlib-opt", base = file("auxlib-opt"))

// auxlib-log
lazy val auxlibLog = Project(id = "auxlib-log", base = file("auxlib-log"))

// auxlib-trove
lazy val auxlibTrove = Project(id = "auxlib-trove", base = file("auxlib-trove"))
