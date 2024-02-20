#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2

export ZAP_LOCAL_ALERT_FILTERS="${PWD}/alert-filters.json"

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" -Dsecurity.assessment="true" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner" testReport

