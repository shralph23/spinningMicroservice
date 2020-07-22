package com.freddiemac.datamanager.ws.esafe.exception;

/**
 * This class is for EsafeOpenShiftSecretsRuntimeException Exception.
 * This captures all OpenShift secrets Exceptions used to retrieve secret code from the location
 * This is Critical Error for SysEdge Monitoring
 */
public class EsafeOpenShiftSecretsException extends EsafeRuntimeException
{   
   private static final long serialVersionUID = 1L;
   
   public EsafeOpenShiftSecretsException( final String message, final String errorCode )
   {
      super( message, errorCode );  
   }
   
   public EsafeOpenShiftSecretsException( final String message, final String errorCode, Exception e )
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