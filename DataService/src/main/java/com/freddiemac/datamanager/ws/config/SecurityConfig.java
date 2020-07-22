package com.freddiemac.datamanager.ws.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import com.freddiemac.datamanager.ws.constant.ServiceConstants;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

   private static final Logger LOGGER = LoggerFactory.getLogger( SecurityConfig.class );

   @Autowired
   EnvSpecificAppProperties envSpecificAppProperties;
   
   @Override
   protected void configure( AuthenticationManagerBuilder authManagerBuilder ) throws Exception
   {
      authManagerBuilder.authenticationProvider( activeDirectoryLdapAuthenticationProvider() ).userDetailsService( userDetailsService() );
   }

   @Override
   protected void configure( HttpSecurity http ) throws Exception
   {
      LOGGER.info( ServiceConstants.MESSAGE_CONFIGURE_AD_GROUP, envSpecificAppProperties.getAdGroup( Boolean.FALSE ) );
      http
         .csrf().disable()
         .authorizeRequests()
            .requestMatchers( EndpointRequest.toAnyEndpoint() ).permitAll()
            .anyRequest().hasAnyAuthority( envSpecificAppProperties.getAdGroup( Boolean.FALSE ) ).and().httpBasic();
   }
   
   @Bean
   @Override
   public AuthenticationManager authenticationManager() {
      
      return new ProviderManager( Arrays.asList( activeDirectoryLdapAuthenticationProvider() ) );
      
   }

   @Bean
   public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {

      LOGGER.debug( ServiceConstants.MESSAGE_CONFIGURE_AD_LDAP, envSpecificAppProperties.getAdDomain(Boolean.FALSE), envSpecificAppProperties.getAdUrl( Boolean.FALSE ) );
      ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider( envSpecificAppProperties.getAdDomain(Boolean.FALSE), 
                                                                                                          envSpecificAppProperties.getAdUrl( Boolean.FALSE ) );
      provider.setConvertSubErrorCodesToExceptions( Boolean.TRUE );
      provider.setUseAuthenticationRequestCredentials( Boolean.TRUE );
      return new CacheAbleAuthenticationProviderWrapper( provider, envSpecificAppProperties.getAdExpirationSeconds( Boolean.FALSE) );
      
   }

}