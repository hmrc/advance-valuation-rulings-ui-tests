#!/bin/bash

sbt clean scalafmtAll scalastyleAll compile Test/compile dependencyUpdates
