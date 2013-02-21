import sbt._
import sbt.Keys._

object HttpstatusBuild extends Build {

  lazy val httpstatus = Project(
    id = "httpstatus",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "httpstatus",
      organization := "me.masahito",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2",
      libraryDependencies ++= Seq(
        // test
        "org.scalatest" %% "scalatest" % "1.8" % "test",
	"org.scalacheck" %% "scalacheck" % "1.10.0" % "test",

        //log
        "org.clapper" %% "grizzled-slf4j" % "0.6.9",
        "ch.qos.logback" % "logback-classic" % "1.0.1"
      )
      // add other settings here
    )
  )
}
