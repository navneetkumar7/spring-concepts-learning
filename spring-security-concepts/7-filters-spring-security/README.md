**Security filter chain**: 
****[
DisableEncodeUrlFilter
ForceEagerSessionCreationFilter
ForceEagerSessionCreationFilter
WebAsyncManagerIntegrationFilter
SecurityContextPersistenceFilter
HeaderWriterFilter
CorsFilter
CsrfFilter
LogoutFilter
UsernamePasswordAuthenticationFilter
DefaultLoginPageGeneratingFilter
DefaultLogoutPageGeneratingFilter
BasicAuthenticationFilter
CsrfCookieFilter
RequestCacheAwareFilter
SecurityContextHolderAwareRequestFilter
AnonymousAuthenticationFilter
SessionManagementFilter
ExceptionTranslationFilter
AuthorizationFilter
]****

filter creation options:
****
1. extend Filter (jakarta.servlet.Filter)interface.
2. extend GenericFilterBean.
   - Abstract class, more details needed with respect to Security config, has lot of handy methods 
3. extend OncePerRequestFilter
   - if filter needs to executed only once.
   - example BasicAuthenticationFilter 