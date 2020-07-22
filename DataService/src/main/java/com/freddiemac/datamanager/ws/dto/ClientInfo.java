package com.freddiemac.datamanager.ws.dto;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.freddiemac.datamanager.ws.esafe.util.GeneralUtils;
import com.freddiemac.datamanager.ws.esafe.util.StringUtils;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.*;

public class ClientInfo
{

   String mapEntryName = EMPTY_STRING;
   String host = EMPTY_STRING;
   String userAgent = EMPTY_STRING;
   String userName = EMPTY_STRING;
   String clientIP = EMPTY_STRING;
   String contentType = EMPTY_STRING;

   public ClientInfo( Map< String, String > headers, HttpServletRequest httpRequest )
   {
      this.mapEntryName = EMPTY_STRING;
      if( GeneralUtils.doesObjectExist( httpRequest ) ) {
         this.host = httpRequest.getServerName();
         if( StringUtils.isNull( this.host ) ) {
            this.host = httpRequest.getRemoteHost();
         }
      }
      this.userAgent = headers.get( SERVICE_USER_AGENT );
      this.userName = EMPTY_STRING;
      this.clientIP = headers.get( SERVICE_IP_ADDRESS );
      this.contentType = headers.get( SERVICE_CONTENT_TYPE );
   }

   public String getMapEntryName()
   {
      return mapEntryName;
   }

   public void setMapEntryName( String mapEntryName )
   {
      this.mapEntryName = mapEntryName;
   }

   public String getHost()
   {
      return host;
   }

   public void setHost( String host )
   {
      this.host = host;
   }

   public String getUserAgent()
   {
      return userAgent;
   }

   public void setUserAgent( String userAgent )
   {
      this.userAgent = userAgent;
   }

   public String getUserName()
   {
      return userName;
   }

   public void setUserName( String userName )
   {
      this.userName = userName;
   }

   public String getClientIP()
   {
      return clientIP;
   }

   public void setClientIP( String clientIP )
   {
      this.clientIP = clientIP;
   }

   public String getContentType()
   {
      return contentType;
   }

   public void setContentType( String contentType )
   {
      this.contentType = contentType;
   }

   @Override
   public String toString()
   {
      return "ClientInfo [mapEntryName=" + mapEntryName + ", host=" + host + ", userAgent=" + userAgent + ", userName=" + userName + ", contentType=" + contentType
            + ", clientIP=" + clientIP + "]";
   }

}
