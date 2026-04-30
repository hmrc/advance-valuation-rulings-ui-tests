#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2

sbt clean -Dbrowser="${BROWSER:=chrome}" -Dbrowser.usePreviousVersion=true -Denvironment="${ENVIRONMENT:=local}" -Dsecurity.assessment="false" "testOnly uk.gov.hmrc.ui.specs.*" -Daccessibility.timeout="1000" testReport
