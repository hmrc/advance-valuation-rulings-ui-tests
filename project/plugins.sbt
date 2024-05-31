resolvers += "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
resolvers += Resolver.url("HMRC-open-artefacts-ivy2", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(
  Resolver.ivyStylePatterns
)

addSbtPlugin("uk.gov.hmrc"      % "sbt-auto-build"        % "3.22.0")
addSbtPlugin("org.scalameta"    % "sbt-scalafmt"          % "2.5.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates"           % "0.6.4")
addSbtPlugin("org.scalastyle"   % "scalastyle-sbt-plugin" % "1.0.0" exclude ("org.scala-lang.modules", "scala-xml_2.12"))
addSbtPlugin("uk.gov.hmrc"      % "sbt-test-report"       % "1.0.0")
