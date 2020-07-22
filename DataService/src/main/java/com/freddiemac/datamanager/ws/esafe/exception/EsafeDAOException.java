package com.freddiemac.datamanager.ws.esafe.exception;

/**
 * This class is for EsafeDAOException. This captures all Database Exceptions This is Critical Error for SysEdge Monitoring
 */
public class EsafeDAOException extends EsafeRuntimeException
{

   private static final long serialVersionUID = 1L;

   public EsafeDAOException( final String message, final String errorCode )
   {
      super( message, errorCode );
   }

   public EsafeDAOException( final String message, final String errorCode, Exception e )
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

   public static String getExceptionLoggingMessage( final String errorCode, final String exceptionName, final String description )
   {
      return EsafeRuntimeException.getExceptionLoggingMessage( errorCode, exceptionName, description );
   }

}