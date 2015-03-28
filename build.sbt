name := "scratch-scala"

organization := "pismute"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.1" % "test"// withSources() withJavadoc()
)

testOptions in Test += Tests.Argument("-oD")

//scalacOptions in Test ++= Seq("-Yrangepos")

// for fork
//javaOptions in run += "-Xmx64M"

connectInput in run := true

//fork in run := true
