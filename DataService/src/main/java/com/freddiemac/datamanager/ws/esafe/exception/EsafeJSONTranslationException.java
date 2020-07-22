package com.freddiemac.datamanager.ws.esafe.exception;

/**
 * This class is for EsafeJSONTranslationException. This captures all JSON translation Exceptions. 
 * This is Critical Error for SysEdge Monitoring
 */
public class EsafeJSONTranslationException extends EsafeRuntimeException
{
   private static final long serialVersionUID = 1L;
   
   public EsafeJSONTranslationException( final String message, final String errorCode )
   {
      super( message, errorCode );  
   }
   
   public EsafeJSONTranslationException( final String message, final String errorCode, Exception e )
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