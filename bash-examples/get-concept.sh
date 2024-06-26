#!/bin/bash
#
# Script to call TermHub to perform a concept code lookup.
#
include=summary
while [[ "$#" -gt 0 ]]; do case $1 in
  --include) include="$2"; shift;;
  --token) token="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 3 ]; then
  echo "Usage: $0 <terminology> <project> <code> [--token token]"
  echo "    [--include <minimal,summary,full,terms,parents,children,...>]"
  echo "  e.g. $0 sandbox SNOMEDCT 73211009 --token \$token"
  echo "  e.g. $0 sandbox SNOMEDCT 73211009 --include min --token \$token"
  echo "  e.g. $0 sandbox SNOMEDCT 73211009 --include min,parents --token \$token"
  echo "  e.g. $0 sandbox SNOMEDCT 73211009 --include summary,ancestors --token \$token"
  exit 1
fi

project=${arr[0]}
terminology=${arr[1]}
code=${arr[2]}

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo "terminology = $terminology"
echo "project= $project"
echo "code = $code"
echo "include = $include"
echo ""

# GET call
echo "  Get concept for $terminology $code:"
curl -v -w "\n%{http_code}" -G "$url/project/$project/concept/$terminology/$code" --data-urlencode "include=$include" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$

if [ $? -ne 0 ]; then
  cat /tmp/x.$$
  echo "ERROR: GET call failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  cat /tmp/x.$$ | sed 's/^/    /'
  echo "ERROR: GET returned $status, expected 200"
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
