package com.freddiemac.datamanager.ws.esafe.util;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.*;

public class UUIDGeneratorTest {

   public void setUp() {
   }

   @Test
   public void testUUIDGeneratorTest1()
   {
      
      String testName = "testUUIDGeneratorTest1";

      try {

         UUIDGeneratorUtils theUUIDGenerator = new UUIDGeneratorUtils();
         String str = theUUIDGenerator.generateUniqueId();       
         System.out.println( "In test:'" + testName + "' Number of Bytes::'" + str.length() + "'" );

         assertThat( str.length(), equalTo( 36 ) );
         

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }

}