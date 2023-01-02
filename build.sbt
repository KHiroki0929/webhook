name := "akka"
version := "1.0"
scalaVersion := "2.13.10"

val akkaVersion = "2.6.9"
val akkaHttpVersion = "10.2.0"
val circeVersion = "1.34.0"
val corsVersion = "1.1.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
  "de.heikoseeberger" %% "akka-http-circe" % circeVersion,
  "ch.megard" %% "akka-http-cors" % corsVersion
)