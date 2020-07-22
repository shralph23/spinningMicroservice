package com.freddiemac.datamanager.ws.esafe.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.freddiemac.datamanager.ws.esafe.util.DecodeAwarePropertyPlaceholderConfigurer;


public class DecodeAwarePropertyPlaceholderConfigurerTest
{

   @Test
   public void testDecodeAwarePropertyPlaceholderConfigurerTest()
   {
      DecodeAwarePropertyPlaceholderConfigurer obj = new DecodeAwarePropertyPlaceholderConfigurer();
      String decodedValue = obj.convertPropertyValue( "DECODE-JunitTest" );
      assertNotNull( decodedValue );
      String noDecode = obj.convertPropertyValue( "JunitTest" );
      assertEquals( "JunitTest", noDecode );

   }

}
