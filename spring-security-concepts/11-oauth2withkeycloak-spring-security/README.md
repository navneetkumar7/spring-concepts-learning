Authorization server:
   ****
    - Keycloak (opensource)
    - Okta
    - ForgeRock
    - Amazon cognito
   ****
Links to check all the urls of Key Cloak server:
- http://localhost:8180/realms/springseclearningdev/.well-known/openid-configuration 
- Resource server during startup will download the public certificate by connecting to authorization server. Authorization server has private certificate or private key with which it will sign the access token. Resource server
with public certificate will validate if access token is tampered.This way resource server dont need to connect to Authorization server when it wants to validate the access token.
- **spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8180/realms/springseclearningdev/protocol/openid-connect/certs**