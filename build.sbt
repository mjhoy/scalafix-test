ThisBuild / scalaVersion := "2.13.14"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = (project in file("."))
  .dependsOn(scalafixRules % ScalafixConfig)
  .settings(
    name := "FixTest"
  )

lazy val scalafixRules = (project in file("scalafix/rules"))
  .disablePlugins(ScalafixPlugin)
  .settings(
    libraryDependencies +=
      "ch.epfl.scala" %%
        "scalafix-core" %
        _root_.scalafix.sbt.BuildInfo.scalafixVersion
  )
