oauth2 terminology:
****
1. Resource owner: it is you the end user.
2. client: 3rd party application who wants to access the resources after taking permission from resource owner.
3. authorization server: server holds resource owner account.
4. Resource server: The server having api/services that client wants to consume are hosted.
5. Scopes: granular permission the client wants.The auth server can issue an access token to client with the required scope.
****
grant types:
****
1. Authorization code grant flow:
   - this grant flow will be used when end user is involved and two different application trying to communicate
   - grant_type: authorization_code
2. Implicit Grant flow: deprecated
    - access token is granted directly once the end user allows access.
    - deprecated in oauth 2.1.
    - it is least secured, as we  send the client Id without client secret so one can mimic as client.
    - the access token will be shared in the redirected get url, which is not secure.
3. Password Grant/Resource owner credentials grant type: deprecated
   - end user will give own credentials to client.
   - Not recommended for production env
   - deprecated in oauth 2.0, will be removed from oauth 2.1
   - grant_type: password
4. Client credentials grant type:
   - there is no end user involved, here two backend applications/2 microservices trying to communicate with each other.
   - client would be application belong to different org, and resource server would have application running to whom the client(application) would like to interact.
   - grant_type: client_credentials
5. Refresh token grant type:
   - grant_type: refresh_token
6. Device code:
    - used in TV application login
7. PKCE:
    - proof key for code exchange
    - public clients cannot securely store a Client Secret.
****
Resource server token validation:
    Approaches:    
        1.  call to auth server to validate
        2.  share the common db which holds the token
        3.  no communication b/w resource server and auth server. The token shared to client will be signed by Auth server and signature of it will be verified by Resource server similar to jwt token. Only at once resource server will connect to auth server to get public certificate.

*OpenID Connect: OIDC*
  ****
    - OpenID Connect is a protocol that sits on top of the OAuth2.0 framework.
    - Two types of token ID token and access token
    - scope: openid sent to authorization server
  ****

Links:
***
1. oauth.com/playground
***