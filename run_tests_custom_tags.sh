#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2
TAG=$3

sbt clean \
  -Dbrowser="${BROWSER:=chrome}" \
  -Denvironment="${ENVIRONMENT:=local}" \
  "testOnly uk.gov.hmrc.ui.specs.* -- -n uk.gov.hmrc.ui.tags.${TAG} -l uk.gov.hmrc.ui.tags.Ignore" \
  testReport
