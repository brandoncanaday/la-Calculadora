name := "cs1302-calculator"

version := "1.1"

autoScalaLibrary := false

unmanagedSourceDirectories in Compile <<= Seq(javaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(javaSource in Test).join

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test->default"

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

fork in run := true
