import sbt._

object Dependencies {

  val test = Seq(
    "com.typesafe"         % "config"            % "1.4.3"    % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.64.8"   % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.17"   % Test,
    "org.scalatestplus"   %% "selenium-4-2"      % "3.2.13.0" % Test,
    "io.cucumber"         %% "cucumber-scala"    % "8.17.0"   % Test,
    "io.cucumber"          % "cucumber-junit"    % "7.14.0"   % Test,
    "junit"                % "junit"             % "4.13.2"   % Test,
    "com.novocode"         % "junit-interface"   % "0.11"     % Test,
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.46.0"   % Test
  )

}
