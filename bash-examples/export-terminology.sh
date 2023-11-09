#!/bin/bash
#
# Script to call TermHub to get a specific terminology
# by projectId/terminology/publisher/version.
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 4 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] <projectId> <terminology> <publisher> <version>"
  echo "e.g. $0 --token \$token 1878ce91-ca3d-4c50-b7c4-bbed76261e72 ALLERGY TERMHUB 3.0"

  exit 1
fi

projectId=${arr[0]}
terminology=${arr[1]}
publisher=${arr[2]}
version=${arr[3]}


# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo ""

# GET call
echo "  Performing terminology export"
curl -v -o $terminology-$publisher-$version.zip -w "\n%{http_code}" -G "$url/terminology/$projectId/$terminology/$publisher/$version/export?format=native" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/terminology/$projectId/$terminology/$publisher/$version/export?format=native failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/terminology/$projectId/$terminology/$publisher/$version/export?format=native returned $status, expected 200"
  exit 1
fi

# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
