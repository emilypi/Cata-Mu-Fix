name := "Cats com.yoppworks.Algebra"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases")
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

initialCommands in console := "import com.yoppworks.scalaupnorth._"