#!/usr/bin/env bash

echo "=========================================================="
echo "ELIS VERIFI entrypoint.sh starting up with PID $$"
echo "JAVA OPTIONS: ${JAVA_OPTS}"
echo "=========================================================="

exec java $JAVA_OPTS  -jar app.jar