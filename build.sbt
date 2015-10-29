// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

persistLauncher in Compile := false

persistLauncher in Test := false

libraryDependencies ++= Seq(
  
   "com.lihaoyi" %%% "upickle" % "0.3.6"
)

