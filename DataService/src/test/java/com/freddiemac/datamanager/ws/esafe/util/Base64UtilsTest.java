package com.freddiemac.datamanager.ws.esafe.util;

import com.freddiemac.datamanager.ws.esafe.util.Base64Utils;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Base64UtilsTest {

   @Test
   public void testBase64UtilsTest1() {
      
      String testName = "testCollectionUtilsTest1";

      try {

         String ssn = "64734349";
         String maskedSSN = "NjQ3MzQzNDk=";
         
         String encodedVlaue = Base64Utils.encode( ssn );
         System.out.println( "In test:'" + testName + "' encoded:'" + encodedVlaue + "'" );
         assertThat( encodedVlaue, equalTo( maskedSSN ) );

         
         String decodeValue = Base64Utils.decode( encodedVlaue );
         System.out.println( "In test:'" + testName + "' decoded:'" + decodeValue + "'" );
         assertThat( decodeValue, equalTo( ssn ) );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }


}
