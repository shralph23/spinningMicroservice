package com.freddiemac.datamanager.ws.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.freddiemac.datamanager.ws.config.EnvSpecificAppProperties;
import com.freddiemac.datamanager.ws.dto.ClientInfo;
import com.freddiemac.datamanager.ws.dto.ServiceParams;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.jsonvalidator.JsonRequestValidator;
import com.freddiemac.datamanager.ws.model.RequestType;
import com.freddiemac.datamanager.ws.model.ResponseType;
import com.freddiemac.datamanager.ws.service.DataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.SERVICE_CONTROLLER_NAME;
import static com.freddiemac.datamanager.ws.constant.ServiceConstants.SERVICE_CONTROLLER_OPERATION;
import static com.freddiemac.datamanager.ws.constant.ServiceConstants.POST_MAPPING_VALUE;

@RestController
@Api( value = SERVICE_CONTROLLER_NAME )
public class DataServiceController
{

   @Value( "${getRequestJsonSchema}" )
   private String requestJSONSchema;

   @Autowired
   EnvSpecificAppProperties envSpecificAppProperties;

   @Autowired
   DataService dataService;

   @Autowired
   private HttpServletRequest httpRequest;

   @ApiOperation( value = SERVICE_CONTROLLER_OPERATION, response = ResponseType.class )
   @PostMapping( path = POST_MAPPING_VALUE, consumes =
   {
         MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE }, produces =
   {
         MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE } )
   public ResponseType findRetrievalServiceResult(
         @ApiParam( hidden = true ) @RequestHeader Map< String, String > headers, @RequestBody RequestType request )
         throws EsafeException
   {

      ClientInfo clientInfo = new ClientInfo( headers, httpRequest );
      ServiceParams serviceParams = new ServiceParams( clientInfo, request );

      ResponseType response = null;

      JsonRequestValidator.validateJSONRequest( serviceParams, requestJSONSchema );
      
      response = dataService.getResponse( serviceParams );
      
      return response;
      
   }

}
