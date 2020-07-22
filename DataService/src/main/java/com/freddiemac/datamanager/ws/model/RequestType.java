/**
 * 
 */
package com.freddiemac.datamanager.ws.model;

import static com.freddiemac.datamanager.ws.constant.ModelConstants.DATA_TYPE_LIST_SUBMISSION_REQUEST_TYPE;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.DATA_TYPE_REQUEST_METADATA_TYPE;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.DATA_TYPE_REQUEST_TYPE;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_DESCRIPTION;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_METADATA_NAME;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_META_DATA_NOTES;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_SUBMISSIONS_NAME;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_SUBMISSIONS_NOTES;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.REQUEST_RESPONSE_SUBMISSION_NAME;
import static com.freddiemac.datamanager.ws.constant.ModelConstants.SUBMN_REQUEST_DESCRIPTION;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.freddiemac.datamanager.ws.esafe.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = DATA_TYPE_REQUEST_TYPE, description = REQUEST_DESCRIPTION)
@JsonPropertyOrder({REQUEST_METADATA_NAME, REQUEST_RESPONSE_SUBMISSIONS_NAME})
@XmlRootElement(name = DATA_TYPE_REQUEST_TYPE)
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestType
{
   
   @ApiModelProperty(name = REQUEST_METADATA_NAME, dataType = DATA_TYPE_REQUEST_METADATA_TYPE, position = 1, required = true, notes = REQUEST_RESPONSE_META_DATA_NOTES)
   @XmlElement(name = REQUEST_METADATA_NAME)
   @SerializedName(value = REQUEST_METADATA_NAME)
   @JsonPropertyDescription(REQUEST_RESPONSE_META_DATA_NOTES)
   private RequestMetaData requestMetadata;   
   @ApiModelProperty(value = REQUEST_RESPONSE_SUBMISSIONS_NAME, dataType = DATA_TYPE_LIST_SUBMISSION_REQUEST_TYPE, position = 2, required = true, notes = SUBMN_REQUEST_DESCRIPTION)
   @XmlElementWrapper(name = REQUEST_RESPONSE_SUBMISSIONS_NAME)
   @XmlElement(name = REQUEST_RESPONSE_SUBMISSION_NAME)
   @SerializedName(value = REQUEST_RESPONSE_SUBMISSIONS_NAME)
   @JsonPropertyDescription(REQUEST_RESPONSE_SUBMISSIONS_NOTES)
   private List<String> submissions;
   
   @JsonGetter(REQUEST_METADATA_NAME)
   public RequestMetaData getRequestMetadata()
   {
      return requestMetadata;
   }

   @JsonSetter(REQUEST_METADATA_NAME)
   public void setRequestMetadata( RequestMetaData requestMetadata )
   {
      this.requestMetadata = requestMetadata;
   }
   
   @JsonGetter(REQUEST_RESPONSE_SUBMISSIONS_NAME)
   public List<String> getSubmissions()
   {
      return submissions;
   }

   @JsonSetter(REQUEST_RESPONSE_SUBMISSIONS_NAME)
   public void setSubmissions( List<String> submissions )
   {
      if ( CollectionUtils.doesCollectionContainsValue( submissions ) )
         this.submissions = submissions;
      else
         this.submissions = new ArrayList<>();
   }
}
