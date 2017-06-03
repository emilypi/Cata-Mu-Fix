name := "Cata Mu Fix pt. I"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases")
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

initialCommands in console :=
  "import org.emilypi.cata._, org.emilypi.cata.instances._, org.emilypi.cata.ListF._, org.emilypi.cata.examples._"