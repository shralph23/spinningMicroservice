package com.freddiemac.datamanager.ws.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

   private static final Logger LOGGER = ApplicationLogger.getLogger( SpringFoxConfig.class );

   @Autowired
   EnvCommonAppProperties envCommonAppProperties;
   
   @Bean
   public Docket api(EnvSpecificAppProperties envSpecificAppProperties) {
      
      boolean swaggerEnableFlag = envSpecificAppProperties.isSwEnableFlag( Boolean.FALSE );
      
      if ( swaggerEnableFlag ) {
         LOGGER.info( "Sucessfully created the Swagger UI for SLIDRetrievalService application" );
      }
      else {
         LOGGER.info( "Swagger UI is disabled in this environment for SLIDRetrievalService application" );
      }
      
      return new Docket( DocumentationType.SWAGGER_2 )
                  .enable( swaggerEnableFlag )
                  .select()
                     .apis( RequestHandlerSelectors.basePackage( envCommonAppProperties.getSwaggerServiceBasePackage( Boolean.FALSE ) ) )
                     .paths( PathSelectors.any() )
                     .build()
                  .apiInfo( getApiEndPointsInfo() );
      
   }
   
   private ApiInfo getApiEndPointsInfo() {
      return new ApiInfoBuilder()
                    .title( envCommonAppProperties.getSwaggerServiceName( Boolean.FALSE ) )
                    .description( envCommonAppProperties.getSwaggerServiceDescription( Boolean.FALSE ) )
                    .version( envCommonAppProperties.getSwaggerServiceVersion( Boolean.FALSE ) )
                    .termsOfServiceUrl( envCommonAppProperties.getSwaggerServiceTerms( Boolean.FALSE ) )
                    .contact( getContact() )
                    .license( envCommonAppProperties.getSwaggerServiceLicenseInfo( Boolean.FALSE ) )
                    .licenseUrl( envCommonAppProperties.getSwaggerServiceLicenseUrl( Boolean.FALSE ) )
                    .build();
   }
   
   private Contact getContact() {
      return new Contact( envCommonAppProperties.getSwaggerServiceContactName( Boolean.FALSE ), 
                          envCommonAppProperties.getSwaggerServiceContactUrl( Boolean.FALSE ), 
                          envCommonAppProperties.getSwaggerServiceContactMail( Boolean.FALSE ) );
   }
   
}
