#!/bin/bash
#
# Script to call TermHub to perform queries to find members.
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --subset) subset="$2"; shift;;
  --token) token="$2"; shift;;
  --offset) offset="$2"; shift;;
  --limit) limit="$2"; shift;;
  --ascending) ascending="$2"; shift;;
  --sort) sort="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 2 ]; then
  echo "Usage: $0 <project> <query> [--token token] [--subset <abbreviation, uuid>]"
  echo "    [--limit <limit>] [--offset <offset>] [--ascending <true|false>] [--sort <sort>]"
  echo "  e.g. $0 sandbox diabetes --token \$token"
  echo "  e.g. $0 sandbox map --subset SNOMEDCT_US-MODEL --token \$token"
  exit 1
fi

project=${arr[0]}
query=${arr[1]}

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo "project = $project"
echo "subset = $subset"

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
echo "query = $query"
echo "offset = $offset"
echo "limit = $limit"
echo "sort = $sort"
echo "ascending = $ascending"
echo ""

# GET call
echo "  Find members: $query"
if [[ -z $subset ]]; then
  curl -v -w "\n%{http_code}" -G "$url/project/$project/member" -H "Authorization: Bearer $token" --data-urlencode "query=$query" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort"  2> /dev/null > /tmp/x.$$
else
  curl -v -w "\n%{http_code}" -G "$url/project/$project/subset/$subset/member" -H "Authorization: Bearer $token" --data-urlencode "query=$query" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort"  2> /dev/null > /tmp/x.$$
fi
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
