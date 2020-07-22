package com.freddiemac.datamanager.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.freddiemac.datamanager.ws.constant.ModelConstants.*;

@ApiModel( value = DATA_TYPE_RESPONSE_METADATA_TYPE, description = RESPONSE_METADATA_DESCRIPTION )
@JsonPropertyOrder(
{ REQUEST_RESPONSE_IDENTIFIER_NAME, REQUEST_RESPONSE_SOURCE_SYSTEM_NAME,
      REQUEST_RESPONSE_TIMESTAMP_NAME,
      REQUEST_RESPONSE_RECORD_COUNT_NAME } )
@XmlAccessorType( XmlAccessType.FIELD )
public class ResponseMetaData
{

   @ApiModelProperty( name = REQUEST_RESPONSE_IDENTIFIER_NAME, dataType = DATA_TYPE_STRING, position = 1, required = true, notes = REQUEST_RESPONSE_IDENTIFIER_NOTES, example = REQUEST_RESPONSE_IDENTIFIER_EXAMPLE )
   @XmlElement( name = REQUEST_RESPONSE_IDENTIFIER_NAME )
   @SerializedName( value = REQUEST_RESPONSE_IDENTIFIER_NAME )
   @JsonPropertyDescription( REQUEST_RESPONSE_IDENTIFIER_NOTES )
   private String requestIdentifier;
   @ApiModelProperty( name = REQUEST_RESPONSE_SOURCE_SYSTEM_NAME, dataType = DATA_TYPE_STRING, position = 2, required = true, notes = REQUEST_RESPONSE_SOURCE_SYSTEM_NOTES, example = REQUEST_RESPONSE_SOURCE_SYSTEM_EXAMPLE )
   @XmlElement( name = REQUEST_RESPONSE_SOURCE_SYSTEM_NAME )
   @SerializedName( value = REQUEST_RESPONSE_SOURCE_SYSTEM_NAME )
   @JsonPropertyDescription( REQUEST_RESPONSE_SOURCE_SYSTEM_NOTES )
   private String requestSourceSystem;
   @ApiModelProperty( name = REQUEST_RESPONSE_TIMESTAMP_NAME, dataType = DATA_TYPE_STRING, position = 4, required = true, notes = REQUEST_RESPONSE_TIMESTAMP_NOTES, example = REQUEST_RESPONSE_TIMESTAMP_EXAMPLE )
   @XmlElement( name = REQUEST_RESPONSE_TIMESTAMP_NAME )
   @SerializedName( value = REQUEST_RESPONSE_TIMESTAMP_NAME )
   @JsonPropertyDescription( REQUEST_RESPONSE_TIMESTAMP_NOTES )
   private String requestTimeStamp;
   @ApiModelProperty( name = REQUEST_RESPONSE_RECORD_COUNT_NAME, dataType = DATA_TYPE_INT, position = 5, required = true, notes = REQUEST_RESPONSE_RECORD_COUNT_NOTES, example = REQUEST_RESPONSE_RECORD_COUNT_EXAMPLE )
   @XmlElement( name = REQUEST_RESPONSE_RECORD_COUNT_NAME )
   @SerializedName( value = REQUEST_RESPONSE_RECORD_COUNT_NAME )
   @JsonPropertyDescription( REQUEST_RESPONSE_RECORD_COUNT_NOTES )
   private int requestRecordCount;

   @JsonGetter( REQUEST_RESPONSE_IDENTIFIER_NAME )
   public String getRequestIdentifier()
   {
      return requestIdentifier;
   }

   @JsonSetter( REQUEST_RESPONSE_IDENTIFIER_NAME )
   public void setRequestIdentifier( String requestIdentifier )
   {
      this.requestIdentifier = requestIdentifier;
   }

   @JsonGetter( REQUEST_RESPONSE_SOURCE_SYSTEM_NAME )
   public String getRequestSourceSystem()
   {
      return requestSourceSystem;
   }

   @JsonSetter( REQUEST_RESPONSE_SOURCE_SYSTEM_NAME )
   public void setRequestSourceSystem( String requestSourceSystem )
   {
      this.requestSourceSystem = requestSourceSystem;
   }

   @JsonGetter( REQUEST_RESPONSE_TIMESTAMP_NAME )
   public String getRequestTimeStamp()
   {
      return requestTimeStamp;
   }

   @JsonSetter( REQUEST_RESPONSE_TIMESTAMP_NAME )
   public void setRequestTimeStamp( String requestTimeStamp )
   {
      this.requestTimeStamp = requestTimeStamp;
   }

   @JsonGetter( REQUEST_RESPONSE_RECORD_COUNT_NAME )
   public int getRequestRecordCount()
   {
      return requestRecordCount;
   }

   @JsonSetter( REQUEST_RESPONSE_RECORD_COUNT_NAME )
   public void setRequestRecordCount( int requestRecordCount )
   {
      this.requestRecordCount = requestRecordCount;
   }

}
