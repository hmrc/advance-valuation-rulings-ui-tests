import sbt.*

object Dependencies {

  val test: Seq[ModuleID]    = Seq(
    "com.github.sbt" % "junit-interface" % "0.13.3",
    "io.cucumber"    % "cucumber-junit"  % "7.15.0",
    "io.cucumber"   %% "cucumber-scala"  % "8.20.0",
    "uk.gov.hmrc"   %% "ui-test-runner"  % "0.21.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = test

}
