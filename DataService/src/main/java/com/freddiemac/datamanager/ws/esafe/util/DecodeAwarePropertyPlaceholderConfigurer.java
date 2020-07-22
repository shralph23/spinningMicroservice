package com.freddiemac.datamanager.ws.esafe.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
/**
 * Utility used to decode security code stored in jdbc.properties for Spring
 * 
 * Only used for unit tests
 * security code is defined as jdbc.securityCode=
 * where encoded value is from TestBase64Utils with prefix of "DECODE-"
 * Note : SAST scan risk variable name was changed to the securityCode  
 * 
 * @author f352017
 *
 */
public class DecodeAwarePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{

   @Override
   protected String convertPropertyValue( String originalValue )
   {
      if( originalValue.startsWith( EsafeConstants.DECODED_FIELD_PREFIX ) ) {
         String encodedString = extractEncodedString( originalValue, EsafeConstants.DECODED_FIELD_PREFIX );
         return decode( encodedString );
      }
      return originalValue;
   }

   private String decode( String value )
   {
      return Base64Utils.decode( value );
   }

   private String extractEncodedString( String encodedPropertyValue, String prefix )
   {
      return encodedPropertyValue.substring( prefix.length() );
   }

}
