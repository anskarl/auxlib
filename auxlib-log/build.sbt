// project name
name := "auxlib-log"

// load common settings
Common.settings
Common.publishSettings

// Dependencies for logging with slf4j and logback (internal only)
libraryDependencies ++= Seq(
	"ch.qos.logback" % "logback-classic" % "1.1.2" % "compile-internal, test-internal",
	"org.slf4j" % "slf4j-api" % "1.7.7"
)

