import sbt.*

object Dependencies {

  private val test: Seq[ModuleID] = Seq(
    "com.github.sbt" % "junit-interface" % "0.13.3",
    "io.cucumber"    % "cucumber-junit"  % "7.20.1",
    "io.cucumber"   %% "cucumber-scala"  % "8.25.1",
    "uk.gov.hmrc"   %% "ui-test-runner"  % "0.42.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = test

}
