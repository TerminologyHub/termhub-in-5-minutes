#!/bin/bash
#
# Script to call TermHub to get a specific terminology
# by terminologyId/projectIdOrUrl.
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  --id) id="$2"; shift;;
  --project) project="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 0 ] || [ -z $token ] || \
  ([ ! -z $id ] && [ ! -z $project  ])|| \
  ([ -z $id ] && [ -z $project ]) ; then
  echo "Usage: $0 [--token token] [ --id terminologyId | --project projectIdOrUrl ] "
  echo "  e.g. $0 --token \$token --id 166c6448-318e-4ddc-a6a8-374274e17e5"
  echo "  e.g. $0 --token \$token --project demoProject"
  exit 1
fi

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
if [ ! -z $id ]; then
  target_url="$url/terminology/$id"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
else
  target_url="$url/project/$project/terminology"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
fi
if [ $? -ne 0 ]; then
  echo "ERROR: GET $target_url failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $target_url returned $status, expected 200"
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
