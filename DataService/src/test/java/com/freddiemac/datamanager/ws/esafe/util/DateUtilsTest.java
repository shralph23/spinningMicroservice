package com.freddiemac.datamanager.ws.esafe.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import com.freddiemac.datamanager.ws.esafe.util.DateUtils;

import static com.freddiemac.datamanager.ws.constant.TestConstants.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

public class DateUtilsTest
{

   @Test
   public void testDateUtilsTest1()
   {

      String testName = "testDateUtilsTest1";

      try {

         System.out.println( "In test:'" + testName + "' Current Timestamp:'" + DateUtils.getCurrentTimestamp() + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }

   @Test
   public void testDateUtilsTest2()
   {

      String testName = "testDateUtilsTest2";

      try {

         String currentTimestamp = DateUtils.convertCurrentTimestampToStringBySimpleDateFormat( STRING_DATE_TIME_FORMAT );
         System.out.println( "In test:'" + testName + "' Current Timestamp:'" + currentTimestamp + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }

   @Test
   public void testDateUtilsTest3()
   {

      String testName = "testDateUtilsTest3";

      try {

         System.out.println( "In test:'" + testName + "' Current Midnight Timestamp:'" + DateUtils.getMidnightCurrentTimestamp() + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
   
   @Test
   public void testDateUtilsTest4()
   {

      String testName = "testDateUtilsTest4";

      try {

         System.out.println( "In test:'" + testName + "' Minus 0 Hours Current Timestamp:'" + DateUtils.getCurrentTimestampMinusDuration( DEFAULT, 0 ) + "'" );
         System.out.println( "In test:'" + testName + "' Minus 3 Hours Current Timestamp:'" + DateUtils.getCurrentTimestampMinusDuration( HOURS, 3 ) + "'" );
         System.out.println( "In test:'" + testName + "' Minus 30 Minutes Current Timestamp:'" + DateUtils.getCurrentTimestampMinusDuration( MINUTES, 30 ) + "'" );
         System.out.println( "In test:'" + testName + "' Minus 300 Seconds Current Timestamp:'" + DateUtils.getCurrentTimestampMinusDuration( SECONDS, 300 ) + "'" );
         System.out.println( "In test:'" + testName + "' Minus 3000 Milliseconds Current Timestamp:'" + DateUtils.getCurrentTimestampMinusDuration( MILLISECONDS, 3000 ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
   
   @Test
   public void testDateUtilsTest5()
   {

      String testName = "testDateUtilsTest5";

      try {

         System.out.println( "In test:'" + testName + "' Plus 0 Hours Current Timestamp:'" + DateUtils.getCurrentTimestampPlusDuration( DEFAULT, 0 ) + "'" );
         System.out.println( "In test:'" + testName + "' Plus 3 Hours Current Timestamp:'" + DateUtils.getCurrentTimestampPlusDuration( HOURS, 3 ) + "'" );
         System.out.println( "In test:'" + testName + "' Plus 30 Minutes Current Timestamp:'" + DateUtils.getCurrentTimestampPlusDuration( MINUTES, 30 ) + "'" );
         System.out.println( "In test:'" + testName + "' Plus 300 Seconds Current Timestamp:'" + DateUtils.getCurrentTimestampPlusDuration( SECONDS, 300 ) + "'" );
         System.out.println( "In test:'" + testName + "' Plus 3000 Milliseconds Current Timestamp:'" + DateUtils.getCurrentTimestampPlusDuration( MILLISECONDS, 3000 ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
  
   @Test
   public void testDateUtilsTest6()
   {

      String testName = "testDateUtilsTest6";

      try {

         Timestamp sourceTimestamp = DateUtils.getCurrentTimestamp(); 
         System.out.println( "In test:'" + testName + "' Cloned Timestampr:'" + DateUtils.cloneTimestamp( sourceTimestamp ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
   
   @Test
   public void testDateUtilsTest7()
   {

      String testName = "testDateUtilsTest7";

      try {

         XMLGregorianCalendar gregorianCalendar = DateUtils.getCurrentXMLGregorianCalendar();

         System.out.println( "In test:'" + testName + "' Timestamp from Gregorian Calender:'" + DateUtils.getTimestampFromXMLGregorianCalendar( gregorianCalendar ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
   
   @Test
   public void testDateUtilsTest8()
   {

      String testName = "testDateUtilsTest8";

      try {

         System.out.println( "In test:'" + testName + "' Current Gregorian Calender:'" + DateUtils.getCurrentXMLGregorianCalendar() + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }

   @Test
   public void testDateUtilsTest9()
   {

      String testName = "testDateUtilsTest9";

      try {

         XMLGregorianCalendar gregorianCalendar = DateUtils.getCurrentXMLGregorianCalendar();
         java.sql.Timestamp timestamp = DateUtils.getTimestampFromXMLGregorianCalendar( gregorianCalendar );

         System.out.println( "In test:'" + testName + "' Gregorian Calender from Timestamp:'" + DateUtils.getXMLGregorianCalendarFromTimestamp( timestamp ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }

   @Test
   public void testDateUtilsTest10()
   {

      String testName = "testDateUtilsTest10";

      try {

         Date data = new Date();

         XMLGregorianCalendar xmlGregorianCalendar = DateUtils.getXMLGregorianCalendarFromDate( data );
         System.out.println( "In test:'" + testName + "' Gregorian Calender from Date:'" + xmlGregorianCalendar + "'" );
         assertThat( xmlGregorianCalendar, notNullValue() );
         
         xmlGregorianCalendar = DateUtils.getXMLGregorianCalendarFromDate( null );
         System.out.println( "In test:'" + testName + "' Gregorian Calender from Date:'" + xmlGregorianCalendar + "'" );
         assertThat( xmlGregorianCalendar, nullValue() );
         
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }

   @Test
   public void testDateUtilsTest11()
   {

      String testName = "testDateUtilsTest11";

      try {

         long startTime = 1000;
         System.out.println( "In test:'" + testName + "' Elapsed time:'" + DateUtils.getElapseTime( startTime ) + "'" );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );

   }
   
}