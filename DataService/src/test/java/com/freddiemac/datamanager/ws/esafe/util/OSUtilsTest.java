package com.freddiemac.datamanager.ws.esafe.util;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.freddiemac.datamanager.ws.constant.TestConstants;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.*;

public class OSUtilsTest {

   @Test
   public void testOSUtilsTest1()
   {
      
      String testName = "testOSUtilsTest1";

      try {
         OSUtils osUtils = OSUtils.getInstance();
         
         String hostName = osUtils.getHostName();
         String userName = osUtils.getUserName();         
         
         System.out.println( "In test:'" + testName + "' hostName:'" + hostName + "' userName:'" + userName + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testOSUtilsTest2()
   {
      
      String testName = "testOSUtilsTest2";

      try {
         OSUtils osUtils = OSUtils.getInstance();
         ReflectionTestUtils.setField( osUtils, "appHostName", null );
         
         String hostName = osUtils.getHostName();
         
         System.out.println( "In test:'" + testName + "' hostName:'" + hostName + "'" );
         assertThat( hostName, equalTo( EsafeConstants.PROPERTY_VALUE_UNKNOWN ) );
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testOSUtilsTest3()
   {
      
      String testName = "testOSUtilsTest3";

      try {
         OSUtils osUtils = OSUtils.getInstance();
         ReflectionTestUtils.setField( osUtils, "appUserName", null );
         
         String userName = osUtils.getUserName();
         
         System.out.println( "In test:'" + testName + "' UserName:'" + userName + "'" );
         assertThat( userName, equalTo( EsafeConstants.PROPERTY_VALUE_UNKNOWN ) );
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
   @Test
   public void testOSUtilsTest4()
   {
      
      String testName = "testOSUtilsTest4";

      try {
         OSUtils osUtils = OSUtils.getInstance();
         ReflectionTestUtils.setField( osUtils, "appUserName", TestConstants.EMPTY_STRING );
         ReflectionTestUtils.setField( osUtils, "userPropertyName", "garabage" );
         
         String userName = osUtils.getUserName();
         
         System.out.println( "In test:'" + testName + "' UserName:'" + userName + "'" );
         assertThat( userName, equalTo( EsafeConstants.PROPERTY_VALUE_UNKNOWN ) );
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }
   
}