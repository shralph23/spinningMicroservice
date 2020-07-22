package com.freddiemac.datamanager.ws.util;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.freddiemac.datamanager.ws.config.ApplicationLogger;
import com.freddiemac.datamanager.ws.constant.ServiceConstants;
import com.freddiemac.datamanager.ws.dto.ServiceParams;
import com.freddiemac.datamanager.ws.enums.LogLevel;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;
import com.freddiemac.datamanager.ws.esafe.util.StringUtils;
import com.freddiemac.datamanager.ws.model.FaultType;

public class ExceptionUtils
{

   private static final Logger LOGGER = ApplicationLogger.getLogger( ExceptionUtils.class );

   private ExceptionUtils()
   {
   }

   /**
    * Handles all the exception which extends custom EsafeRuntimeException class and also perform the below mentioned 
    * activities based on the exception creates errorCodeMessage with data for splunk logging creates formattedErrorCodeMessage
    * with data for SLIDRetrievalService logging Splunk logging is skipped for custom EsafeBadRequestException exception 
    * throws custom EsafeException with data in order to send custom error response to the clients
    * 
    * @param logLevel is a value of LogLevel enum
    * @param exception is a instance of <T extends EsafeRuntimeException> class
    * @param serviceParams is a instance of ServiceParams class
    */
   public static < T extends EsafeRuntimeException > void serviceExceptionHandler( LogLevel logLevel, T esafeRuntimeException, ServiceParams serviceParams )
   {

      String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( esafeRuntimeException.getErrorCode(),
            esafeRuntimeException.getClass().getName(),
            esafeRuntimeException.getMessage() );
      serviceParams.setMessage( errorCodeMessage );
      String formattedErrorCodeMessage = StringUtils.formatMessage( ServiceConstants.MESSAGE_REQUEST_EXCEPTION_PREFIX, errorCodeMessage );
      
      switch( logLevel ) {
         case WARN:
            // log request that warning failed
            break;
         case ERROR:
            LOGGER.error( formattedErrorCodeMessage, esafeRuntimeException );
            // log request that error failed
            break;
         default:
            break;
            
      }

   }

   public static void serviceExceptionHandler( Exception exception, ServiceParams serviceParams )
   {

      String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( EsafeErrorCodes.EC_SRS_SYSTEM_FAILED, exception );
      serviceParams.setMessage( errorCodeMessage );
      String formattedErrorCodeMessage = String.format( ServiceConstants.MESSAGE_REQUEST_EXCEPTION_PREFIX, errorCodeMessage );
      LOGGER.error( formattedErrorCodeMessage, exception );

      // log request that failed

   }

   /**
    * Created a response entity for client due to exceptions in the service
    * 
    * @param uriRequested is a instance of String class
    * @param esafeException is a instance of EsafeException class
    * @param httpStatus is a instance of HttpStatus class
    * @return object is a instance of ResponseEntity<FaultType> class
    */
   public static ResponseEntity< FaultType > createFaultTypeResponseEntity( final String uriRequested,
         final EsafeException esafeException,
         final HttpStatus httpStatus )
   {

      String errorCode = esafeException.getErrorCode();
      String errorMessage = EsafeRuntimeException.getExceptionLoggingMessage( esafeException.getCause().getClass().getName(),
            esafeException.getMessage() );
      FaultType fault = new FaultType( errorCode, errorMessage, uriRequested );
      return new ResponseEntity<>( fault, httpStatus );

   }

}
