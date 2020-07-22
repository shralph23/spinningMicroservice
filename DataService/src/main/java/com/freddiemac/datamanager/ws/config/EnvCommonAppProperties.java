package com.freddiemac.datamanager.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.freddiemac.datamanager.ws.esafe.util.PropertiesUtils;

@Component
@ConfigurationProperties
public class EnvCommonAppProperties
{

   private static final String DEFAULT_SWAGGER_SERVICE_BASE_PACKAGE = "com.freddiemac.datamanager.ws.controller";
   private static final String DEFAULT_SWAGGER_SERVICE_NAME = "SLID Retrieval Service REST API";
   private static final String DEFAULT_SWAGGER_SERVICE_DESCRIPTION = "SLID Retrieval Service REST API is to find a slid based on input parameters otherwise return null";
   private static final String DEFAULT_SWAGGER_SERVICE_VERSION = "V1.0";
   private static final String DEFAULT_SWAGGER_SERVICE_TERMS = "Terms of service";
   private static final String DEFAULT_SWAGGER_SERVICE_CONTACT_NAME = "eSafe Titans";
   private static final String DEFAULT_SWAGGER_SERVICE_CONTACT_URL = "https://www.freddiemac.com/";
   private static final String DEFAULT_SWAGGER_SERVICE_CONTACT_MAIL = "eSafe_Titans@freddiemac.com";
   private static final String DEFAULT_SWAGGER_SERVICE_LICENSE_INFO = "License of SLID Retrieval Service REST API";
   private static final String DEFAULT_SWAGGER_SERVICE_LICENSE_URL = "https://www.freddiemac.com/";
   
   private static final String SWAGGER_SERVICE_BASE_PACKAGE = "SWAGGER_SERVICE_BASE_PACKAGE";
   private static final String SWAGGER_SERVICE_NAME = "SWAGGER_SERVICE_NAME";
   private static final String SWAGGER_SERVICE_DESCRIPTION = "SWAGGER_SERVICE_DESCRIPTION";
   private static final String SWAGGER_SERVICE_VERSION = "SWAGGER_SERVICE_VERSION";
   private static final String SWAGGER_SERVICE_TERMS = "SWAGGER_SERVICE_TERMS";
   private static final String SWAGGER_SERVICE_CONTACT_NAME = "SWAGGER_SERVICE_CONTACT_NAME";
   private static final String SWAGGER_SERVICE_CONTACT_URL = "SWAGGER_SERVICE_CONTACT_URL";
   private static final String SWAGGER_SERVICE_CONTACT_MAIL = "SWAGGER_SERVICE_CONTACT_MAIL";
   private static final String SWAGGER_SERVICE_LICENSE_INFO = "SWAGGER_SERVICE_LICENSE_INFO";
   private static final String SWAGGER_SERVICE_LICENSE_URL = "SWAGGER_SERVICE_LICENSE_URL";
   
   @Value("${SWAGGER_SERVICE_BASE_PACKAGE}")
   private String swaggerServiceBasePackage;
   @Value("${SWAGGER_SERVICE_NAME}")
   private String swaggerServiceName;
   @Value("${SWAGGER_SERVICE_DESCRIPTION}")
   private String swaggerServiceDescription;
   @Value("${SWAGGER_SERVICE_VERSION}")
   private String swaggerServiceVersion;
   @Value("${SWAGGER_SERVICE_TERMS}")
   private String swaggerServiceTerms;
   @Value("${SWAGGER_SERVICE_CONTACT_NAME}")
   private String swaggerServiceContactName;
   @Value("${SWAGGER_SERVICE_CONTACT_URL}")
   private String swaggerServiceContactUrl;
   @Value("${SWAGGER_SERVICE_CONTACT_MAIL}")
   private String swaggerServiceContactMail;
   @Value("${SWAGGER_SERVICE_LICENSE_INFO}")
   private String swaggerServiceLicenseInfo;
   @Value("${SWAGGER_SERVICE_LICENSE_URL}")
   private String swaggerServiceLicenseUrl;

   public String getSwaggerServiceBasePackage( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_BASE_PACKAGE, SWAGGER_SERVICE_BASE_PACKAGE, swaggerServiceBasePackage, logPropertyFlag );
   }

   public String getSwaggerServiceName( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_NAME, SWAGGER_SERVICE_NAME, swaggerServiceName, logPropertyFlag );
   }

   public String getSwaggerServiceDescription( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_DESCRIPTION, SWAGGER_SERVICE_DESCRIPTION, swaggerServiceDescription, logPropertyFlag );
   }

   public String getSwaggerServiceVersion( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_VERSION, SWAGGER_SERVICE_VERSION, swaggerServiceVersion, logPropertyFlag );
   }

   public String getSwaggerServiceTerms( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_TERMS, SWAGGER_SERVICE_TERMS, swaggerServiceTerms, logPropertyFlag );
   }

   public String getSwaggerServiceContactName( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_CONTACT_NAME, SWAGGER_SERVICE_CONTACT_NAME, swaggerServiceContactName, logPropertyFlag );
   }

   public String getSwaggerServiceContactUrl( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_CONTACT_URL, SWAGGER_SERVICE_CONTACT_URL, swaggerServiceContactUrl, logPropertyFlag );
   }

   public String getSwaggerServiceContactMail( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_CONTACT_MAIL, SWAGGER_SERVICE_CONTACT_MAIL, swaggerServiceContactMail, logPropertyFlag );
   }

   public String getSwaggerServiceLicenseInfo( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_LICENSE_INFO, SWAGGER_SERVICE_LICENSE_INFO, swaggerServiceLicenseInfo, logPropertyFlag );
   }

   public String getSwaggerServiceLicenseUrl( boolean logPropertyFlag )
   {
      return PropertiesUtils.getStringProperty( DEFAULT_SWAGGER_SERVICE_LICENSE_URL, SWAGGER_SERVICE_LICENSE_URL, swaggerServiceLicenseUrl, logPropertyFlag );
   }

   public void logAllPropertyValues() 
   {
      
      getSwaggerServiceBasePackage( Boolean.TRUE );
      getSwaggerServiceName( Boolean.TRUE );
      getSwaggerServiceDescription( Boolean.TRUE );
      getSwaggerServiceVersion( Boolean.TRUE );
      getSwaggerServiceTerms( Boolean.TRUE );
      getSwaggerServiceContactName( Boolean.TRUE );
      getSwaggerServiceContactUrl( Boolean.TRUE );
      getSwaggerServiceContactMail( Boolean.TRUE );
      getSwaggerServiceLicenseInfo( Boolean.TRUE );
      getSwaggerServiceLicenseUrl( Boolean.TRUE );
      
   }
   
   @Override
   public String toString()
   {
      return "CommonProperties [swaggerServiceBasePackage=" + swaggerServiceBasePackage + ", swaggerServiceName=" + swaggerServiceName + ", swaggerServiceDescription=" + swaggerServiceDescription
            + ", swaggerServiceVersion=" + swaggerServiceVersion + ", swaggerServiceTerms=" + swaggerServiceTerms + ", swaggerServiceContactName=" + swaggerServiceContactName
            + ", swaggerServiceContactUrl=" + swaggerServiceContactUrl + ", swaggerServiceContactMail=" + swaggerServiceContactMail + ", swaggerServiceLicenseInfo=" + swaggerServiceLicenseInfo
            + ", swaggerServiceLicenseUrl=" + swaggerServiceLicenseUrl + "]";
   }

}
