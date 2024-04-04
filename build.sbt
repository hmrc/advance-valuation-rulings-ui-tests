val appName = "advance-valuation-rulings-ui-tests"

ThisBuild / scalaVersion := "2.13.13"

lazy val testSuite =
  Project(appName, file("."))
    .disablePlugins(JUnitXmlReportPlugin) // Required to prevent https://github.com/scalatest/scalatest/issues/1427
    .settings(
      version := "0.1.0",
      scalacOptions ++= Seq("-feature"),
      scalafmtOnCompile := true,
      libraryDependencies ++= Dependencies.test,
      // The testOptions from SbtAutoBuildPlugin supports only ScalaTest. Resetting testOptions for Cucumber Tests.
      Test / testOptions := Seq.empty
    )

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt Test/scalafmt")
addCommandAlias("scalastyleAll", "all scalastyle Test/scalastyle")
