package com.freddiemac.datamanager.ws.esafe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;

public final class StringUtils
{

   private StringUtils()
   {
   }

   public static String concatStrings( String data, String concatData, String concatenatedType )
   {

      String concatenatedData = EsafeConstants.EMPTY_STRING;

      switch( concatenatedType )
      {
         case EsafeConstants.CONCATENATED_PREFIX:
            concatenatedData = concatData.concat( data );
            break;
         case EsafeConstants.CONCATENATED_SUFFIX:
            concatenatedData = data.concat( concatData );
            break;
         default:
            break;
      }

      return concatenatedData;

   }

   public static String getSubStringFromStartIndex( final String data, int startIndex )
   {
      return data.length() > startIndex ? data.substring( startIndex ) : data;
   }

   public static String getTruncatedString( final String data, int maxLength )
   {
      return data.length() > maxLength ? data.substring( 0, maxLength ) : data;
   }

   public static String getMaskedString( final String data )
   {

      String encodedString = EsafeConstants.EMPTY_STRING;

      if( StringUtils.isNotNull( data ) ) {
         encodedString = Base64Utils.encode( data );
      }

      return encodedString;

   }

   public static boolean isNum( final String data )
   {

      boolean numericFlag = Boolean.TRUE;

      try {
         Double.parseDouble( data );
      }
      catch( NumberFormatException nfe ) {
         numericFlag = Boolean.FALSE;
      }

      return numericFlag;

   }

   public static boolean doesValueExist( String data )
   {

      boolean doesValueExistFlag = Boolean.FALSE;

      if( GeneralUtils.doesObjectExist( data ) && !data.trim().isEmpty() ) {
         doesValueExistFlag = Boolean.TRUE;
      }

      return doesValueExistFlag;

   }

   public static boolean isValueEmpty( String data )
   {
      return !StringUtils.doesValueExist( data );
   }

   /**
    * Checks whether the String contains a not null value
    * 
    * @param possibleValue is a instance of String class.
    * @return returnValue is true in case of possibleValue is not null otherwise false
    */
   public static boolean isNotNull( String data )
   {

      boolean notNullFlag = Boolean.FALSE;

      if( GeneralUtils.doesObjectExist( data ) ) {
         notNullFlag = Boolean.TRUE;
      }

      return notNullFlag;

   }

   /**
    * Checks whether the String contains null value
    * 
    * @param possibleValue is a instance of String class.
    * @return returnValue is true in case of possibleValue is null otherwise false
    */
   public static boolean isNull( String data )
   {

      boolean nullFlag = Boolean.FALSE;

      if( GeneralUtils.isNullObject( data ) ) {
         nullFlag = Boolean.TRUE;
      }

      return nullFlag;

   }

   // if inputValue has valid value, and outputValue is null or empty, return true
   // used to update keys, only if nothing currently exists
   public static boolean doesNewDataExist( String inputData, String outputData )
   {

      boolean newDataExistFlag = Boolean.FALSE;

      if( StringUtils.doesValueExist( inputData ) && StringUtils.isValueEmpty( outputData ) ) {
         newDataExistFlag = Boolean.TRUE;
      }

      return newDataExistFlag;

   }

   /**
    * Validate the data length is greater than the maximum length
    * 
    * @param data is the value that will be validated
    * @param maxLength is the maximum length of the data
    * @return errorFlag based upon the data length validation
    */
   public static boolean validateDataLengthExceedsMaxLength( String data, int maxLength )
   {
      boolean errorFlag = Boolean.TRUE;
      if( StringUtils.isNotNull( data ) && data.length() > maxLength ) {
         errorFlag = Boolean.FALSE;
      }
      return errorFlag;
   }

   // if inputValue has valid value, and different than outputValue, return true
   // used to update fields, if something changed
   public static boolean doesDifferentDataExist( String inputData, String outputData, boolean caseSensitiveFlag )
   {

      boolean differentDataExistFlag = Boolean.FALSE;

      if( StringUtils.doesValueExist( inputData ) ) {

         // so we have some data in input, check to see if target output is null, or
         // different
         if( StringUtils.doesValueExist( outputData ) ) {

            if( !internalDoValuesMatch( inputData, outputData, caseSensitiveFlag ) ) {
               differentDataExistFlag = Boolean.TRUE;
            }
         }
         else {
            differentDataExistFlag = Boolean.TRUE;
         }
      }

      return differentDataExistFlag;
      
   }

   // if inputValue conflicts with outputValue, return true
   // conflict means the input has a non-empty value and the database has non-empty
   // value and they are different.
   // if input has value but database has empty -> no conflict
   // if input has empty value but database has a value -> no conflict
   // if input has a value and database has a value -> possible conflict -> if
   // different conflict
   public static boolean doesDataConflict( String inputData, String outputData, boolean caseSensitiveFlag )
   {

      boolean dataConflictFlag = Boolean.FALSE;

      // so we have some data in inputData and outputData, check to see if inputData conflict with target outputData
      if( StringUtils.doesValueExist( inputData ) && StringUtils.doesValueExist( outputData ) &&
            !StringUtils.internalDoValuesMatch( inputData, outputData, caseSensitiveFlag ) ) {
         dataConflictFlag = Boolean.TRUE;
      }

      return dataConflictFlag;

   }

   public static boolean doValuesMatch( String leftValue, String rightValue, boolean caseSensitiveFlag )
   {

      boolean valuesMatchFlag = Boolean.FALSE;

      if( StringUtils.doesValueExist( leftValue ) && StringUtils.doesValueExist( rightValue ) &&
            StringUtils.internalDoValuesMatch( leftValue, rightValue, caseSensitiveFlag ) ) {
         valuesMatchFlag = Boolean.TRUE;
      }

      return valuesMatchFlag;

   }

   public static boolean doValuesMatchForChars( String leftValue, String rightValue, int countCharsToMatch,
         boolean caseSensitiveFlag )
   {

      boolean valuesMatchForCharsFlag = Boolean.FALSE;

      if( ( StringUtils.doesValueExist( leftValue ) ) && ( StringUtils.doesValueExist( rightValue ) ) ) {

         String leftSubString = leftValue.trim().substring( 0, Math.min( leftValue.length(), countCharsToMatch ) );
         String rightSubString = rightValue.trim().substring( 0, Math.min( rightValue.length(), countCharsToMatch ) );

         if( internalDoValuesMatch( leftSubString, rightSubString, caseSensitiveFlag ) ) {
            valuesMatchForCharsFlag = Boolean.TRUE;
         }

      }

      return valuesMatchForCharsFlag;

   }

   // used for exact compare, so if null on one side needs to be null on other.
   public static boolean doValuesExactMatch( String leftValue, String rightValue, boolean caseSensitiveFlag )
   {

      boolean valuesExactMatchFlag = Boolean.FALSE;

      if( StringUtils.doesValueExist( leftValue ) ) {

         if( StringUtils.doesValueExist( rightValue ) ) {

            // left has value - right has value
            if( internalDoValuesMatch( leftValue, rightValue, caseSensitiveFlag ) ) {
               valuesExactMatchFlag = Boolean.TRUE;
            }
         }

         else {
            // left has value - right has no value
         }
      }
      else {
         if( StringUtils.doesValueExist( rightValue ) ) {

            // left has no value - right has value
         }
         else {

            // left has no value - right has no value
            valuesExactMatchFlag = Boolean.TRUE;
         }
      }

      return valuesExactMatchFlag;

   }

   // asumes values exist, includes the trim
   private static boolean internalDoValuesMatch( String leftValue, String rightValue, boolean caseSensitiveFlag )
   {

      boolean internalDoValuesMatchFlag = Boolean.FALSE;

      if( caseSensitiveFlag ) {
         if( leftValue.trim().equals( rightValue.trim() ) ) {
            internalDoValuesMatchFlag = Boolean.TRUE;
         }
      }
      else {
         if( leftValue.trim().equalsIgnoreCase( rightValue.trim() ) ) {
            internalDoValuesMatchFlag = Boolean.TRUE;
         }
      }

      return internalDoValuesMatchFlag;

   }

   /**
    * String Find & Replace using Pattern Matching
    * @param searchPattern is a instance of String class
    * @param searchText is a instance of String class
    * @param replaceText is a instance of String class
    * @return data is a instance of String class
    */
   public static String doValuesFindReplace( String searchPattern, String searchText, String replaceText )
   {

      Pattern pattern = Pattern.compile( searchPattern );
      Matcher matcher = pattern.matcher( searchText );
      
      return matcher.replaceAll( replaceText );

   }

   /**
    * Converts the value to uppercase and also removes the leading and trailing spaces in the value
    * 
    * @param value is a instance of String class
    * @return the result which is a instance of String class
    */
   public static String doTrimPlusUpperCase( String data )
   {

      if( GeneralUtils.doesObjectExist( data ) )
         return data.trim().toUpperCase();

      return null;

   }

   public static String formatMessage( final String format, Object... objects )
   {
      return String.format( format, objects );
   }

   public static String repeat( final String data, final int length ) 
   {
      return new String(new char[length]).replace( "\0", data );
   }
   
   public static String replaceSubStringUsingSizeLimit( final String data, final String replaceData ) 
   {
      return data.substring( 0, data.length() - replaceData.length() ).concat( replaceData );
   }
   
}
