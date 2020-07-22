package com.freddiemac.datamanager.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.freddiemac.datamanager.ws.constant.ServiceConstants;
import com.freddiemac.datamanager.ws.enums.SecurityCodeFetchType;
import com.freddiemac.datamanager.ws.esafe.util.PropertiesUtils;

/*
 List of configurable parameters
 Active directory configuration
 "AD_DOMAIN"                 - active directory domain name
 "AD_URL"                    - active directory url
 "AD_GROUP"                  - active directory group
 "AD_EXPIRATION_SECONDS"     - active directory expiration seconds
 "AD_MAX_RETRY_ATTEMPTS"     - active directory retry attempts
 "AD_RETRY_DELAY_MS"         - active directory retry delay in milliseconds
    
 Logging Levels
 "FW_LOG_LEVEL"              - firmwide logging level
 "APP_LOG_LEVEL"             - application logging level

 APM Java Agent environment parameters
 "ELASTIC_APM_ENVIRONMENT"             - apm environment information
 "ELASTIC_APM_RECORDING"               - apm recording flag
 "ELASTIC_APM_SERVICE_NAME"            - apm server name
 "ELASTIC_APM_APPLICATION_PACKAGES"    - apm application packages
 "ELASTIC_APM_SERVER_URLS"             - apm server url
 "ELASTIC_APM_VERIFY_SERVER_CERT"      - apm verify server certificate
 "ELASTIC_APM_ENABLE_LOG_CORRELATION"  - apm enable logging correlation
 "ELASTIC_APM_GLOBAL_LABELS"           - apm permission details

 Swagger UI
 "SW_ENABLE_FLAG"            - Enable or disable the swagger documentation for the rest api

 Hikari SLS datasource configuration
 "SLS_DB_CLASSNAME"          - set the database drive used to connect the sls database.
 "SLS_DB_URL                 - set the connection url to the sls database.
 "SLS_DB_USER"               - retrieve the auth user used to connect to the sls database.
 "SLS_DB_SECRETS_LOCATION"   - retrieve the secret code used to connect to the sls database.

 Hikari connection pool configuration   
 "SLS_MAXIMUM_CP_SIZE"       - set the maximum connection pool size
 "SLS_MINIMUM_CP_IDLE"        - set the minimum connection pool idle size

 MacVault alias for SLS database
 "SLS_DB_MAC_VAULT_ALIAS"    - retrieve the auth user and secret code from mac vault or open shift secrets location
 "SLS_DB_SECURITY_CODE_FETCH_TYPE"     - retrieve the secret code from mac vault or open shift secrets location or default type
 
*/

@Component
@ConfigurationProperties
public class EnvSpecificAppProperties {

	// Defaults if nothing found in property file
	private static final String DEFAULT_SLS_DB_CLASSNAME = "com.ibm.db2.jcc.DB2Driver";
	private static final String DEFAULT_SLS_DB_URL = ServiceConstants.EMPTY_STRING;
	private static final String DEFAULT_SLS_DB_USER = ServiceConstants.EMPTY_STRING;
	private static final String DEFAULT_SLS_DB_SECRETS_LOCATION = ServiceConstants.EMPTY_STRING;
	private static final int DEFAULT_SLS_DB_MAXIMUM_CP_SIZE = 15;
	private static final int DEFAULT_SLS_DB_MINIMUM_CP_IDLE = 1;
	private static final String DEFAULT_SLS_DB_MAC_VAULT_ALIAS = ServiceConstants.EMPTY_STRING;
	private static final String DEFAULT_SLS_DB_SECURITY_CODE_FETCH_TYPE = "Default";
	private static final String DEFAULT_AD_DOMAIN = "fhlmc.com";
	private static final String DEFAULT_AD_URL = "ldaps://fhlmc.com";
	private static final String DEFAULT_AD_GROUP = ServiceConstants.EMPTY_STRING;
	private static final int DEFAULT_AD_EXPIRATION_SECONDS = 600;
	private static final int DEFAULT_AD_MAX_RETRY_ATTEMPTS = 2;
	private static final int DEFAULT_AD_RETRY_DELAY_MS = 50;
	private static final String DEFAULT_FW_LOG_LEVEL = "INFO";
	private static final String DEFAULT_APP_LOG_LEVEL = "DEBUG";
	private static final boolean DEFAULT_SW_ENABLE_FLAG = Boolean.FALSE;

	private static final String DEFAULT_ELASTIC_APM_ENVIRONMENT = ServiceConstants.EMPTY_STRING;
	private static final boolean DEFAULT_ELASTIC_APM_RECORDING = Boolean.FALSE;
	private static final String DEFAULT_ELASTIC_APM_SERVICE_NAME = "sf-ba0315-slid_retrieval_service";
	private static final String DEFAULT_ELASTIC_APM_APPLICATION_PACKAGES = ServiceConstants.EMPTY_STRING;
	private static final String DEFAULT_ELASTIC_APM_SERVER_URLS = ServiceConstants.EMPTY_STRING;
	private static final boolean DEFAULT_ELASTIC_APM_VERIFY_SERVER_CERT = Boolean.FALSE;
	private static final boolean DEFAULT_ELASTIC_APM_ENABLE_LOG_CORRELATION = Boolean.FALSE;
	private static final String DEFAULT_ELASTIC_APM_GLOBAL_LABELS = ServiceConstants.EMPTY_STRING;

	// Properties Names
	private static final String AD_DOMAIN = "AD_DOMAIN";
	private static final String AD_URL = "AD_URL";
	private static final String AD_GROUP = "AD_GROUP";
	private static final String AD_EXPIRATION_SECONDS = "AD_EXPIRATION_SECONDS";
	private static final String AD_MAX_RETRY_ATTEMPTS = "AD_MAX_RETRY_ATTEMPTS";
	private static final String AD_RETRY_DELAY_MS = "AD_RETRY_DELAY_MS";
	private static final String FW_LOG_LEVEL = "FW_LOG_LEVEL";
	private static final String APP_LOG_LEVEL = "APP_LOG_LEVEL";
	private static final String SW_ENABLE_FLAG = "SW_ENABLE_FLAG";
	private static final String ELASTIC_APM_ENVIRONMENT = "ELASTIC_APM_ENVIRONMENT";
	private static final String ELASTIC_APM_RECORDING = "ELASTIC_APM_RECORDING";
	private static final String ELASTIC_APM_SERVICE_NAME = "ELASTIC_APM_SERVICE_NAME";
	private static final String ELASTIC_APM_APPLICATION_PACKAGES = "ELASTIC_APM_APPLICATION_PACKAGES";
	private static final String ELASTIC_APM_SERVER_URLS = "ELASTIC_APM_SERVER_URLS";
	private static final String ELASTIC_APM_VERIFY_SERVER_CERT = "ELASTIC_APM_VERIFY_SERVER_CERT";
	private static final String ELASTIC_APM_ENABLE_LOG_CORRELATION = "ELASTIC_APM_ENABLE_LOG_CORRELATION";
	private static final String ELASTIC_APM_GLOBAL_LABELS = "ELASTIC_APM_GLOBAL_LABELS";
	private static final String SLS_DB_CLASSNAME = "SLS_DB_CLASSNAME";
	private static final String SLS_DB_URL = "SLS_DB_URL";
	private static final String SLS_DB_USER = "SLS_DB_USER";
	private static final String SLS_DB_SECRETS_LOCATION = "SLS_DB_SECRETS_LOCATION";
	private static final String SLS_DB_MAXIMUM_CP_SIZE = "SLS_DB_MAXIMUM_CP_SIZE";
	private static final String SLS_DB_MINIMUM_CP_IDLE = "SLS_DB_MINIMUM_CP_IDLE";
	private static final String SLS_DB_MAC_VAULT_ALIAS = "SLS_DB_MAC_VAULT_ALIAS";
	private static final String SLS_DB_SECURITY_CODE_FETCH_TYPE = "SLS_DB_SECURITY_CODE_FETCH_TYPE";

	// Generic properties
	@Value("${AD_DOMAIN}")
	private String adDomain;
	@Value("${AD_URL}")
	private String adUrl;
	@Value("${AD_GROUP}")
	private String adGroup;
	@Value("${AD_EXPIRATION_SECONDS}")
	private int adExpirationSeconds;
	@Value("${AD_MAX_RETRY_ATTEMPTS}")
	private int adMaxRetryAttempts;
	@Value("${AD_RETRY_DELAY_MS}")
	private int adRetryDelayMs;
	@Value("${FW_LOG_LEVEL}")
	private String fwLogLevel;
	@Value("${APP_LOG_LEVEL}")
	private String appLogLevel;
	@Value("${SW_ENABLE_FLAG}")
	private boolean swEnableFlag;

	// APM Java Agent environment properties
	@Value("${ELASTIC_APM_ENVIRONMENT}")
	private String elasticApmEnvironment;
	@Value("${ELASTIC_APM_RECORDING}")
	private boolean elasticApmRecording;
	@Value("${ELASTIC_APM_SERVICE_NAME}")
	private String elasticApmServiceName;
	@Value("${ELASTIC_APM_APPLICATION_PACKAGES}")
	private String elasticApmApplicationPackages;
	@Value("${ELASTIC_APM_SERVER_URLS}")
	private String elasticApmServerUrls;
	@Value("${ELASTIC_APM_VERIFY_SERVER_CERT}")
	private boolean elasticApmVerifyServerCert;
	@Value("${ELASTIC_APM_ENABLE_LOG_CORRELATION}")
	private boolean elasticApmEnableLogCorrelation;
	@Value("${ELASTIC_APM_GLOBAL_LABELS}")
	private String elasticApmGlobalLabels;

	// SLS Datasource information
	@Value("${SLS_DB_CLASSNAME}")
	private String slsDbClassName;
	@Value("${SLS_DB_URL}")
	private String slsDbUrl;
	@Value("${SLS_DB_USER}")
	private String slsDbUser;
	@Value("${SLS_DB_SECRETS_LOCATION}")
	private String slsDbSecretsLocation;
	@Value("${SLS_DB_MAXIMUM_CP_SIZE}")
	private int slsDbMaximumCpSize;
	@Value("${SLS_DB_MINIMUM_CP_IDLE}")
	private int slsDbMinimumCpIdle;
	@Value("${SLS_DB_MAC_VAULT_ALIAS}")
	private String slsDbMacVaultAlias;
	@Value("${SLS_DB_SECURITY_CODE_FETCH_TYPE}")
	private String slsDbSecurityCodeFetchType;

	public String getAdDomain(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_AD_DOMAIN, AD_DOMAIN, adDomain, logPropertyFlag);
	}

	public String getAdUrl(Boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_AD_URL, AD_URL, adUrl, logPropertyFlag);
	}

	public String getAdGroup(Boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_AD_GROUP, AD_GROUP, adGroup, logPropertyFlag);
	}

	public int getAdExpirationSeconds(boolean logPropertyFlag) {
		return PropertiesUtils.getIntProperty(DEFAULT_AD_EXPIRATION_SECONDS, AD_EXPIRATION_SECONDS, adExpirationSeconds,
				logPropertyFlag);
	}

	public int getAdMaxRetryAttempts(boolean logPropertyFlag) {
		return PropertiesUtils.getIntProperty(DEFAULT_AD_MAX_RETRY_ATTEMPTS, AD_MAX_RETRY_ATTEMPTS, adMaxRetryAttempts,
				logPropertyFlag);
	}

	public int getAdRetryDelayMs(boolean logPropertyFlag) {
		return PropertiesUtils.getIntProperty(DEFAULT_AD_RETRY_DELAY_MS, AD_RETRY_DELAY_MS, adRetryDelayMs,
				logPropertyFlag);
	}

	public String getFwLogLevel(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_FW_LOG_LEVEL, FW_LOG_LEVEL, fwLogLevel, logPropertyFlag);
	}

	public String getAppLogLevel(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_APP_LOG_LEVEL, APP_LOG_LEVEL, appLogLevel, logPropertyFlag);
	}

	public boolean isSwEnableFlag(boolean logPropertyFlag) {
		return PropertiesUtils.getBooleanProperty(DEFAULT_SW_ENABLE_FLAG, SW_ENABLE_FLAG, swEnableFlag,
				logPropertyFlag);
	}

	public String getElasticApmEnvironment(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_ELASTIC_APM_ENVIRONMENT, ELASTIC_APM_ENVIRONMENT,
				elasticApmEnvironment, logPropertyFlag);
	}

	public boolean isElasticApmRecording(boolean logPropertyFlag) {
		return PropertiesUtils.getBooleanProperty(DEFAULT_ELASTIC_APM_RECORDING, ELASTIC_APM_RECORDING,
				elasticApmRecording, logPropertyFlag);
	}

	public String getElasticApmServiceName(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_ELASTIC_APM_SERVICE_NAME, ELASTIC_APM_SERVICE_NAME,
				elasticApmServiceName, logPropertyFlag);
	}

	public String getElasticApmApplicationPackages(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_ELASTIC_APM_APPLICATION_PACKAGES,
				ELASTIC_APM_APPLICATION_PACKAGES, elasticApmApplicationPackages, logPropertyFlag);
	}

	public String getElasticApmServerUrls(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_ELASTIC_APM_SERVER_URLS, ELASTIC_APM_SERVER_URLS,
				elasticApmServerUrls, logPropertyFlag);
	}

	public boolean isElasticApmVerifyServerCert(boolean logPropertyFlag) {
		return PropertiesUtils.getBooleanProperty(DEFAULT_ELASTIC_APM_VERIFY_SERVER_CERT,
				ELASTIC_APM_VERIFY_SERVER_CERT, elasticApmVerifyServerCert, logPropertyFlag);
	}

	public boolean isElasticApmEnableLogCorrelation(boolean logPropertyFlag) {
		return PropertiesUtils.getBooleanProperty(DEFAULT_ELASTIC_APM_ENABLE_LOG_CORRELATION,
				ELASTIC_APM_ENABLE_LOG_CORRELATION, elasticApmEnableLogCorrelation, logPropertyFlag);
	}

	public String getElasticApmGlobalLabels(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_ELASTIC_APM_GLOBAL_LABELS, ELASTIC_APM_GLOBAL_LABELS,
				elasticApmGlobalLabels, logPropertyFlag);

	}

	public String getSlsDbClassName(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_CLASSNAME, SLS_DB_CLASSNAME, slsDbClassName,
				logPropertyFlag);
	}

	public String getSlsDbUrl(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_URL, SLS_DB_URL, slsDbUrl, logPropertyFlag);
	}

	public String getSlsDbUser(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_USER, SLS_DB_USER, slsDbUser, logPropertyFlag);
	}

	public String getSlsDbSecretsLocation(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_SECRETS_LOCATION, SLS_DB_SECRETS_LOCATION,
				slsDbSecretsLocation, logPropertyFlag);
	}

	public int getSlsDbMaximumCpSize(boolean logPropertyFlag) {
		return PropertiesUtils.getIntProperty(DEFAULT_SLS_DB_MAXIMUM_CP_SIZE, SLS_DB_MAXIMUM_CP_SIZE,
				slsDbMaximumCpSize, logPropertyFlag);
	}

	public int getSlsDbMinimumCpIdle(boolean logPropertyFlag) {
		return PropertiesUtils.getIntProperty(DEFAULT_SLS_DB_MINIMUM_CP_IDLE, SLS_DB_MINIMUM_CP_IDLE,
				slsDbMinimumCpIdle, logPropertyFlag);
	}

	public String getSlsDbMacVaultAlias(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_MAC_VAULT_ALIAS, SLS_DB_MAC_VAULT_ALIAS,
				slsDbMacVaultAlias, logPropertyFlag);
	}

	public SecurityCodeFetchType getSlsDbSecurityCodeFetchTypeEnum(boolean logPropertyFlag) {
		return SecurityCodeFetchType.fromValue(getSlsDbSecurityCodeFetchType(logPropertyFlag));
	}

	public String getSlsDbSecurityCodeFetchType(boolean logPropertyFlag) {
		return PropertiesUtils.getStringProperty(DEFAULT_SLS_DB_SECURITY_CODE_FETCH_TYPE,
				SLS_DB_SECURITY_CODE_FETCH_TYPE, slsDbSecurityCodeFetchType, logPropertyFlag);
	}

	public void logAllPropertyValues() {

		getAdDomain(Boolean.TRUE);
		getAdUrl(Boolean.TRUE);
		getAdGroup(Boolean.TRUE);
		getAdExpirationSeconds(Boolean.TRUE);
		getAdMaxRetryAttempts(Boolean.TRUE);
		getAdRetryDelayMs(Boolean.TRUE);
		getFwLogLevel(Boolean.TRUE);
		getAppLogLevel(Boolean.TRUE);
		isSwEnableFlag(Boolean.TRUE);
		getElasticApmEnvironment(Boolean.TRUE);
		isElasticApmRecording(Boolean.TRUE);
		getElasticApmServiceName(Boolean.TRUE);
		getElasticApmApplicationPackages(Boolean.TRUE);
		getElasticApmServerUrls(Boolean.TRUE);
		isElasticApmVerifyServerCert(Boolean.TRUE);
		isElasticApmEnableLogCorrelation(Boolean.TRUE);
		getElasticApmGlobalLabels(Boolean.TRUE);
		getSlsDbClassName(Boolean.TRUE);
		getSlsDbUrl(Boolean.TRUE);
		getSlsDbUser(Boolean.TRUE);
		getSlsDbSecretsLocation(Boolean.TRUE);
		getSlsDbMaximumCpSize(Boolean.TRUE);
		getSlsDbMinimumCpIdle(Boolean.TRUE);
		getSlsDbMacVaultAlias(Boolean.TRUE);
		getSlsDbSecurityCodeFetchType(Boolean.TRUE);
	}

	@Override
	public String toString() {
		return "EnvSpecificAppProperties [adDomain=" + adDomain + ", adUrl=" + adUrl + ", adGroup=" + adGroup
				+ ", adExpirationSeconds=" + adExpirationSeconds + ", adMaxRetryAttempts=" + adMaxRetryAttempts
				+ ", adRetryDelayMs=" + adRetryDelayMs + ", fwLogLevel=" + fwLogLevel + ", appLogLevel=" + appLogLevel
				+ ", swEnableFlag=" + swEnableFlag + ", elasticApmEnvironment=" + elasticApmEnvironment
				+ ", elasticApmRecording=" + elasticApmRecording + ", elasticApmServiceName=" + elasticApmServiceName
				+ ", elasticApmApplicationPackages=" + elasticApmApplicationPackages + ", elasticApmServerUrls="
				+ elasticApmServerUrls + ", elasticApmVerifyServerCert=" + elasticApmVerifyServerCert
				+ ", elasticApmEnableLogCorrelation=" + elasticApmEnableLogCorrelation + ", elasticApmGlobalLabels="
				+ elasticApmGlobalLabels + ", slsDbClassName=" + slsDbClassName + ", slsDbUrl=" + slsDbUrl
				+ ", slsDbUser=" + slsDbUser + ", slsDbSecretsLocation=" + slsDbSecretsLocation
				+ ", slsDbMaximumCpSize=" + slsDbMaximumCpSize + ", slsDbMinimumCpIdle=" + slsDbMinimumCpIdle
				+ ", slsDbMacVaultAlias=" + slsDbMacVaultAlias + ", slsDbSecurityCodeFetchType="
				+ slsDbSecurityCodeFetchType + "]";
	}

}
