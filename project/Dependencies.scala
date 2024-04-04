import sbt.*

object Dependencies {

  val test: Seq[ModuleID]    = Seq(
    "com.github.sbt" % "junit-interface" % "0.13.3",
    "io.cucumber"    % "cucumber-junit"  % "7.16.1",
    "io.cucumber"   %% "cucumber-scala"  % "8.21.1",
    "uk.gov.hmrc"   %% "ui-test-runner"  % "0.25.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = test

}
