// project name
name := "auxlib-examples"

// load common settings
Common.settings

// disable publishing for examples
publish := { }

// Dependencies for logging with slf4j and logback/log4j.
libraryDependencies ++= Seq(
	"ch.qos.logback" % "logback-classic" % "1.1.2",
	// "org.apache.logging.log4j" % "log4j-api" % "2.1",
	// "org.apache.logging.log4j" % "log4j-core" % "2.1",
	"org.slf4j" % "slf4j-api" % "1.7.7"
)