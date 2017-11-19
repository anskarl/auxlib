## auxlib: auxiliary libraries

auxlib is a collection of utility libraries, written in [Scala programming language](http://www.scala-lang.org).

## auxlib sub-libraries

The auxlib is composed of the following utility libraries:

##### auxlib-opt

Utility library for parsing arguments from command line interface (based on the gist source code in
https://gist.github.com/246481)

##### auxlib-trove

A collection of utility classes and functions for Scala friendly interoperability with 
[Trove](http://trove.starlight-systems.com) high-performance collections for Java.

##### auxlib-log

A simple utility library for logging that employs the [slf4j](http://www.slf4j.org).

## Instructions to build sub-libraries from source

In order to build auxlib from source, you need to have Java (at least version 6) and [sbt](http://www.scala-sbt.org) installed in your system.

*To start building all sub-libraries, type the following command:*

```
$ sbt compile
```

*To publish all sub-libraries to your local Apache Ivy directory (e.g., inside ~/.ivy2/local/), 
type the following command:*

```
$ sbt publishLocal
```

## Cross-building

By default compile and publish produce auxlib-* jars for Scala 2.12.4. This project supports cross-building for both 
Scala 2.12.4 and 2.11.12 (for details see [sbt documentation](http://www.scala-sbt.org/0.13/docs/Cross-Build.html)). 
In SBT you can use ++ <version> to temporarily switch the Scala version currently being used to build.

*To start building all sub-libraries only for Scala 2.11.12, type the following command:*

```
$ sbt ++2.11.12 compile
```

*To start building all sub-libraries for both Scala 2.12.4 and 2.11.12, type the following command:*

```
$ sbt +compile
```

*To publish all sub-libraries for both Scala 2.12.4 and 2.11.12 to your local Apache Ivy directory, 
type the following command:*

```
$ sbt ++2.11.12 publishLocal
```

*To publish all sub-libraries for both Scala 2.12.4 and 2.11.12 to your local Apache Ivy directory, 
type the following command:*

```
$ sbt +publishLocal
```

