package com.freddiemac.datamanager.ws.dto;

import org.springframework.http.MediaType;

import com.freddiemac.datamanager.ws.constant.ServiceConstants;

public class HTTPParams
{

   String url;
   String requestMethod;
   String authorization;
   String contentType;
   String userid;
   String securityCode;
   int connectionTimeout;
   int readTimeout;
   int contentLength;
   String contentLanguage;
   boolean useCaches;
   boolean doInput;
   boolean doOutput;
   int minReadTimeOut;
   int maxReadTimeOut;

   public HTTPParams()
   {
      this.url = ServiceConstants.EMPTY_STRING;
      this.requestMethod = ServiceConstants.SERVICE_REQUEST_POST;
      this.authorization = ServiceConstants.SECURITY_NONE;
      this.contentType = MediaType.TEXT_XML_VALUE;
      this.connectionTimeout = -1;
      this.readTimeout = -1;
      this.contentLanguage = ServiceConstants.SERVICE_CONTENT_LANGUAGE_US;
      this.useCaches = Boolean.FALSE;
      this.doInput = Boolean.TRUE;
      this.doOutput = Boolean.TRUE;
      this.minReadTimeOut = -1;
   }

   public int getMaxReadTimeOut()
   {
      return maxReadTimeOut;
   }

   public void setMaxReadTimeOut( int maxReadTimeOut )
   {
      this.maxReadTimeOut = maxReadTimeOut;
   }

   public int getMinReadTimeOut()
   {
      return minReadTimeOut;
   }

   public void setMinReadTimeOut( int minReadTimeOut )
   {
      this.minReadTimeOut = minReadTimeOut;
   }

   public String getUrl()
   {
      return url;
   }

   public void setUrl( String url )
   {
      this.url = url;
   }

   public String getRequestMethod()
   {
      return requestMethod;
   }

   public void setRequestMethod( String requestMethod )
   {
      this.requestMethod = requestMethod;
   }

   public String getAuthorization()
   {
      return authorization;
   }

   public void setAuthorization( String authorization )
   {
      this.authorization = authorization;
   }

   public String getContentType()
   {
      return contentType;
   }

   public void setContentType( String contentType )
   {
      this.contentType = contentType;
   }

   public String getUserid()
   {
      return userid;
   }

   public void setUserid( String userid )
   {
      this.userid = userid;
   }

   public String getSecurityCode()
   {
      return securityCode;
   }

   public void setSecurityCode( String securityCode )
   {
      this.securityCode = securityCode;
   }

   public int getConnectionTimeout()
   {
      return connectionTimeout;
   }

   public void setConnectionTimeout( int connectionTimeout )
   {
      this.connectionTimeout = connectionTimeout;
   }

   public int getReadTimeout()
   {
      return readTimeout;
   }

   public void setReadTimeout( int readTimeout )
   {
      this.readTimeout = readTimeout;
   }

   public int getContentLength()
   {
      return contentLength;
   }

   public void setContentLength( int contentLength )
   {
      this.contentLength = contentLength;
   }

   public String getContentLanguage()
   {
      return contentLanguage;
   }

   public void setContentLanguage( String contentLanguage )
   {
      this.contentLanguage = contentLanguage;
   }

   public boolean isUseCaches()
   {
      return useCaches;
   }

   public void setUseCaches( boolean useCaches )
   {
      this.useCaches = useCaches;
   }

   public boolean isDoInput()
   {
      return doInput;
   }

   public void setDoInput( boolean doInput )
   {
      this.doInput = doInput;
   }

   public boolean isDoOutput()
   {
      return doOutput;
   }

   public void setDoOutput( boolean doOutput )
   {
      this.doOutput = doOutput;
   }

   @Override
   public String toString()
   {
      return "HTTPParams [url=" + url + ", requestMethod=" + requestMethod + ", authorization=" + authorization + ", contentType=" + contentType + ", userid=" + userid + ", securityCode="
            + securityCode + ", connectionTimeout=" + connectionTimeout + ", readTimeout=" + readTimeout + ", contentLength=" + contentLength + ", contentLanguage=" + contentLanguage + ", useCaches="
            + useCaches + ", doInput=" + doInput + ", doOutput=" + doOutput + ", minReadTimeOut=" + minReadTimeOut + ", maxReadTimeOut="
            + maxReadTimeOut + "]";
   }

}
