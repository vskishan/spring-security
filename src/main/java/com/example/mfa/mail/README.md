<h3>Email Based Multi-Factor Authentication</h3>
<br>
In this type of authentication apart from normal password verification, we also authenticate the code sent to user's email

The ideal flow from backend can be as follows:
* Authenticate the username and password
* Authenticate the email code sent to the user, generate a token
* User should be able to access the resources using this token

<i><b>Explanation of code:</b></i>

1. User details are stored in-memory. We can use DB to do the same.
2. The above defined ideal flow is tweaked and token generation step is skipped. Therefore, clients should send the code from email along with the requests to access the resources.

The above design decisions are made to make the implementation simple.

<i>Third party integrations :</i> Google SMTP server


