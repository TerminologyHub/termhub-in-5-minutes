#!/bin/bash
#
# Script to call TermHub to get a specific terminology
# by projectId/terminology
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 2 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] <projectId> <terminology>"
  echo "e.g. $0 --token \$token sandbox SNOMEDCT"
  echo "e.g. $0 --token \$token sandbox e6afba85-a4d8-42d9-9712-81faebc152b8"

  exit 1
fi

projectId=${arr[0]}
terminology=${arr[1]}

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo ""

# GET call
echo "  Performing terminology export to file $terminology.zip"
curl -v -o $terminology.zip -w "\n%{http_code}" -G "$url/project/$projectId/terminology/$terminology/export?format=native" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/project/$projectId/terminology/$terminology/export?format=native failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/project/$projectId/terminology/$terminology/export?format=native returned $status, expected 200"
  exit 1
fi

# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
