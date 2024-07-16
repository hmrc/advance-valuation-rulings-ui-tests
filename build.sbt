ThisBuild / scalaVersion := "2.13.14"

lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) // Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "advance-valuation-rulings-ui-tests",
    version := "2.0.0",
    scalacOptions += "-feature",
    libraryDependencies ++= Dependencies(),
    // The testOptions from SbtAutoBuildPlugin supports only ScalaTest. Resetting testOptions for Cucumber Tests.
    Test / testOptions := Seq.empty
  )

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt Test/scalafmt")
