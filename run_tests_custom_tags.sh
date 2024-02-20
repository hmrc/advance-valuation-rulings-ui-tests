#!/bin/bash -e
BROWSER=$1
ENVIRONMENT=$2
TAG=$3

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}"  -Dcucumber.filter.tags="@$TAG and not @ignore" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.CustomTagRunner' testReport