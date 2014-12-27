// project name
name := "auxlib"

// load common settings
Common.settings

// disable publishing for root project
publish := { }

lazy val root =
	Project(id = "auxlib", base = file("."))
		.aggregate (auxlibOpt, auxlibLog, auxlibTrove)
		.dependsOn (auxlibOpt, auxlibLog, auxlibTrove, auxlibExamples)

// auxlib-opt
lazy val auxlibOpt =
	Project(id = "auxlib-opt", base = file("auxlib-opt"))
		.settings(Common.publishSettings)

// auxlib-log
lazy val auxlibLog =
	Project(id = "auxlib-log", base = file("auxlib-log"))
		.settings(Common.publishSettings)

// auxlib-trove
lazy val auxlibTrove =
	Project(id = "auxlib-trove", base = file("auxlib-trove"))
		.settings(Common.publishSettings)


// auxlib-examples
lazy val auxlibExamples =
	Project(id = "auxlib-examples", base = file("examples"))
		.dependsOn (auxlibOpt, auxlibLog, auxlibTrove)


