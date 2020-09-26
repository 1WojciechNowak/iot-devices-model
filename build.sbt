name := "iot-devices-model"

organization := "ai.wojciechnowak"
version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "com.julianpeeters" %% "avrohugger-core" % "1.0.0-RC22"

sourceGenerators in Compile += (avroScalaGenerateSpecific in Compile).taskValue
(avroSpecificSourceDirectories in Compile) := Seq(new File("src/main/resources/avro"))
(avroSpecificScalaSource in Compile) := Keys.target.value

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}