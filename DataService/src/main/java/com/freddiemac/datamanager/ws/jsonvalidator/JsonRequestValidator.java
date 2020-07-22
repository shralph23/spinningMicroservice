package com.freddiemac.datamanager.ws.jsonvalidator;

import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import com.freddiemac.datamanager.ws.dto.ServiceParams;
import com.freddiemac.datamanager.ws.enums.LogLevel;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeBadRequestException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;
import com.freddiemac.datamanager.ws.esafe.util.JSONUtils;
import com.freddiemac.datamanager.ws.esafe.util.LogUtils;
import com.freddiemac.datamanager.ws.esafe.util.StringUtils;
import com.freddiemac.datamanager.ws.model.RequestType;
import com.freddiemac.datamanager.ws.util.ExceptionUtils;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.*;

public class JsonRequestValidator
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( JsonRequestValidator.class );

   private JsonRequestValidator()
   {
   }

   public static boolean validateJSONRequest( ServiceParams serviceParams, String requestJSONSchema ) throws EsafeException
   {

      boolean validateJSONRequestFlag = Boolean.FALSE;
      RequestType request = serviceParams.getRequest();

      try {
         String jSSON = JsonRequestValidator.requestsToJSON( request );
         JsonRequestValidator.validateJSONString( jSSON, requestJSONSchema );
         validateJSONRequestFlag = JsonRequestValidator.isRecordCountValid( request.getRequestMetadata().getRequestRecordCount(), request.getSubmissions().size() );
      }
      catch( EsafeRuntimeException esafeRuntimeException ) {
         ExceptionUtils.serviceExceptionHandler( LogLevel.WARN, esafeRuntimeException, serviceParams );
         throw new EsafeException( esafeRuntimeException.getMessage(), esafeRuntimeException.getErrorCode(), esafeRuntimeException );
      }
      
      return validateJSONRequestFlag;
      
   }

   private static String requestsToJSON( RequestType request )
   {
      
      String requestStr = EMPTY_STRING;
      
      try {
         requestStr = JSONUtils.convertObjectToJSONStringUsingJackson( request, Boolean.TRUE );
         if( StringUtils.isNull( requestStr ) ) {
            throw new EsafeRuntimeException(EsafeErrorCodes.EC_SRS_JSON_TRANSLATION_FAILED, MESSAGE_ERROR_JSON_SERILIZATION_REQUEST);
         }
      }
      catch( Exception jsonProcessingException ) {
         LogUtils.logServiceMessage( LogLevel.WARN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_EXCEPTION_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_JSON_TRANSLATION_FAILED, MESSAGE_ERROR_JSON_SERILIZATION_REQUEST, jsonProcessingException.getMessage() );
         throw new EsafeBadRequestException( MESSAGE_ERROR_JSON_SERILIZATION_REQUEST, EsafeErrorCodes.EC_SRS_JSON_TRANSLATION_FAILED,
               jsonProcessingException );

      }
      
      return requestStr;
      
   }

   private static boolean isRecordCountValid( int requestRecordCount, int submissionsCount )
   {
      
      boolean recordCountValidFlag = Boolean.TRUE;
      
      if( requestRecordCount != submissionsCount ) {
         String errorMessage = StringUtils.formatMessage( "Request metadata record count does not match the Submissions received in the request - RequestRecordCount:'%s' - SubmissionsCount:'%s'",
               requestRecordCount, submissionsCount );
         LogUtils.logServiceMessage( LogLevel.WARN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX, EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );
         throw new EsafeBadRequestException( errorMessage, EsafeErrorCodes.EC_SRS_BAD_REQUEST );
      }
      
      return recordCountValidFlag;
      
   }

   public static boolean validateJSONString( String jsonData, String jsonSchema )
   {

      ProcessingReport report = null;
      boolean validateJSONRequestFlag = Boolean.FALSE;
      String exceptionMessage = null;

      try {
         JsonNode schemaNode = JsonLoader.fromString( jsonSchema );
         JsonNode data = JsonLoader.fromString( jsonData );
         JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
         JsonValidator validator = factory.getValidator();
         report = validator.validate( schemaNode, data );

         Iterator< ProcessingMessage > iter = report.iterator();
         while( iter.hasNext() ) {
            ProcessingMessage pm = iter.next();
            LOGGER.debug( MESSAGE_JSON_PROCESSING, pm.getMessage() );
         }
         validateJSONRequestFlag = report.isSuccess();
         LOGGER.info( MESSAGE_JSON_VALID, validateJSONRequestFlag );
         if( !validateJSONRequestFlag ) {
            LogUtils.logServiceMessage( LogLevel.WARN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX, EsafeErrorCodes.EC_SRS_BAD_REQUEST,
                  MESSAGE_ERROR_VALIDATING_REQUEST );
            exceptionMessage = MESSAGE_ERROR_VALIDATING_REQUEST + report.toString();
            throw new EsafeBadRequestException( exceptionMessage, EsafeErrorCodes.EC_SRS_BAD_REQUEST );
         }
      }
      catch( EsafeBadRequestException esafeBadRequestException ) {
         throw esafeBadRequestException;
      }
      catch( Exception exception ) {
         LogUtils.logServiceMessage( LogLevel.WARN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_EXCEPTION_PREFIX_PLUS_POSFIX, EsafeErrorCodes.EC_SRS_BAD_REQUEST,
               MESSAGE_ERROR_PARSING_REQUEST, exception.getMessage() );
         throw new EsafeBadRequestException( MESSAGE_ERROR_PARSING_REQUEST, EsafeErrorCodes.EC_SRS_BAD_REQUEST, exception );
      }
      
      return validateJSONRequestFlag;
      
   }

}
