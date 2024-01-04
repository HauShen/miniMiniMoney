#!/bin/bash

wiremockDir="wiremock"
wiremockVersion="3.3.1"

wiremockPort="5555"
wiremockFile=wiremock-standalone-3.3.1.jar

if [ -d "$wiremockDir" ]
  then
    echo "$wiremockDir found."
    cd $wiremockDir
    ls
    if [ -e "$wiremockFile" ]
      then
        echo "$wiremockFile" found.
        java -jar $wiremockFile --port $wiremockPort --verbose global-response-templating
      else
        echo "$wiremockFile not found"
      fi
  else
      echo "$wiremockDir not found."
  fi