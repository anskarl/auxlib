import sbt._

object Dependencies {

  object v {

    final val Logback = "1.2.3"

    final val Slf4j = "1.7.25"

    final val ScalaTest = "3.0.4"

    final val Trove4j = "3.0.3"

  }

  lazy val Logback = "ch.qos.logback" % "logback-classic" % v.Logback

  lazy val Slf4j = "org.slf4j" % "slf4j-api" % v.Slf4j

  lazy val Trove4j = "net.sf.trove4j" % "trove4j" % "3.0.3"

  lazy val ScalaTest = "org.scalatest" %% "scalatest" % v.ScalaTest % "test"

}