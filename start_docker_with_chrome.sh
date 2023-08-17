#!/bin/bash

# Initialises port_mappings with the port numbers of all running applications using the lsof command.
port_mappings=$(lsof -i -P | grep LISTEN | grep :$PORT | grep java | awk '{ print $9"->"$9 }' | sed 's/\*://g' | sed 's/localhost://g' | paste -sd "," -)

port_mappings="$port_mappings,11000->11000,6010->6010"
#echo $port_mappings

# The image accepts two environment variables:
# PORT_MAPPINGS: List of ports of the services under test.
# TARGET_IP: IP of the host machine. For Mac this is 'host.docker.internal'. For linux this is 'localhost'

docker run \
       -d \
       --rm \
       --name "chromium-arm64-with-rinetd" \
       --shm-size=256m \
       -p 4444:4444 \
       -p 5900:5900 \
       -e PORT_MAPPINGS="$port_mappings" \
       -e TARGET_IP='host.docker.internal' \
       chromium-arm64-with-rinetd:114-
