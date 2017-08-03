name := "Cata Mu Fix"

version := "1.0"

scalaVersion := "2.12.3"

//libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases")
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

scalacOptions += "-Ypartial-unification"

initialCommands in console :=
  "import " +
    "org.emilypi.schemes._, " +
    "org.emilypi.schemes.instances._, " +
    "org.emilypi.schemes.examples._, " +
    "org.emilypi.moreschemes._," +
    "org.emilypi.algebra._"

licenses += "GPLv3" -> url("https://www.gnu.org/licenses/gpl-3.0.html")


javaOptions in run ++= Seq(
  "-Xms512M",
  "-Xmx2G",
  "-Xss8M",
  "-XX:+UseG1GC"
)

fork in run := true