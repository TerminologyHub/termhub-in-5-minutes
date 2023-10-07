Termhub in 5 Minutes: Postman Tutorial
======================================================

This tutorial shows how to use Postman access content from the TermHub Terminology API.

Prerequisites
-------------
* Postman must be installed (with a version capable of importing a v2.1 collection)
* The [TermHub-Postman-Client.json](TermHub-Postman-Client.json) file must be loaded into Postman using File->Import
* The base API_URL variable is et in the collection.  To change this, edit the collection, select the "Variables" tab, change the value, click "Update".
 - It is currently set to `https://api.terminologyhub.com`

Login
-----
After importing the collection, if you choose a request and click "Send" you should see this: 

```
{
    "local": false,
    "code": 401,
    "description": "Unauthorized",
    "message": "Unauthorized"
}
```

This message means you have to first log in and acquire an access token.  To do so, follow these steps:

1. Click on the collection itself "TermHub Postman Client"
2. Then click on the "Authorization" tab
3. Scroll down to the "Configure New Token" section and enter the following values
  - Grant Type = "Password Credentials"
  - Access Token URL = https://api.terminologyhub.com/auth/token
  - Username = <your email username>
  - Password = <your password>
4. Then scroll to the bottom and Click the the "Get New Access Token" button
5. If all goes well, you will get a dialog with a success message and when you click
   through you will get to a dialog called "MANAGE ACCESS TOKENS"
6. Here click the "Use Token" button and you will be ready to proceed.


Sample Postman Calls
-----------------
When the collection is loaded into Postman, you will see a number
of requests matching the scenarios defined in the top level README 
file of this project.  Simply choose any one and click the "Send" 
button to see the result.

