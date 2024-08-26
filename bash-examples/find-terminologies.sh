#!/bin/bash
#
# Script to call TermHub to get all terminologies
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
  echo "  e.g. $0 --token \$token --query SNOMEDCT_US"
  echo "  e.g. $0 --token \$token --id 1e523c73-dfe8-4299-92ee-b7a8ece57769"
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
echo "query = $query"
echo "offset = $offset"
echo "limit = $limit"
echo "sort = $sort"
echo "ascending = $ascending"
echo "id = $id"
echo "project = $project"
echo ""

# GET call
echo "  Performing terminologies lookup"
if [ ! -z $id ]; then
  target_url="$url/terminology/$id"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
elif [ ! -z $project ]; then
  target_url="$url/project/$project/terminology"
  curl -v -w "\n%{http_code}" -G "$target_url" -H "Authorization: Bearer $token" 2> /dev/null > /tmp/x.$$
else
  curl -v -w "\n%{http_code}" -G "$url/terminology" -H "Authorization: Bearer $token" --data-urlencode "query=$query" --data-urlencode "limit=$limit" --data-urlencode "offset=$offset" --data-urlencode "ascending=$ascending" --data-urlencode "sort=$sort" 2> /dev/null > /tmp/x.$$
fi
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
