package com.freddiemac.datamanager.ws.config;

import java.net.ConnectException;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.ldap.CommunicationException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import com.freddiemac.datamanager.ws.constant.ServiceConstants;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeLDAPAuthenticationException;
import com.freddiemac.datamanager.ws.esafe.util.GeneralUtils;
import com.freddiemac.datamanager.ws.esafe.util.StringUtils;

public class CacheAbleAuthenticationProviderWrapper implements AuthenticationProvider
{
   
   private static final Logger LOGGER = ApplicationLogger.getLogger( CacheAbleAuthenticationProviderWrapper.class );
   
   private ActiveDirectoryLdapAuthenticationProvider provider;
   private Map< String, AuthenticationLifeTime > mapCache;
   private int cacheEvictionSeconds;

   public CacheAbleAuthenticationProviderWrapper( ActiveDirectoryLdapAuthenticationProvider provider, int cacheEvictionSeconds )
   {
      this.provider = provider;
      this.mapCache = new HashMap<>();
      this.cacheEvictionSeconds = cacheEvictionSeconds;
   }

   @Override
   @Retryable( value =
   { CommunicationException.class, ConnectException.class, SocketException.class,
         javax.naming.CommunicationException.class }, maxAttemptsExpression = "${AD_MAX_RETRY_ATTEMPTS}", backoff = @Backoff( delayExpression = "${AD_RETRY_DELAY_MS}" ) )
   public Authentication authenticate( Authentication authentication ) throws AuthenticationException
   {

      if( requiresRealExecution( authentication ) ) {
         LOGGER.info( ServiceConstants.MESSAGE_LDAP_AD_AUTH_SERVER );
         Authentication auth = provider.authenticate( authentication );
         mapCache.put( createToken( authentication ), new AuthenticationLifeTime( calculateExpiration(), auth ) );
      }
      else {
         LOGGER.info( ServiceConstants.MESSAGE_LDAP_AD_AUTH_CACHE );
      }

      return mapCache.get( createToken( authentication ) ).getAuthentication();
   }

   @Override
   public boolean supports( Class< ? > aClass )
   {
      return provider.supports( aClass );
   }

   private boolean requiresRealExecution( Authentication auth )
   {
      AuthenticationLifeTime authLifeTime = mapCache.get( createToken( auth ) );
      if( GeneralUtils.isNullObject( authLifeTime ) ) {
         return Boolean.TRUE;
      }

      long now = new Date().getTime();
      return authLifeTime.getExpirationTime() < now || !authLifeTime.getAuthentication().isAuthenticated();
   }

   private String createToken( Authentication auth )
   {
      return StringUtils.formatMessage( "%s:%s", auth.getPrincipal().toString(), auth.getCredentials().toString() );
   }

   private Long calculateExpiration()
   {

      long now = new Date().getTime();
      return now + cacheEvictionSeconds * 1000;
   }

   class AuthenticationLifeTime
   {

      private long expirationTime;
      private Authentication authentication;

      AuthenticationLifeTime( Long expirationTime, Authentication authentication )
      {
         this.expirationTime = expirationTime;
         this.authentication = authentication;
      }

      Long getExpirationTime()
      {
         return this.expirationTime;
      }

      Authentication getAuthentication()
      {
         return this.authentication;
      }
   }

   @Recover
   public Authentication recoverForAuthenticateFinalRetry( Exception exception )
   {
      
      String errorMessage = ServiceConstants.MSG_AD_SRV_AUTHENTICATION_EXCEPTION;
      
      if( exception instanceof CommunicationException )
         errorMessage = ServiceConstants.MSG_AD_SRV_SPRING_COMMEXCEPTION;

      if( exception instanceof SocketException )
         errorMessage = ServiceConstants.MSG_AD_SRV_SOCKET_EXCEPTION;

      if( exception instanceof ConnectException )
         errorMessage = ServiceConstants.MSG_AD_SRV_CONNECTION_EXCEPTION;

      if( exception instanceof javax.naming.CommunicationException )
         errorMessage = ServiceConstants.MSG_AD_SRV_JAVAX_COMMEXCEPTION;
                                                                                                       
      LOGGER.error( errorMessage );
      
      throw new EsafeLDAPAuthenticationException( errorMessage, EsafeErrorCodes.EC_SRS_LDAP_AUTHENTICATION_EXCEPTION );
      
   }

}
