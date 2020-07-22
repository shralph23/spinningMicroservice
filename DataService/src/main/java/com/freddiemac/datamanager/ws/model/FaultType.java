package com.freddiemac.datamanager.ws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
import com.freddiemac.datamanager.ws.esafe.util.DateUtils;

import static com.freddiemac.datamanager.ws.constant.ModelConstants.*;

@JsonPropertyOrder( { FAULT_TYPE_ERROR_CODE, FAULT_TYPE_MESSAGE, FAULT_TYPE_TIMESTAMP, FAULT_TYPE_URI } )
public class FaultType
{
   @JsonProperty( FAULT_TYPE_ERROR_CODE )
   @JsonPropertyDescription( FAULT_TYPE_ERROR_CODE_NOTES )
   private String errorCode;

   @JsonProperty( FAULT_TYPE_MESSAGE )
   @JsonPropertyDescription( FAULT_TYPE_MESSAGE_NOTES )
   private String message;

   @JsonProperty( FAULT_TYPE_TIMESTAMP )
   @JsonPropertyDescription( FAULT_TYPE_TIMESTAMP_NOTES )
   private String timestamp;

   @JsonProperty( FAULT_TYPE_URI )
   @JsonPropertyDescription( FAULT_TYPE_URI_NOTES )
   private String uriRequested;

   public FaultType( String errorCode, String message, String uriRequested )
   {

      this.errorCode = errorCode;
      this.message = message;
      this.uriRequested = uriRequested;
      this.timestamp = DateUtils.convertCurrentTimestampToStringBySimpleDateFormat( EsafeConstants.TIMESTAMP_FORMAT );
   }

   public String getErrorCode()
   {
      return errorCode;
   }

   public void setErrorCode( String errorCode )
   {
      this.errorCode = errorCode;
   }

   public String getMessage()
   {
      return message;
   }

   public void setMessage( String message )
   {
      this.message = message;
   }

   public String getTimestamp()
   {
      return timestamp;
   }

   public void setTimestamp( String timestamp )
   {
      this.timestamp = timestamp;
   }

   public String getUriRequested()
   {
      return uriRequested;
   }

   public void setUriRequested( String uriRequested )
   {
      this.uriRequested = uriRequested;
   }

   public String toCustomString()
   {
      return "FaultType [errorCode=" + errorCode + ", timestamp=" + timestamp + ", uriRequested=" + uriRequested + "]";
   }

   @Override
   public String toString()
   {
      return "FaultType [errorCode=" + errorCode + ", message=" + message + ", timestamp=" + timestamp + ", uriRequested=" + uriRequested + "]";
   }

}
