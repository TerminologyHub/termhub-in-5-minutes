#!/bin/bash
#
# Script to call TermHub to get all subsets.
#
query=
offset=0
limit=10
ascending=
sort=
while [[ "$#" -gt 0 ]]; do case $1 in
  --token) token="$2"; shift;;
  --offset) offset="$2"; shift;;
  --limit) limit="$2"; shift;;
  --ascending) ascending="$2"; shift;;
  --sort) sort="$2"; shift;;
  --id) id="$2"; shift;;
  --query) query="$2"; shift;;
  --project) project="$2"; shift;;
  *) arr=( "${arr[@]}" "$1" );;
esac; shift; done

if [ ${#arr[@]} -ne 0 ] || [ -z $token ]; then
  echo "Usage: $0 [--token token] [--limit <limit>] [--offset <offset>] [--ascending <true|false>] [--sort <sort>]"
  echo "Usage: $0 [--query <query>] [--id <id>] [--offset <offset>] [--project <project>]"
  echo "  e.g. $0 --token \$token"
  echo "  e.g. $0 --token \$token --limit 100"
  echo "  e.g. $0 --token \$token --limit 5 --sort abbreviation"
  echo "  e.g. $0 --token \$token --query SNOMEDCT_US-MODEL"
  echo "  e.g. $0 --token \$token --id 2a545e12-04eb-48ee-b988-c17346b4e05f"
  echo "  e.g. $0 --token \$token --project sandbox"
  exit 1
fi
# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
if [ -z $project ]; then
echo "query = $query"
echo "offset = $offset"
echo "limit = $limit"
echo "sort = $sort"
echo "ascending = $ascending"
fi
if [ ! -z $id ]; then
  echo "id = $id"
fi
if [ ! -z $project ]; then
  echo "project = $project"
fi
echo ""

# GET call
echo "  Performing subsets lookup"
if [ ! -z $id ]; then
  target_url="$url/subset/$id"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
elif [ ! -z $project ]; then
  target_url="$url/project/$project/subset"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
else
  curl -v -w "\n%{http_code}" -G "$url/subset" -H "Authorization: Bearer $token" --data-urlencode "query=$query" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort" 2> /dev/null > /tmp/x.$$
fi
if [ $? -ne 0 ]; then
  echo "ERROR: GET $url/subset failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  perl -pe 's/200$//' /tmp/x.$$ | jq '.' | sed 's/^/    /'
  echo "ERROR: GET $url/subset returned $status, expected 200"
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
