package com.freddiemac.datamanager.ws.esafe.util;

public class NumberUtils
{

   private NumberUtils()
   {
   }

   /**
    * Checks whether the data is valid numeric value
    * 
    * @param data is a instance of String class
    * @return true in case of number otherwise false
    */
   public static boolean validateNumericData( String data )
   {

      boolean resultFlag = Boolean.FALSE;

      if( StringUtils.doesValueExist( data ) ) {
         data = data.trim();
         resultFlag = data.chars()
               .allMatch( Character::isDigit );
      }

      return resultFlag;

   }

   /**
    * Checks whether the data is valid non zero long numeric value
    * 
    * @param data is a instance of String class
    * @return true in case of number otherwise false
    */
   public static boolean validateNonZeroLongData( String data )
   {

      boolean resultFlag = NumberUtils.validateNumericData( data );

      if( resultFlag ) {
         data = data.trim();
         if( Long.parseLong( data ) == 0 ) {
            resultFlag = Boolean.FALSE;
         }
      }

      return resultFlag;

   }

}
