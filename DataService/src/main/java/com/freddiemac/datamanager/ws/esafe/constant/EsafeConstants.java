package com.freddiemac.datamanager.ws.esafe.constant;

/**
 * Constants for ESAFE
 */
public class EsafeConstants
{
   
   // Operating systems 
   public static final String PROPERTY_OS_NAME = "os.name";
   public static final String PROPERTY_USER_NAME = "user.name";
   public static final String PROPERTY_VALUE_UNKNOWN = "unknown";
   
   // NULL values
   public static final String NULL_SLSID = "00000000-0000-0000-0000-000000000000";
   public static final long NULL_GENERATED_ID = -1;
   
   // Empty String 
   public static final String EMPTY_STRING = "";
   public static final String HYPHEN_STRING = "-";
   public static final String SINGLE_SPACE_STRING = " ";
   public static final String SEMI_COLON_STRING = ":";
   public static final String COMMA = "," ;
   
   //String utilities
   public static final String CONCATENATED_PREFIX = "PREFIX" ;
   public static final String CONCATENATED_SUFFIX = "SUFFIX" ;
   
   // common ESAFE Entity Types
   public static final String SUBMISSION_UPPERCASE = "SUBMISSION";
   
   // common ESAFE Product Types
   public static final String PML_LOAN = "PML_LOAN";
   public static final String SLS = "SLS";
   
   //Date type values
   public static final String HOURS = "HOURS";
   public static final String MINUTES = "MINUTES";
   public static final String SECONDS = "SECONDS";
   public static final String MILLISECONDS = "MILLISECONDS";
   public static final String TIMESTAMP_FORMAT = "MM-dd-yyyy HH:mm:ss:SSS";
   
   public static final String DECODED_FIELD_PREFIX = "DECODE-";

   //log messages
   public static final String GENERAL_UTIILS_EXCEPTION_MESSAGE = "Error Message :'{}' due to Exception :";
   public static final String PROPERTY_NAME_DEFAULT_PREFIX = "DEFAULT_";
   public static final String PROPERTY_DEFAULT_LOG = "Setting service property using environment specific default PropertyName:'{}' - PropertyValue:'{}'";
   public static final String PROPERTY_FETCHED_LOG = "Setting service property using environment specific configuration PropertyName:'{}' - PropertyValue:'{}'";
   
   public static final String PREFIX_ERRORCODE_DESCRIPTION_LOG_MESSAGE = "%s - ErrorCode:'%s' - '%s'";
   public static final String ERRORCODE_DESCRIPTION_LOG_MESSAGE = "ErrorCode:'%s' - '%s'";
   public static final String EXCEPTION_DESCRIPTION_LOG_MESSAGE = "Exception:'%s' - '%s'";
   public static final String ERRORCODE_EXCEPTION_NAME_LOG_MESSAGE = "ErrorCode:'%s' in Exception:'%s'";
   public static final String ERRORCODE_EXCEPTION_DESCRIPTION_LOG_MESSAGE = "ErrorCode:'%s' in Exception:'%s' - '%s'";
   public static final String PREFIX_ERRORCODE_EXCEPTION_DESCRIPTION_LOG_MESSAGE = "%s - ErrorCode:'%s' in Exception:'%s' - '%s'";

   // constants used for XML DOM parser
   public static final String XML_EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities"; 
   public static final String XML_EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
   public static final String XML_DISALLOW_DOCTYPE_DECLARATION = "http://apache.org/xml/features/disallow-doctype-decl";
   public static final String XML_SECURE_PROCESSING = "http://javax.xml.XMLConstants/feature/secure-processing";
   
   private EsafeConstants() {
   }
   
}
