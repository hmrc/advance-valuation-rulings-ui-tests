#!/bin/bash -e
DEFAULT_BROWSER=chrome
BROWSER_TYPE=$1
ENV=$2
TAG=$3


if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi

sbt -Denvironment="$ENV" -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Dcucumber.filter.tags="@$TAG and not @ignore" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.CustomTagRunner'

