lazy val defaults = Seq(
  organization := "com.akkademy-db",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.8"
)

lazy val common = (project in file("common"))
  .settings(defaults: _*)

lazy val service = (project in file("service"))
  .settings(defaults: _*)
  .settings(
    name := "akkademy_db_client",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" % "akka-actor_2.11" % "2.4.18",
      "com.typesafe.akka" % "akka-remote_2.11" % "2.4.18",
      "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.18" % "test",
      "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
    ),
    mainClass in (Compile, run) := Some("Main")
  )
  .dependsOn("common")

lazy val client = (project in file("client"))
  .settings(defaults: _*)
  .settings(
    name := "akkademy_db_client",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" % "akka-actor_2.11" % "2.4.18",
      "com.typesafe.akka" % "akka-remote_2.11" % "2.4.18",
      "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.18" % "test",
      "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
    )
  )
  .dependsOn("common")

lazy val root = (project in file("."))
  .settings(defaults: _*)
  .aggregate(common, service, client)
