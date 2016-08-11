import sbt._
import Keys._

object Common {

  val settings: Seq[Setting[_]] = Seq(

    version := "0.2.0",

    organization := "com.github.anskarl",

    crossScalaVersions := Seq("2.11.7", "2.10.6"),

    autoScalaLibrary := true,

    managedScalaInstance := true,

    // Append several options to the list of options passed to the Java compiler
    javacOptions ++= Seq("-source", "1.7", "-target", "1.7", "-Xlint:unchecked", "-Xlint:deprecation"),

    // Append scalac options
    scalacOptions ++= Seq(
      "-optimise",
      "-Yclosure-elim",
      "-Yinline",
      "-feature",
      "-target:jvm-1.7",
      "-language:implicitConversions"
    ),

    // fork a new JVM for 'run' and 'test:run'
    fork := true,

    // fork a new JVM for 'test:run', but not 'run'
    fork in Test := true,

    // Dependencies for unit testing (only for compile and test, exclude from publishing)
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "compile-internal, test-internal"
  )

  val publishSettings: Setting[_] = publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

}