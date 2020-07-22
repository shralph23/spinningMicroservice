package com.freddiemac.datamanager.ws.esafe.exception;

/**
 * This class is for EsafeBadRequestException. This captures all invalid service request Exceptions.
 * This is Minor Warning for SysEdge Monitoring
 */
public class EsafeBadRequestException extends EsafeRuntimeException {

   private static final long serialVersionUID = 1L;

   public EsafeBadRequestException( final String message, final String errorCode )
   {
      super( message, errorCode );  
   }
   
   public EsafeBadRequestException( final String message, final String errorCode, Exception e )
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
