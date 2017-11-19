import sbt._
import Keys._
import sbt.plugins.JvmPlugin

object Common extends AutoPlugin {

  val logger = ConsoleLogger()


  logger.info(
    """
      |                    __     _ _
      |                    \ \   (_) |
      |    __ _ _   ___  __ \ \   _| |__
      |   / _` | | | \ \/ /  > \ | | '_ \
      |  | (_| | |_| |>  <  / ^ \| | |_) |
      |   \__,_|\__,_/_/\_\/_/ \_\_|_.__/
    """.stripMargin)

  override def requires = JvmPlugin

  /**
    * Allow the plug-in to be included automatically
    */
  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[Setting[_]] = Seq(

    //version := "0.3.0-SNAPSHOT",

    organization := "com.github.anskarl",

    crossScalaVersions := Seq("2.12.4", "2.11.12"),

    autoScalaLibrary := true,

    managedScalaInstance := true,

    // Append several options to the list of options passed to the Java compiler
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint:unchecked", "-Xlint:deprecation"),

    scalaVersion := "2.12.4",

    scalacOptions := {
      scalaBinaryVersion.value match {

        case "2.11" =>
          // Scala compiler settings for Scala 2.12.x
          Seq(
            "-deprecation",       // Emit warning and location for usages of deprecated APIs.
            "-unchecked",         // Enable additional warnings where generated code depends on assumptions.
            "-feature",           // Emit warning and location for usages of features that should be imported explicitly.
            "-target:jvm-1.8",    // Target JVM version 1.8
            "-Ywarn-dead-code",   // Warn when dead code is identified.
            "-Yinline-warnings",  // Emit inlining warnings
            "-Yclosure-elim",     // Perform closure elimination
            "-Ybackend:GenBCode"  // Use the new optimisation level
          )

        case "2.12" =>
          // Scala compiler settings for Scala 2.12+
          // see https://tpolecat.github.io/2017/04/25/scalac-flags.html
          Seq(
            "-deprecation",       // Emit warning and location for usages of deprecated APIs.
            "-unchecked",         // Enable additional warnings where generated code depends on assumptions.
            "-feature",           // Emit warning and location for usages of features that should be imported explicitly.
            "-target:jvm-1.8",    // Target JVM version 1.8
            "-Ywarn-dead-code"    // Warn when dead code is identified.
          )
        case _ => sys.error(s"Unsupported version of Scala '${scalaBinaryVersion.value}'")
      }
    },

    // fork a new JVM for 'run' and 'test:run'
    fork := true,

    // fork a new JVM for 'test:run', but not 'run'
    fork in Test := true,

    libraryDependencies += Dependencies.ScalaTest,

    publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
  )

}