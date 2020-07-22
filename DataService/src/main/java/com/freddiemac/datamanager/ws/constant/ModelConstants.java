package com.freddiemac.datamanager.ws.constant;

public class ModelConstants {

   //Metadata for the Model types 
   //DataTypes
   public static final String DATA_TYPE_STRING = "String";
   public static final String DATA_TYPE_INT = "int";
   public static final String DATA_TYPE_LIST_STRING = "List<String>";
   public static final String DATA_TYPE_REQUEST_TYPE = "RequestType";
   public static final String DATA_TYPE_RESPONSE_TYPE = "ResponseType";
   public static final String DATA_TYPE_REQUEST_METADATA_TYPE = "RequestMetadataType";
   public static final String DATA_TYPE_RESPONSE_METADATA_TYPE = "ResponseMetadataType";
   public static final String DATA_TYPE_SUBMN_REQUEST_TYPE = "SubmissionRequestType";
   public static final String DATA_TYPE_SUBMN_RESPONSE_TYPE = "SubmissionResponseType";
   public static final String DATA_TYPE_ATTRIBUTES_TYPE = "AttributesType";
   public static final String DATA_TYPE_ADDRESS_TYPE = "AddressType";
   public static final String DATA_TYPE_LIST_SUBMISSION_REQUEST_TYPE = "List<String>";
   public static final String DATA_TYPE_LIST_SUBMISSION_RESPONSE_TYPE = "List<SubmissionResponseType>";
   public static final String DATA_TYPE_FAULT_TYPE = "FaultType";

   //RequestType/ResponseType
   public static final String REQUEST_DESCRIPTION = "Container for the Request MetaData and submissions which belongs to the request.";
   public static final String RESPONSE_DESCRIPTION = "Container for the Request MetaData and submissions which belongs to the response.";
   public static final String REQUEST_RESPONSE_META_DATA_NAME = "RequestMetaData";
   public static final String REQUEST_RESPONSE_META_DATA_NOTES = "The Request MetaData for the input request.";
   public static final String REQUEST_RESPONSE_META_DATA_EXAMPLE = "";
   public static final String REQUEST_RESPONSE_SUBMISSIONS_NAME = "Submissions";
   public static final String REQUEST_RESPONSE_SUBMISSION_NAME = "Submission";
   public static final String REQUEST_RESPONSE_SUBMISSIONS_NOTES = "Submission container array with size between 1 and 100.";
   public static final String REQUEST_RESPONSE_SUBMISSIONS_EXAMPLE = "";
   
   // RequestMetaDataType/ResponseMetaDataType
   public static final String REQUEST_METADATA_NAME = "RequestMetaData";
   public static final String REQUEST_METADATA_DESCRIPTION = "The RequestMetadata for SRS Request. RequestIdentifier,RequestSourceSystem, and RequestRecordCount are required for every request.";
   public static final String RESPONSE_METADATA_NAME = "ResponseMetaData";
   public static final String RESPONSE_METADATA_DESCRIPTION = "Container for the details about the response metadata in the response.";
   public static final String REQUEST_RESPONSE_IDENTIFIER_NAME = "RequestIdentifier";
   public static final String REQUEST_RESPONSE_IDENTIFIER_NOTES = "The Request Identifier for the request; must be 36 characters in length.";
   public static final String REQUEST_RESPONSE_IDENTIFIER_EXAMPLE = "d4033b58-3638-49f8-b717-a884994ff549";
   public static final String REQUEST_RESPONSE_SOURCE_SYSTEM_NAME = "RequestSourceSystem";
   public static final String REQUEST_RESPONSE_SOURCE_SYSTEM_NOTES = "The Request Source System for request; must be not null and 1 to 100 characters in length.";
   public static final String REQUEST_RESPONSE_SOURCE_SYSTEM_EXAMPLE = "SMOKE-TEST";
   public static final String REQUEST_RESPONSE_TIMESTAMP_NAME = "RequestTimeStamp";
   public static final String REQUEST_RESPONSE_TIMESTAMP_NOTES = "The Request TimeStamp for the request.";
   public static final String REQUEST_RESPONSE_TIMESTAMP_EXAMPLE = "2020-05-16T01:31:23.535-04:00";
   public static final String REQUEST_RESPONSE_RECORD_COUNT_NAME = "RequestRecordCount";
   public static final String REQUEST_RESPONSE_RECORD_COUNT_NOTES = "The Request Record Count for submissions in the request; must be not null and value must be between 1 and 100.";
   public static final String REQUEST_RESPONSE_RECORD_COUNT_EXAMPLE = "1";

   //SubmissionRequestType
   public static final String SUBMN_REQUEST_DESCRIPTION = "Submission container array with size between 1 and 100.";
      
   //FaultType
   public static final String FAULT_TYPE_ERROR_CODE = "ErrorCode";
   public static final String FAULT_TYPE_ERROR_CODE_NOTES = "The error code for the exception being thrown.";
   public static final String FAULT_TYPE_MESSAGE = "Message";
   public static final String FAULT_TYPE_MESSAGE_NOTES = "The detailed fault message for the exception being thrown.";
   public static final String FAULT_TYPE_TIMESTAMP = "TimeStamp";
   public static final String FAULT_TYPE_TIMESTAMP_NOTES = "The Fault TimeStamp for the response.";
   public static final String FAULT_TYPE_URI = "Uri";
   public static final String FAULT_TYPE_URI_NOTES = "Uniform Resource Locator for the request.";
   
   private ModelConstants() {
   }
   
}
