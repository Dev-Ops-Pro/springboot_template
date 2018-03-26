#!/usr/bin/env

bashRESPONSE=$(curl -sX GET http://localhost:8080/healthCheck)

echo $RESPONSE
if [ "$RESPONSE" != "Feeling healthy" ]
then
	exit 1
fi