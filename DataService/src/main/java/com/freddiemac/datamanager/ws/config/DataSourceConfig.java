package com.freddiemac.datamanager.ws.config;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.CP_MAXIMUM_POOL_SIZE;
import static com.freddiemac.datamanager.ws.constant.ServiceConstants.CP_MINIMUM_IDLE;
import static com.freddiemac.datamanager.ws.constant.ServiceConstants.CP_NAME;
import static com.freddiemac.datamanager.ws.constant.ServiceConstants.POOL_NAME;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.freddiemac.datamanager.ws.constant.ServiceConstants;
import com.freddiemac.datamanager.ws.esafe.util.GeneralUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
   
	private static final Logger LOGGER = ApplicationLogger.getLogger( DataSourceConfig.class );

	@Bean
	public DataSource dataSource( EnvSpecificAppProperties envSpecificAppProperties ) {
	   
		HikariConfig config = new HikariConfig();
		HikariDataSource ds;

		String finalDbUrl = envSpecificAppProperties.getSlsDbUrl( Boolean.FALSE );
		
		LOGGER.info( "DataSource URL:'{}'", finalDbUrl );
		config.setJdbcUrl(finalDbUrl);
		config.setUsername(envSpecificAppProperties.getSlsDbUser( Boolean.FALSE ));

		//Fetching Credentials
      String dbSecurityCode = GeneralUtils.fetchAuthorizationCredentials( ServiceConstants.SERVICE_SLS_DATABASE, envSpecificAppProperties.getSlsDbUser( Boolean.FALSE ),
                                                                          envSpecificAppProperties.getSlsDbSecretsLocation( Boolean.FALSE ), envSpecificAppProperties.getSlsDbMacVaultAlias( Boolean.FALSE ),
                                                                          envSpecificAppProperties.getSlsDbSecurityCodeFetchTypeEnum( Boolean.FALSE ) );
      
		config.setPassword(dbSecurityCode);
		config.addDataSourceProperty(POOL_NAME, CP_NAME);
		config.addDataSourceProperty(CP_MAXIMUM_POOL_SIZE, envSpecificAppProperties.getSlsDbMaximumCpSize( Boolean.FALSE ));
		config.addDataSourceProperty(CP_MINIMUM_IDLE, envSpecificAppProperties.getSlsDbMinimumCpIdle( Boolean.FALSE ));

		ds = new HikariDataSource(config);
		LOGGER.info( "Sucessfully created the DataSource for SubmissionLinkRestService application" );

		return ds;
		
	}
	
   @Bean
   public NamedParameterJdbcTemplate pmlNamedParameterJdbcTemplate( HikariDataSource slsDataSource )
   {
      return new NamedParameterJdbcTemplate( slsDataSource );
   }

}
