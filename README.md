## auxlib: auxiliary libraries

auxlib is a collection of utility libraries, written in [Scala programming language](http://www.scala-lang.org).


## Licence 

This program comes with ABSOLUTELY NO WARRANTY. This is free software, and you are welcome to redistribute it under certain conditions; See the [GNU Lesser General Public License v3 for more details](http://www.gnu.org/licenses/lgpl-3.0.html).

## auxlib sub-libraries

The auxlib is composed of the following utility libraries:

##### auxlib-opt

Utility library for parsing arguments from command line interface (based on the source code of https://gist.github.com/246481)

##### auxlib-trove

A collection of utility classes and functions for Scala friendly interoperabilty with [Trove](http://trove.starlight-systems.com) high-performance collections for Java.

##### auxlib-log

A simple utility library for logging that employs the [slf4j](http://www.slf4j.org).

## Instructions to build sub-libraries from source

In order to build auxlib from source, you need to have Java (at least version 6) and [sbt](http://www.scala-sbt.org) installed in your system.

##### To start building all sub-libraries, type the following command:

```
$ sbt compile
```

##### To publish all sub-libraries to your local maven repository, type the following command:

```
$ sbt publish
```

## Cross-building

By default compile and publish produce auxlib-* jars for Scala 2.10.4. This project supports cross-building for both Scala 2.10.4 and 2.11.4 (for details see [sbt documentation](http://www.scala-sbt.org/0.13.5/docs/Detailed-Topics/Cross-Build.html)). In sbt you can use ++ <version> to temporarily switch the Scala version currently being used to build.

##### To start building all sub-libraries only for Scala 2.11.4, type the following command:

```
$ sbt ++2.11.4 compile
```

##### To start building all sub-libraries for both Scala 2.10.4 and 2.11.4, type the following command:

```
$ sbt +compile
```

##### To publish all sub-libraries for both Scala 2.10.4 and 2.11.4 to your local maven repository, type the following command:

```
$ sbt ++2.11.4 publish
```

##### To publish all sub-libraries for both Scala 2.10.4 and 2.11.4 to your local maven repository, type the following command:

```
$ sbt +publish
```

