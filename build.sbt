lazy val commonSettings = List(
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4"),
  organization := "com.emilypi",
  version := "0.0.1",
  scalaVersion := "2.12.4",
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  scalacOptions ++= List(
    "-deprecation",
    "-unchecked",
    "-feature",
    "-encoding",
    "UTF-8",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Xfuture",
    "-language:postfixOps"
  ),
  javaOptions in run ++= List(
    "-Xms512M",
    "-Xmx2G",
    "-Xss8M",
    "-XX:+UseG1GC"
  ),
  fork in run := true,
  resolvers ++= List(Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases")),
  initialCommands in console :=
    "import " +
      "org.emilypi.schemes._, " +
      "org.emilypi.schemes.instances._, " +
      "org.emilypi.schemes.examples._, " +
      "org.emilypi.moreschemes._,"
)

lazy val root = (project in file("."))
  .settings(name := "Cata Mu Fix")
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Nil)