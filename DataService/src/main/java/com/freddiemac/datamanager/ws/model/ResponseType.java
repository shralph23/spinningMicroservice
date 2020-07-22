/**
 * 
 */
package com.freddiemac.datamanager.ws.model;

import static com.freddiemac.datamanager.ws.constant.ModelConstants.DATA_TYPE_RESPONSE_METADATA_TYPE;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.DATA_TYPE_RESPONSE_TYPE;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_META_DATA_NOTES;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_SUBMISSIONS_NAME;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.RESPONSE_METADATA_DESCRIPTION;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.RESPONSE_METADATA_NAME;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = DATA_TYPE_RESPONSE_TYPE, description = RESPONSE_METADATA_DESCRIPTION )
@JsonPropertyOrder( { RESPONSE_METADATA_NAME, REQUEST_RESPONSE_SUBMISSIONS_NAME } )
@XmlRootElement( name = DATA_TYPE_RESPONSE_TYPE )
@XmlAccessorType( XmlAccessType.FIELD )
public class ResponseType
{

   @ApiModelProperty( name = RESPONSE_METADATA_NAME, dataType = DATA_TYPE_RESPONSE_METADATA_TYPE, position = 1, required = true, notes = REQUEST_RESPONSE_META_DATA_NOTES )
   @XmlElement( name = RESPONSE_METADATA_NAME )
   @SerializedName( value = RESPONSE_METADATA_NAME )
   @JsonPropertyDescription( REQUEST_RESPONSE_META_DATA_NOTES )
   private ResponseMetaData responseMetadata;  

   @JsonGetter( RESPONSE_METADATA_NAME )
   public ResponseMetaData getResponseMetadata()
   {
      return responseMetadata;
   }

   @JsonSetter( RESPONSE_METADATA_NAME )
   public void setResponseMetadata( ResponseMetaData responseMetadata )
   {
      this.responseMetadata = responseMetadata;
   }
}
