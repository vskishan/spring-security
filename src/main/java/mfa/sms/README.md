<h3>SMS Based Multi-Factor Authentication</h3>
<br>
In this type of authentication apart from normal password verification, we also authenticate the code sent to user's mobile

The ideal flow from backend can be as follows:
* Authenticate the username and password
* Authenticate the SMS code sent to the user, generate a token
* User should be able to access the resources using this token

<i><b>Explanation of code:</b></i>

1. User details are stored in-memory. We can use DB to do the same.
2. The above defined ideal flow is tweaked and token generation step is skipped. Therefore, clients should send the SMS code along with the requests to access the resources.

The above design decisions are made to make the implementation simple.

<i>Third party libraries used :</i> Twilio for sending the SMS.


