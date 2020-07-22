package com.freddiemac.datamanager.ws.esafe.util;

import java.io.StringWriter;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.enums.SecurityCodeFetchType;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;

public class GeneralUtils
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( GeneralUtils.class );
        
   /**
    * private constructor in order to hide the public constructor
    */
   private GeneralUtils() {         
   }
      
   /**
    * Validate whether a object is not null
    * 
    * @param object is a instance of Object class.
    * 
    * @return resultFlag is true in case of valid object otherwise false
    */
   public static boolean doesObjectExist( Object object ) {

      boolean resultFlag = Boolean.FALSE;
      
      if( Objects.nonNull ( object ) )
         resultFlag = Boolean.TRUE;
      
      return resultFlag;
      
   }
   
   /**
    * Validate whether a object is null
    * 
    * @param object is a instance of Object class.
    * 
    * @return resultFlag is true in case of null object otherwise false
    */
   public static boolean isNullObject( Object object ) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( Objects.isNull( object ) )
         resultFlag = Boolean.TRUE;
      
      return resultFlag;
      
   }
   
   /**
    * calculate the query fetch limit based on the number of submissions multiply 
    * by queryFetchLimit and also set the fetch limit to queryFetchCeilingLimit
    * in case the number of submissions multiply by queryFetchLimit 
    * 
    * @param totalSubmissions is a integer 
    * @param queryFetchLimit is a integer
    * @param queryFetchCeilingLimit is a integer
    * 
    * @return fetchLimit is a integer
    */
   public static int calculateQueryFetchLimit( int totalSubmissions, int queryFetchLimit, int queryFetchCeilingLimit )
   {
      int fetchLimit = totalSubmissions * queryFetchLimit;

      if( fetchLimit > queryFetchCeilingLimit ) {
         fetchLimit = queryFetchCeilingLimit;
      }     
      
      return fetchLimit;
      
   }
   
   /**
    * calculate the retry limit result based on retryFlag and  
    * also the retryCount is less than retryMaxLimit
    * 
    * @param retryFlag is a boolean
    * @param retryCount is a integer
    * @param retryMaxLimit is a integer
    * 
    * @return resultFlag is a boolean
    */
   public static boolean calculateRetryLimit ( boolean retryFlag, int retryCount, int retryMaxLimit ) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( retryFlag && ( retryCount < retryMaxLimit ) ) {
         resultFlag = Boolean.TRUE;
      }
      
      return resultFlag;
      
   }
   
   /**
    * Act as a manager to fetch the MacVault alias credentials based on the type of systems
    * 
    * @param component is a instance of String class
    * @param authUser is a instance of String class
    * @param secretsLocationPath is a instance of String class
    * @param macVaultAlias is a instance of String class
    * @param macVaultType is a instance of String class
    * 
    * @return securityCode based on the retrieving from the system otherwise null
    */
   public static String fetchAuthorizationCredentials( String component, String authUser, String secretsLocationPath, 
                                                       String macVaultAlias, SecurityCodeFetchType securityCodeFetchType ) {
      
      String securityCode = null;
      
      if ( securityCodeFetchType.equals( SecurityCodeFetchType.OPEN_SHIFT_SECRETS ) ) {
            securityCode = FileUtils.retrieveSecurityCodeFromSecretsLocation( component, authUser, secretsLocationPath );
      }
      else {
            LOGGER.info( "Successfully fetched security code using Default SecurityCodeFetchType for Component:'{}' " 
                         +  "- MacVaultAlias:'{}' - AuthUser:'{}' - SecurityCode:'********'",
                         component, macVaultAlias, authUser );
            securityCode = secretsLocationPath;
      }
      
      return securityCode;
      
   }
              
   /**
    * Marshal a object into XML string
    * 
    * @param modelType is a instance of generic type T class
    * @param clazz is a instance of Class<?> class
    * @param prettyFormatFlag is a boolean type
    * 
    * @return payloadString is a instance of String class
    * 
    * @throws JAXBException
    */
   public static <T> String convertObjectToXMLString( T modelType, Class<?> clazz, 
                                                      boolean prettyFormatFlag ) throws JAXBException
   {

      JAXBContext jaxbContext = JAXBContext.newInstance( clazz );
      StringWriter sw = new StringWriter();
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, prettyFormatFlag );
      marshaller.marshal( modelType, sw );

      return sw.toString();
      
   }
   
   /**
    * Deep copy utilities for model type using JSON format
    * 
    * @param modelType is a instance of generic type T class
    * 
    * @return generic type is a instance of T class
    */
   @SuppressWarnings( "unchecked" )
   public static <T> T deepCopyModelTypeUsingJSON( T modelType, boolean prettyFormatFlag ) {
      if( GeneralUtils.isNullObject( modelType ) ) {
         String errorMessage = "Unable to convert null object to JSON string";
         String errorCodeMessage = StringUtils.formatMessage( EsafeConstants.ERRORCODE_DESCRIPTION_LOG_MESSAGE,
                                                              EsafeErrorCodes.EC_SRS_NULL_OBJECT_EXCEPTION, errorMessage );
         LOGGER.error( errorCodeMessage );
         throw new EsafeRuntimeException( errorMessage, EsafeErrorCodes.EC_SRS_NULL_OBJECT_EXCEPTION  );
      }
      String payloadString = JSONUtils.convertObjectToJSONStringUsingGSON( modelType, prettyFormatFlag );
      return (T) JSONUtils.convertJSONStringToObjectUsingGSON( payloadString, modelType.getClass() );
   }
 
}
