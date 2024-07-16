#!/bin/bash

sbt clean scalafmtAll compile Test/compile dependencyUpdates
