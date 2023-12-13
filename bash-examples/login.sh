#!/bin/bash
#
# Script to login to TermHub.
#

if [ $# -ne 2 ]; then
  echo "Usage: $0 <username> <password>"
  exit 1
fi

username=$1
password=$2

# import URL into environment from config
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
. $DIR/url.env

echo "-----------------------------------------------------"
echo "Starting ...$(/bin/date)"
echo "-----------------------------------------------------"
echo "url = $url"
echo "username = $username"
echo "password = ************"
echo ""

# Login
cat > /tmp/data.$$ << EOF
{ "grant_type": "username_password", "username": "$username", "password": "$password"}
EOF

curl -v -w "\n%{http_code}" -X POST "$url/auth/token" -d "@/tmp/data.$$" -H "Content-type: application/json" 2> /dev/null > /tmp/x.$$
if [ $? -ne 0 ]; then
  echo "ERROR: POST /auth/token failed"
  exit 1
fi

# check status
status=`tail -1 /tmp/x.$$`
if [ $status -ne 200 ]; then
  cat /tmp/x.$$ | sed 's/^/    /'
  echo "ERROR:  POST /auth/token returned $status, expected 200"
  exit 1
fi

# write output
jwt=`head -1 /tmp/x.$$ | jq '.access_token' | sed 's/"//g'`
echo "  token=$jwt"
echo ""


# ---------------------------------------------------------
# Cleanup
#
/bin/rm -f /tmp/data.$$
/bin/rm -f /tmp/x.$$

echo "-----------------------------------------------------"
echo "Finished ...`/bin/date`"
echo "-----------------------------------------------------"
