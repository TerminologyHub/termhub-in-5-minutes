#!/bin/bash
#
# Script to call TermHub to perform concept mappings lookup for a code.
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  --limit) limit="$2"; shift;;
  --offset) offset="$2"; shift;;
  --ascending) ascending="$2"; shift;;
  --sort) sort="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 3 ]; then
  echo "Usage: $0 <project> <terminology> <code> [--token token] [--limit #]"
  echo "    [--offset #] [--ascending <true|false>] [--sort <sort>] "
  echo "  e.g. $0 sandbox SNOMEDCT_US 73211009 --token \$token"
  echo "  e.g. $0 sandbox SNOMEDCT_US 73211009 --token \$token --limit 5 --sort type"
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
echo "code = $code"
echo ""

if [[ -z $offset ]]; then
  offset=0
fi

if [[ -z $limit ]]; then
  limit=10
fi
if [[ -z $ascending ]]; then
  ascending=
fi
if [[ -z $sort ]]; then
  sort=
fi

# GET call
echo "  Get concept mappings for $terminology $code:"
curl -v -w "\n%{http_code}" -G "$url/project/$project/concept/$terminology/$code/mappings" -H "Authorization: Bearer $token" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort" 2> /dev/null > /tmp/x.$$
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
