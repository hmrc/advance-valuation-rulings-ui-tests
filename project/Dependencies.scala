import sbt.*

object Dependencies {

  private val test: Seq[ModuleID] = Seq(
    "com.github.sbt" % "junit-interface" % "0.13.3",
    "io.cucumber"    % "cucumber-junit"  % "7.22.2",
    "io.cucumber"   %% "cucumber-scala"  % "8.27.3",
    "uk.gov.hmrc"   %% "ui-test-runner"  % "0.52.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = test

}
