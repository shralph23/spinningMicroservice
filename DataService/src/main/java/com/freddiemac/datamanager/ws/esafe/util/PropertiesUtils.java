package com.freddiemac.datamanager.ws.esafe.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;

public class PropertiesUtils {
   
   private static final Logger LOGGER = LoggerFactory.getLogger( PropertiesUtils.class );
   
   private PropertiesUtils() {
   }
   
   public static boolean getBooleanProperty( boolean defaultPropertyValue, String propertyName, boolean propertyValue, boolean logPropertyFlag ) {

      boolean returnValue = defaultPropertyValue;
      boolean booleanPropertyValue = propertyValue;

      if( !booleanPropertyValue ) {
         if( logPropertyFlag ) {
            String defaultPropertyName = StringUtils.concatStrings( propertyName, EsafeConstants.PROPERTY_NAME_DEFAULT_PREFIX, EsafeConstants.CONCATENATED_PREFIX );
            LOGGER.info( EsafeConstants.PROPERTY_DEFAULT_LOG, defaultPropertyName, returnValue );
         }
      }
      else {
         returnValue = booleanPropertyValue;
         if( logPropertyFlag ) {
            LOGGER.info(  EsafeConstants.PROPERTY_FETCHED_LOG, propertyName, returnValue );
         }
      }

      return returnValue;
      
   }
   
   public static int getIntProperty( int defaultPropertyValue, String propertyName, int propertyValue, boolean logPropertyFlag ) {

      int returnValue = defaultPropertyValue;
      int intPropertyValue = propertyValue;

      if( intPropertyValue == 0 ) {
         if( logPropertyFlag ) {
            String defaultPropertyName = StringUtils.concatStrings( propertyName, EsafeConstants.PROPERTY_NAME_DEFAULT_PREFIX, EsafeConstants.CONCATENATED_PREFIX );
            LOGGER.info( EsafeConstants.PROPERTY_DEFAULT_LOG, defaultPropertyName, returnValue );
         }
      }
      else {
         returnValue = intPropertyValue;
         if( logPropertyFlag ) {
            LOGGER.info(  EsafeConstants.PROPERTY_FETCHED_LOG, propertyName, returnValue );
         }
      }

      return returnValue;
   }
   
   public static String getStringProperty( String defaultPropertyValue, String propertyName, String propertyValue, boolean logPropertyFlag ) {

      String returnValue = defaultPropertyValue;
      String stringPropertyValue = propertyValue;

      if( StringUtils.isValueEmpty( stringPropertyValue ) ) {
         if( logPropertyFlag ) {
            String defaultPropertyName = StringUtils.concatStrings( propertyName, EsafeConstants.PROPERTY_NAME_DEFAULT_PREFIX, EsafeConstants.CONCATENATED_PREFIX );
            LOGGER.info( EsafeConstants.PROPERTY_DEFAULT_LOG, defaultPropertyName, returnValue );
         }
      }
      else {
         stringPropertyValue = stringPropertyValue.trim();
         returnValue = stringPropertyValue;
         if( logPropertyFlag ) {
            LOGGER.info(  EsafeConstants.PROPERTY_FETCHED_LOG, propertyName, returnValue );
         }
      }

      return returnValue;
   }
   
   public static long getLongProperty( long defaultPropertyValue, String propertyName, long propertyValue, boolean logPropertyFlag ) {

      long returnValue = defaultPropertyValue;
      long longPropertyValue = propertyValue;

      if( longPropertyValue == 0 ) {
         if( logPropertyFlag ) {
            String defaultPropertyName = StringUtils.concatStrings( propertyName, EsafeConstants.PROPERTY_NAME_DEFAULT_PREFIX, EsafeConstants.CONCATENATED_PREFIX );
            LOGGER.info( EsafeConstants.PROPERTY_DEFAULT_LOG, defaultPropertyName, returnValue );
         }
      }
      else {
         returnValue = longPropertyValue;
         if( logPropertyFlag ) {
            LOGGER.info(  EsafeConstants.PROPERTY_FETCHED_LOG, propertyName, returnValue );
         }
      }

      return returnValue;
   }
   
}
