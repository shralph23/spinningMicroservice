package com.freddiemac.datamanager.ws.esafe.exception;

/**
 * This class is for EsafeLDAPAuthenticationException Exception.
 * This captures all LDAP Authentication Exceptions used to retrieve secret code from the AD server
 * This is Critical Error for SysEdge Monitoring
 */
public class EsafeLDAPAuthenticationException extends EsafeRuntimeException
{   
   private static final long serialVersionUID = 1L;
   
   public EsafeLDAPAuthenticationException( final String message, final String errorCode )
   {
      super( message, errorCode );  
   }
   
   public EsafeLDAPAuthenticationException( final String message, final String errorCode, Exception e )
   {
      super( message, errorCode, e );  
   }
   
   public static String getExceptionLoggingMessage( final String exceptionName, final String description )
   {
      return EsafeRuntimeException.getExceptionLoggingMessage( exceptionName, description );
   }
   
   public static String getExceptionLoggingMessage( final String errorCode, final Exception exception )
   {
      return EsafeRuntimeException.getExceptionLoggingMessage( errorCode, exception );
   }
   
}