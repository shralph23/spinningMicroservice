package com.freddiemac.datamanager.ws.esafe.util;

import java.lang.reflect.Method;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;

import static com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes.EC_SRS_HOSTNAME_EXCEPTION;
import static com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes.EC_SRS_USERNAME_EXCEPTION;

public final class OSUtils
{

   private static final Logger LOGGER = LoggerFactory.getLogger( OSUtils.class );

   // static instance
   private static OSUtils instance = null;

   // member variables
   private String appUserName = EsafeConstants.EMPTY_STRING;
   private String appHostName = EsafeConstants.EMPTY_STRING;
   private String userPropertyName = EsafeConstants.PROPERTY_USER_NAME;

   Class< ? > clazz = null;
   Object object = null;
   Method method = null;

   private OSUtils()
   {
      // load OS utils one time in constructor
      appUserName = getUserName();
      appHostName = getHostName();

      // log all OS variables 
      LOGGER.info( "UserName:'{}'", appUserName );
      LOGGER.info( "HostName:'{}'", appHostName );
   }

   /**
    * @singlton pattern
    * @return
    */
   public static synchronized OSUtils getInstance()
   {

      if( GeneralUtils.isNullObject( instance ) ) {
         instance = new OSUtils();
      }

      return instance;

   }

   public synchronized String getHostName()
   {

      // used cached value if exists
      // would never change unless server restarted!
      try {
         if( appHostName.isEmpty() ) {
            InetAddress ip = InetAddress.getLocalHost();
            appHostName = ip.getHostName();
         }
      }
      catch( Exception exception ) {

         appHostName = EsafeConstants.PROPERTY_VALUE_UNKNOWN;

         // eat exception and continue
         String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( EC_SRS_HOSTNAME_EXCEPTION,
               exception.getClass().getName(),
               "Issue getting HostName for logging!" );
         LOGGER.warn( errorCodeMessage, exception );
      }

      return appHostName;

   }

   public synchronized String getUserName()
   {

      // used cached value if exists
      // would never change unless server restarted!
      try {
         if( appUserName.isEmpty() ) {
            appUserName = StringUtils.doTrimPlusUpperCase( System.getProperty( userPropertyName ) );
            appUserName = StringUtils.isNotNull( appUserName ) ? appUserName : EsafeConstants.PROPERTY_VALUE_UNKNOWN;
         }
      }
      catch( Exception exception ) {

         appUserName = EsafeConstants.PROPERTY_VALUE_UNKNOWN;

         // eat exception and continue
         String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( EC_SRS_USERNAME_EXCEPTION,
               exception.getClass().getName(), "Issue getting UserName for logging!" );
         LOGGER.warn( errorCodeMessage, exception );
      }

      return appUserName;

   }

}
