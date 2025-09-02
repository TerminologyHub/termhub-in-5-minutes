#!/bin/bash
#
# Script to call TermHub to get a specific subset by project id
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 2 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] <projectId> <subset>"
  echo "e.g. $0 --token \$token sandbox SNOMEDCT_US-MODEL"
  echo "e.g. $0 --token \$token sandbox 2a545e12-04eb-48ee-b988-c17346b4e05f"

  exit 1
fi

projectId=${arr[0]}
subset=${arr[1]}

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo ""

# GET call
echo "  Performing subset export to file $subset.zip"
curl -v -o $subset.zip -w "\n%{http_code}" -G "$url/project/$projectId/subset/$subset/export?format=native" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/project/$projectId/subset/$subset/export?format=native failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/project/$projectId/subset/$subset/export?format=native returned $status, expected 200"
  exit 1
fi

# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
