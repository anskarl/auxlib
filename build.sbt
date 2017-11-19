
// auxlib-opt
lazy val auxlibOpt = Project("auxlib-opt", file("auxlib-opt"))

// auxlib-log
lazy val auxlibLog = Project("auxlib-log", file("auxlib-log"))
  .settings(libraryDependencies += Dependencies.Logback)
  .settings(libraryDependencies += Dependencies.Slf4j)

// auxlib-trove
lazy val auxlibTrove = Project("auxlib-trove", file("auxlib-trove"))
	.settings(libraryDependencies += Dependencies.Trove4j)

// auxlib-examples
lazy val auxlibExamples = Project(id = "auxlib-examples", base = file("examples"))
	.settings(publish := { }, publishLocal := { })
  .settings(libraryDependencies += Dependencies.Logback)
  .settings(libraryDependencies += Dependencies.Slf4j)
	.dependsOn(auxlibOpt, auxlibLog, auxlibTrove)

// root project
lazy val root = Project("auxlib", file("."))
	.settings(Seq(publish := { }, publishLocal := { }))
	.aggregate(auxlibOpt, auxlibLog, auxlibTrove, auxlibExamples)
