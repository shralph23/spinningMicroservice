package com.freddiemac.datamanager.ws.esafe.util;

import org.junit.Test;

import com.freddiemac.datamanager.ws.constant.TestConstants;
import com.freddiemac.datamanager.ws.esafe.util.PropertiesUtils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class PropertiesUtilsTest
{

   @Test
   public void testPropertiesUtilsTest1() {
      
      String testName = "testSRSAppPropertiesTest1";
     
      try {
         
         Boolean defaultPropertyValue = Boolean.FALSE;
         String propertyName = "SLS_LOG_REQUEST_FLAG";
         boolean propertyValue = Boolean.FALSE;
         boolean logPropertyFlag = Boolean.TRUE;
         
         Boolean logRequestFlag = PropertiesUtils.getBooleanProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( logRequestFlag, equalTo( propertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + logRequestFlag + "'" );
         
      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest2() {
      
      String testName = "testSRSAppPropertiesTest2";
     
      try {
         
         Boolean defaultPropertyValue = Boolean.FALSE;
         String propertyName = "SLS_LOG_REQUEST_FLAG";
         boolean propertyValue = Boolean.FALSE;
         boolean logPropertyFlag = Boolean.FALSE;
         
         Boolean logRequestFlag = PropertiesUtils.getBooleanProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( logRequestFlag, equalTo( propertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + logRequestFlag + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest3() {
      
      String testName = "testSRSAppPropertiesTest3";
     
      try {
         
         Boolean defaultPropertyValue = Boolean.FALSE;
         String propertyName = "SLS_LOG_RESPONSE_FLAG";
         boolean propertyValue = Boolean.TRUE;
         boolean logPropertyFlag = Boolean.TRUE;
         
         Boolean logRequestFlag = PropertiesUtils.getBooleanProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( logRequestFlag, equalTo( propertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + logRequestFlag + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest4() {
      
      String testName = "testPropertiesUtilsTest4";
     
      try {
         
         int defaultPropertyValue = 1000;
         String propertyName = "SLS_SUBMISSION_QUERY_FETCH_LIMIT";
         int propertyValue = 0;
         boolean logPropertyFlag = Boolean.FALSE;
         
         int slsSubmissionQueryFetchLimit = PropertiesUtils.getIntProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSubmissionQueryFetchLimit, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSubmissionQueryFetchLimit + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest5() {
      
      String testName = "testPropertiesUtilsTest5";
     
      try {
         
         int defaultPropertyValue = 1000;
         String propertyName = "SLS_SUBMISSION_QUERY_FETCH_LIMIT";
         int propertyValue = 0;
         boolean logPropertyFlag = Boolean.TRUE;
         
         int slsSubmissionQueryFetchLimit = PropertiesUtils.getIntProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSubmissionQueryFetchLimit, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSubmissionQueryFetchLimit + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest6() {
      
      String testName = "testPropertiesUtilsTest6";
     
      try {
         
         int defaultPropertyValue = 0;
         String propertyName = "SLS_SUBMISSION_QUERY_FETCH_CEILING_LIMIT";
         int propertyValue = 50000;
         boolean logPropertyFlag = Boolean.TRUE;
         
         int slsSubmissionQueryFetchLimit = PropertiesUtils.getIntProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSubmissionQueryFetchLimit, equalTo( propertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSubmissionQueryFetchLimit + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest7() {
      
      String testName = "testPropertiesUtilsTest7";
     
      try {
         
         String defaultPropertyValue = "Basic";
         String propertyName = "SLMS_AUTHENTICATION_METHOD";
         String propertyValue = TestConstants.EMPTY_STRING;
         boolean logPropertyFlag = Boolean.TRUE;
         
         String slmsAuthenticationMethod = PropertiesUtils.getStringProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slmsAuthenticationMethod, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slmsAuthenticationMethod + "'" );
         
      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest8() {
      
      String testName = "testPropertiesUtilsTest8";
     
      try {
         
         String defaultPropertyValue = "Basic";
         String propertyName = "SLMS_AUTHENTICATION_METHOD";
         String propertyValue = "Basic";
         boolean logPropertyFlag = Boolean.TRUE;
         
         String slmsAuthenticationMethod = PropertiesUtils.getStringProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slmsAuthenticationMethod, equalTo( propertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slmsAuthenticationMethod + "'" );
         
      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest9() {
      
      String testName = "testPropertiesUtilsTest9";
     
      try {
         
         long defaultPropertyValue = 900000L;
         String propertyName = "SLS_SLA_MAX_SUBMISSION_THRESHOLD";
         long propertyValue = 0;
         boolean logPropertyFlag = Boolean.FALSE;
         
         long slsSlaMaxSubmissionThreshold = PropertiesUtils.getLongProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSlaMaxSubmissionThreshold, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSlaMaxSubmissionThreshold + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest10() {
      
      String testName = "testPropertiesUtilsTest10";
     
      try {
         
         long defaultPropertyValue = 900000L;
         String propertyName = "SLS_SLA_MAX_SUBMISSION_THRESHOLD";
         long propertyValue = 0;
         boolean logPropertyFlag = Boolean.TRUE;
         
         long slsSlaMaxSubmissionThreshold = PropertiesUtils.getLongProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSlaMaxSubmissionThreshold, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSlaMaxSubmissionThreshold + "'" );
         
      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest11() {
      
      String testName = "testPropertiesUtilsTest11";
     
      try {
         
         long defaultPropertyValue = 900000L;
         String propertyName = "SLS_SLA_MAX_SUBMISSION_THRESHOLD";
         long propertyValue = 900000L;
         boolean logPropertyFlag = Boolean.FALSE;
         
         long slsSlaMaxSubmissionThreshold = PropertiesUtils.getLongProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSlaMaxSubmissionThreshold, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSlaMaxSubmissionThreshold + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testPropertiesUtilsTest12() {
      
      String testName = "testPropertiesUtilsTest12";
     
      try {
         
         long defaultPropertyValue = 900000L;
         String propertyName = "SLS_SLA_MAX_SUBMISSION_THRESHOLD";
         long propertyValue = 900000L;
         boolean logPropertyFlag = Boolean.TRUE;
         
         long slsSlaMaxSubmissionThreshold = PropertiesUtils.getLongProperty( defaultPropertyValue, propertyName, propertyValue, logPropertyFlag );
         
         assertThat( slsSlaMaxSubmissionThreshold, equalTo( defaultPropertyValue ) );
         
         System.out.println( "In test:'" + testName + "' PropertyName:'" + propertyName + "' PropertyValue:'" + slsSlaMaxSubmissionThreshold + "'" );

      } 
      catch (Exception e) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      
      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
}
