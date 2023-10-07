#!/bin/bash
#
# Script to call TermHub to get a specific terminology
# by terminology/publisher/version.
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 3 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] <terminology> <publisher> <version>"
  echo "  e.g. $0 --token \$token"
  echo "  e.g. $0 --token \$token ICD10CM SANDBOX 2023"
  echo "  e.g. $0 --token \$token SNOMEDCT SANDBOX 20230731"
  exit 1
fi

terminology=${arr[0]}
publisher=${arr[1]}
version=${arr[2]}


# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo ""

# GET call
echo "  Performing terminologies lookup"
curl -v -w "\n%{http_code}" -G "$url/terminology/$terminology/$publisher/$version" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/terminology/$terminology/$publisher/$version failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/terminology/$terminology/$publisher/$version returned $status, expected 200"
  exit 1
fi

# Output the result
ct=`perl -pe 's/200$//' /tmp/x.$$ | jq '. | length'`
echo "    count = $ct"
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
