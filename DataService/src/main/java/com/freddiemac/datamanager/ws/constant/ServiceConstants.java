package com.freddiemac.datamanager.ws.constant;

import java.util.UUID;

public class ServiceConstants
{

   //Service version information
   public static final String SERVICE_SRS_VERSION = "V1.0";
   public static final String SERVICE_SRS_INTERNAL_VERSION = SERVICE_SRS_VERSION + ".1";
   public static final String SERVICE_SRS_ABBREVIATION_LC = "srs";
   public static final String SERVICE_SRS_ABBREVIATION_UC = "SRS";
   public static final String SERVICE_SRS_FULL_NAME = "SLIDRetrievalService";
   
   //SLS Database
   public static final String SERVICE_SLS_DATABASE = "SLS Database";
   
   //DB constants
   public static final String CURRENT_SCHEMA = "currentSchema=";
   public static final String CURRENT_FUNCTION_PATH = "currentFunctionPath=";

   //DB connection pool
   public static final String POOL_NAME = "poolName";
   public static final String CP_MAXIMUM_POOL_SIZE = "maximumPoolSize";
   public static final String CP_MINIMUM_IDLE = "minimumIdle";
   public static final String CP_NAME = "SpringBootHikariCP";
   
   //WebService constants
   public static final String APPLICATION_CONTEXT = "classpath*:/META-INF/spring/application-context.xml";

   public static final String SERVICE_CONTENT_TYPE = "content-type";
   public static final String SERVICE_USER_AGENT = "user-agent";
   public static final String SERVICE_USER_NAME = "user-name";
   public static final String SERVICE_IP_ADDRESS = "X-Forwarded-For";
   public static final String SERVICE_CONTENT_LANGUAGE = "Content-Language";
   public static final String SERVICE_CONTENT_LENGTH = "content-length";
   public static final String SERVICE_REQUEST_POST = "POST";
   public static final String SERVICE_CONTENT_LANGUAGE_US = "en-US";

   //WebService controller
   public static final String SERVICE_CONTROLLER_NAME = "Data Service Management System";
   public static final String POST_MAPPING_VALUE = "/retrieveData";
   public static final String SERVICE_CONTROLLER_OPERATION = "Write a description about service";
   
   //webService content
   public static final String JSON_VALUE = "JSON";
   public static final String XML_VALUE = "XML";
   
   //WebService security settings
   public static final String SERVICE_AUTHORIZATION = "Authorization";
   public static final String SECURITY_NONE = "None";
   public static final String SECURITY_BASIC_AUTH = "Basic";
   
   //String constants
   public static final String NEW_LINE = System.getProperty( "line.separator" );
   public static final String EMPTY_STRING = "";
   public static final String BLANK_SPACE = " ";
   public static final String TAB = "\t";
   public static final String COMMA = ",";
   public static final String STRING_SEPERATOR = " | ";
   public static final String EQUAL = "=";
   public static final String COLON = ":";
   public static final String SEMI_COLON = ";";
   public static final String UNKNOWN = "Unknown";
   public static final String STRING_DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm:ss:SSS";

   //Patterns for grepping logs
   public static final String REQUEST_PREFIX = "RQT";  
   public static final String CACHE_LOAD_PREFIX = "CACHE";
   public static final String SUBMISSION_QUERY_PREFIX = "QRY-SUB";
   public static final String BORROWER_QUERY_PREFIX = "QRY-BOR";
   public static final String EXCLUDING_QUERY_PREFIX = "QRY-EXC";
   
   //validation log message constants
   public static final String MESSAGE_VALIDATING_REQUEST = "Validating JSON request...";
   public static final String MESSAGE_ERROR_PARSING_REQUEST = "Error parsing the JSON request using the JSON schema";
   public static final String MESSAGE_ERROR_VALIDATING_REQUEST = "Error Valiating incoming request:";
   public static final String MESSAGE_ERROR_JSON_SERILIZATION_REQUEST = "Error due to JSON serilization of the request";
   public static final String RESPONSE_SENT = "RESPONSE_SENT";
   public static final String REQUEST_FAILURE = "REQUEST_FAILURE";
   public static final String MESSAGE_JSON_VALID = "Is JSON request valid {}";
   public static final String MESSAGE_JSON_PROCESSING = "Processing Message: ";
   public static final String JOSN_SERIALIZE_ERROR_MESSAGE = "Unable to serialize";
   
   //LDAP log message constants
   public static final String MESSAGE_CONFIGURE_AD_LDAP = "Configuring AD LDAP provided with domain {} and URL {}";
   public static final String MESSAGE_CONFIGURE_AD_GROUP = "Configuring http security with {}";
   public static final String MESSAGE_LDAP_AD_AUTH_SERVER = "LDAP authentication from AD server";
   public static final String MESSAGE_LDAP_AD_AUTH_CACHE = "LDAP authentication from cache";
   
   //LDAP retry log message constants
   public static final String MSG_AD_SRV_AUTHENTICATION_EXCEPTION = "Maximum retry exhausted. LDAP AuthenticationProvider failed due to Excetpion";
   public static final String MSG_AD_SRV_SPRING_COMMEXCEPTION = "Maximum retry exhausted. LDAP AuthenticationProvider Spring CommunicationException";
   public static final String MSG_AD_SRV_SOCKET_EXCEPTION = "Maximum retry exhausted. LDAP server AuthenticationProvider SocketException";
   public static final String MSG_AD_SRV_CONNECTION_EXCEPTION = "Maximum retry exhausted. LDAP server AuthenticationProvider ConnectionException";
   public static final String MSG_AD_SRV_JAVAX_COMMEXCEPTION = "Maximum retry exhausted. LDAP server AuthenticationProvider Javax CommunicationException";
   
   //Exception log message constants
   public static final String MESSAGE_REQUEST_EXCEPTION_PREFIX = REQUEST_PREFIX + " - %s";
   public static final String MESSAGE_REQUEST_ERRORCODE_EXCEPTION_POSFIX = " - ErrorCode:'{}' due to Exception:'{}'";
   public static final String MESSAGE_REQUEST_ERRORCODE_ERRORMSG_POSFIX = " - ErrorCode:'{}' due to ErrorMessage:'{}'";
   public static final String MESSAGE_REQUEST_ERRORCODE_ERRORMSG_EXCEPTION_POSFIX = " - ErrorCode:'{}' due to ErrorMessage:'{}' due to Exception:'{}'";
   public static final String MESSAGE_REQUEST_ERRORCODE_EXCEPTION_PREFIX_PLUS_POSFIX = REQUEST_PREFIX + MESSAGE_REQUEST_ERRORCODE_EXCEPTION_POSFIX;
   public static final String MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX = REQUEST_PREFIX + MESSAGE_REQUEST_ERRORCODE_ERRORMSG_POSFIX;
   public static final String MESSAGE_REQUEST_ERRORCODE_ERRORMSG_EXCEPTION_PREFIX_PLUS_POSFIX = REQUEST_PREFIX + MESSAGE_REQUEST_ERRORCODE_ERRORMSG_EXCEPTION_POSFIX;
      
   //Database column length
   public static final int DB_COLUMN_LENGTH_TWO = 2;
   public static final int DB_COLUMN_LENGTH_EIGHTEEN = 18;
   public static final int DB_COLUMN_LENGTH_THIRTY = 30;
   public static final int DB_COLUMN_LENGTH_THIRTYFIVE = 35;
   public static final int DB_COLUMN_LENGTH_FIFTY = 50;
   public static final int DB_COLUMN_LENGTH_HUNDRED = 100;
   public static final int DB_COLUMN_LENGTH_ONEHUNDREDFIFTY = 150;
   public static final int DB_COLUMN_LENGTH_TWOHUNDREDFIFTYSIX = 256;
   
   // uuid default
   public static final int SIZE_UUID_FIELD = 36;

   // sets default uuid value as "00000000-0000-0000-0000-000000000000"
   public static final String DEFAULT_UUID = new UUID(0L, 0L).toString();

   //Spring scheduler thread name
   public static final String SPRING_SCHEDULER_THREAD_PREFIX = "Running with Scheduler";

   private ServiceConstants() {
   }
   
}
