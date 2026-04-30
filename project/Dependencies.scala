import sbt.*

object Dependencies {

  private val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"   %% "ui-test-runner"  % "0.54.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = test

}
