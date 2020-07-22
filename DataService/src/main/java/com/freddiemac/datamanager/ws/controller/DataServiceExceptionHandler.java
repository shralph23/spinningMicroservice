package com.freddiemac.datamanager.ws.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeBadRequestException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeDAOException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeOpenShiftSecretsException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.model.FaultType;
import com.freddiemac.datamanager.ws.util.ExceptionUtils;

@RestControllerAdvice
public class DataServiceExceptionHandler
{

   private static final Logger LOGGER = LoggerFactory.getLogger( DataServiceExceptionHandler.class );

   /**
    * Handles only the custom EsafeException exception thrown from SLIDRetrievalService Order of Exceptions for SLIDRetrievalService 
    * 1)EsafeBadRequestException 2)EsafeDAOException 3)EsafeOpenShiftSecretsException  
    * 4)EsafeRuntimeException 5)Rest all Exceptions
    * 
    * @param request is a instance of HttpServletRequest class
    * @param esafeException is a instance of EsafeException class
    * @return responseEntity is a instance of ResponseEntity<FaultType> class
    */
   @ExceptionHandler( { EsafeException.class } )
   public ResponseEntity< FaultType > handleEsafeException( HttpServletRequest request, EsafeException esafeException )
   {

      HttpStatus httpstatus = null;
      ResponseEntity< FaultType > responseEntity = null;
      Throwable throwable = esafeException.getCause();

      if( throwable instanceof EsafeBadRequestException ) {
         httpstatus = HttpStatus.BAD_REQUEST;
      }
      else if( throwable instanceof EsafeDAOException ) {
         httpstatus = HttpStatus.BAD_REQUEST;
      }
      else if( throwable instanceof EsafeOpenShiftSecretsException ) {
         httpstatus = HttpStatus.NOT_FOUND;
      }      
      else if( throwable instanceof EsafeRuntimeException ) {
         httpstatus = HttpStatus.GATEWAY_TIMEOUT;
      }
      else {
         httpstatus = HttpStatus.BAD_GATEWAY;
      }

      responseEntity = ExceptionUtils.createFaultTypeResponseEntity( request.getRequestURI(), esafeException, httpstatus );
      String faultType = responseEntity.getBody().toCustomString();
      LOGGER.info( "DataService Response Entity:'{}'", faultType );

      return responseEntity;

   }

}
