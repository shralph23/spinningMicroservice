package com.freddiemac.datamanager.ws.esafe.util;

import org.junit.Test;

import com.freddiemac.datamanager.ws.enums.LogLevel;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.util.LogUtils;

import static org.junit.Assert.assertTrue;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX;

public class LogUtilsTest
{

   @Test
   public void testLogUtilsTest1()
   {

      String testName = "testLogUtilsTest1";

      try {

         String errorMessage = "Request metadata record count does not match the Submissions received in the request - RequestRecordCount:'10' - SubmissionsCount:'11'";

         LogUtils.logServiceMessage( LogLevel.UNKNOWN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );
         
         LogUtils.logServiceMessage( LogLevel.TRACE, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );

         LogUtils.logServiceMessage( LogLevel.DEBUG, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );

         LogUtils.logServiceMessage( LogLevel.INFO, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );

         LogUtils.logServiceMessage( LogLevel.WARN, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );

         LogUtils.logServiceMessage( LogLevel.ERROR, MESSAGE_REQUEST_ERRORCODE_ERRORMSG_PREFIX_PLUS_POSFIX,
               EsafeErrorCodes.EC_SRS_BAD_REQUEST, errorMessage );

      }
      catch( Exception e ) {
         System.out.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
   }

}