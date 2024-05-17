#!/bin/bash
#
# Script to call TermHub to perform autocomplete on a few characters to find potential term searches.
#
limit=10
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  --limit) limit="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 3 ]; then
  echo "Usage: $0 <project> <terminology> <query> [--token token] "
  echo "    [--limit <limit>]"
  echo "  e.g. $0 sandbox SNOMEDCT diab --token \$token"
  exit 1
fi

project=${arr[0]}
terminology=${arr[1]}
query=${arr[2]}

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo "terminology = $terminology"
echo "project = $project"
echo "limit = $limit"
echo ""

# GET call
echo "  Find terms: $query"
curl -v -w "\n%{http_code}" -G "$url/project/$project/autocomplete" -H "Authorization: Bearer $token" --data-urlencode "query=$query" --data-urlencode "limit=$limit" --data-urlencode "terminology=$terminology" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET call failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  cat /tmp/x.$$ | sed 's/^/    /'
  echo "ERROR: GET call returned $status, expected 200"
  exit 1
fi

# write output
echo ""
perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
echo ""

# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
