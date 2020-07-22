package com.freddiemac.datamanager.ws.esafe.util;

import javax.xml.bind.DatatypeConverter;

public class Base64Utils {

   private Base64Utils() {
   }

   public static String encode( String decoded ) {
      // encode data using BASE64
      return DatatypeConverter.printBase64Binary( decoded.getBytes() );
      
   }

   public static String decode( String encoded ) {
      
      return new String( DatatypeConverter.parseBase64Binary( encoded ) );
      
   }

}
