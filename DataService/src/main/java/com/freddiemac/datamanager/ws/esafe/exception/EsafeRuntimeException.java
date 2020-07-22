package com.freddiemac.datamanager.ws.esafe.exception;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
import com.freddiemac.datamanager.ws.esafe.util.StringUtils;

/**
 * This class is base class for EsafeRuntimeException Exceptions.
 *
 * @author f352017
 */
public class EsafeRuntimeException extends RuntimeException
{

   private static final long serialVersionUID = -6378634533157954558L;

   private final String errorCode;

   public EsafeRuntimeException( final String message, final String errorCode )
   {
      super( message );
      this.errorCode = errorCode;
   }

   public EsafeRuntimeException( final String message, final String errorCode, Exception e )
   {
      super( message, e );
      this.errorCode = errorCode;
   }

   /**
    * @return the errorCode
    */
   public String getErrorCode()
   {
      return errorCode;
   }

   public String getLoggingMessage( final String description )
   {
      return EsafeRuntimeException.getExceptionLoggingMessage( getErrorCode(), getClass().getName(), description );
   }

   public static String getExceptionLoggingMessage( final String exceptionName, final String description )
   {
      return StringUtils.formatMessage( EsafeConstants.EXCEPTION_DESCRIPTION_LOG_MESSAGE, exceptionName, description );
   }

   public static String getExceptionLoggingMessage( final String errorCode, final Exception exception )
   {
      return StringUtils.formatMessage( EsafeConstants.ERRORCODE_EXCEPTION_NAME_LOG_MESSAGE, errorCode, exception.getClass().getName() );
   }

   public static String getExceptionLoggingMessage( final String errorCode, final String exceptionName, final String description )
   {
      return StringUtils.formatMessage( EsafeConstants.ERRORCODE_EXCEPTION_DESCRIPTION_LOG_MESSAGE, errorCode, exceptionName, description );
   }

   public static String getExceptionLoggingMessage( final String prefix, final String errorCode, final String exceptionName, final String description )
   {
      return StringUtils.formatMessage( EsafeConstants.PREFIX_ERRORCODE_EXCEPTION_DESCRIPTION_LOG_MESSAGE, prefix, errorCode, exceptionName, description );
   }

}