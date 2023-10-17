#!/bin/bash -e
DEFAULT_BROWSER=chrome
BROWSER_TYPE=$1
ENV=$2

if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi

if [ "$ENV" = "staging" ]
then
  sbt -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Denvironment="staging" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.JourneyTestsRunnerStaging"
 else
  sbt -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Denvironment="local" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.JourneyTestsRunnerLocal"
fi


