#!/bin/bash
#
# Script to call TermHub to get all terminologies
#
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  --offset) offset="$2"; shift;;
  --limit) limit="$2"; shift;;
  --ascending) ascending="$2"; shift;;
  --sort) sort="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 0 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] [--limit <limit>] [--offset <offset>] [--ascending <true|false>] [--sort <sort>]"
  echo "  e.g. $0 --token \$token"
  echo "  e.g. $0 --token \$token --limit 100"
  echo "  e.g. $0 --token \$token --limit 5 --sort abbreviation"
  exit 1
fi
# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
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
echo "offset = $offset"
echo "limit = $limit"
echo "sort = $sort"
echo "ascending = $ascending"
echo ""

# GET call
echo "  Performing terminologies lookup"
curl -v -w "\n%{http_code}" -G "$url/terminology" -H "Authorization: Bearer $token" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/terminology failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/terminology returned $status, expected 200"
  exit 1
fi

# Output the result
perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
echo ""

# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
