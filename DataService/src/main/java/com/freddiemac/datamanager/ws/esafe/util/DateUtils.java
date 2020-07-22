package com.freddiemac.datamanager.ws.esafe.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;

import static com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants.*;

public final class DateUtils
{

   private static final Logger LOGGER = LoggerFactory.getLogger( DateUtils.class );

   private DateUtils()
   {
   }

   /**
    * Method return the current date and time in the format - 2020-02-10 18:53:31.523 as the current date and time - 2020-02-10 18:53:31.523
    * 
    * @return currentTimestamp is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getCurrentTimestamp()
   {

      java.sql.Timestamp currentTimestamp = null;

      // 1) create a java calendar instance
      Calendar calendar = Calendar.getInstance();

      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current time (now) instance
      currentTimestamp = new java.sql.Timestamp( now.getTime() );

      return currentTimestamp;

   }

   /**
    * Converts the Timestamp to the required format(i.e. "MM-dd-yyyy HH:mm:ss:SSS" ) as a String class
    * 
    * @param dateFormat is a instance of String class
    * @return timestamp is a instance of String class
    */
   public static String convertCurrentTimestampToStringBySimpleDateFormat( String dateFormat )
   {

      SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );

      return sdf.format( DateUtils.getCurrentTimestamp() );

   }

   /**
    * Converts the object to the required format(i.e. "MM-dd-yyyy HH:mm:ss:SSS" ) as a String class
    * 
    * @param timestamp is a instance of java.sql.Timestamp class
    * @param dateFormat is a instance of String class
    * @return timestamp is a instance of String class
    */
   public static String convertObjectToStringBySimpleDateFormat( Object object, String dateFormat )
   {

      SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );

      return sdf.format( object );

   }

   /**
    * Method return the current date and time(i.e. 12AM) in the format - 2020-02-10 00:00:00.0 even though the current date and
    * time is 2020-02-10 18:53:31.523
    * 
    * @return midnightCurrentTimestamp is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getMidnightCurrentTimestamp()
   {

      // 1) create a java calendar instance
      Calendar calendar = Calendar.getInstance();
      calendar.set( Calendar.HOUR_OF_DAY, 0 ); //anything 0 - 23
      calendar.set( Calendar.MINUTE, 0 );
      calendar.set( Calendar.SECOND, 0 );
      calendar.set( Calendar.MILLISECOND, 0 );

      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current date (now) instance
      return new java.sql.Timestamp( now.getTime() );

   }

   /**
    * Method return the current date and time(i.e. 12:30AM) minus the duration (i.e Hours/Minute/Seconds/MillSeconds) in the 
    * format - 2020-02-10 00:20:00.0 in case you wanted to reduce the 3 hours from the current time
    * 
    * @param durationType is a instance of String class
    * @param duration is a integer data type
    * @return currentTimestampMinusDuration is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getCurrentTimestampMinusDuration( String durationType, int duration )
   {

      // 1) create a java calendar instance and reduce the duration based on the duration type  
      Calendar calendar = Calendar.getInstance();
      switch( durationType )
      {
         case HOURS:
            calendar.add( Calendar.HOUR_OF_DAY, -duration );
            break;
         case MINUTES:
            calendar.add( Calendar.MINUTE, -duration );
            break;
         case SECONDS:
            calendar.add( Calendar.SECOND, -duration );
            break;
         case MILLISECONDS:
            calendar.add( Calendar.MILLISECOND, -duration );
            break;
         default:
            break;
      }
      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current date (now) instance
      return new java.sql.Timestamp( now.getTime() );

   }

   /**
    * Method return the current date and time(i.e. 12:30AM) minus the duration (i.e Hours/Minute/Seconds/MillSeconds) in the 
    * format - 2020-02-10 00:20:00.0 in case you wanted to increase the 3 hours from the current time
    * 
    * @param durationType is a instance of String class
    * @param duration is a integer data type
    * @return currentTimestampPlusDuration is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp getCurrentTimestampPlusDuration( String durationType, int duration )
   {

      // 1) create a java calendar instance and reduce the duration based on the duration type  
      Calendar calendar = Calendar.getInstance();
      switch( durationType )
      {
         case HOURS:
            calendar.add( Calendar.HOUR_OF_DAY, duration );
            break;
         case MINUTES:
            calendar.add( Calendar.MINUTE, duration );
            break;
         case SECONDS:
            calendar.add( Calendar.SECOND, duration );
            break;
         case MILLISECONDS:
            calendar.add( Calendar.MILLISECOND, duration );
            break;
         default:
            break;
      }
      // 2) get a java.util.Date from the calendar instance.
      // this date will represent the current instant, or "now".
      java.util.Date now = calendar.getTime();

      // 3) a java current date (now) instance
      return new java.sql.Timestamp( now.getTime() );

   }

   /**
    * Used to a clone a new instance of existing sourceTimestamp 
    * @param sourceTimestamp is a instance of java.sql.Timestamp class
    * @return cloneTimestamp is a instance of java.sql.Timestamp class
    */
   public static java.sql.Timestamp cloneTimestamp( java.sql.Timestamp sourceTimestamp )
   {

      return Optional.ofNullable( sourceTimestamp )
            .map( java.sql.Timestamp::getTime )
            .map( java.sql.Timestamp::new )
            .orElse( null );

   }

   public static Date getDateFromXMLGregorianCalendar( XMLGregorianCalendar xmlGregorianCalendar )
   {
      return xmlGregorianCalendar.toGregorianCalendar().getTime();
   }
   
   public static java.sql.Timestamp getTimestampFromXMLGregorianCalendar( XMLGregorianCalendar xmlGregorianCalendar )
   {
      return new java.sql.Timestamp( xmlGregorianCalendar.toGregorianCalendar().getTime().getTime() );
   }

   public static XMLGregorianCalendar getCurrentXMLGregorianCalendar() throws DatatypeConfigurationException
   {
      return getXMLGregorianCalendarFromTimestamp( DateUtils.getCurrentTimestamp() );
   }

   public static XMLGregorianCalendar getXMLGregorianCalendarFromTimestamp( final java.sql.Timestamp timestamp )
         throws DatatypeConfigurationException
   {
      XMLGregorianCalendar xmlGregorianCalendar = null;

      final GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.setTime( timestamp );
      xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianCalendar );

      return xmlGregorianCalendar;
   }

   public static XMLGregorianCalendar getXMLGregorianCalendarFromDate( final Date date )
   {
      XMLGregorianCalendar xmlGregorianCalendar = null;

      try {
         final GregorianCalendar gregorianCalendar = new GregorianCalendar();

         gregorianCalendar.setTime( date );

         xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianCalendar );
      }
      catch( Exception exception ) {
         String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( EsafeErrorCodes.EC_SRS_DATATYPE_CONFIGURATION_EXCEPTION,
               exception.getClass().getName(), " Issue due to getting XMLGregorianCalendar from date while processing the request" );
         LOGGER.warn( errorCodeMessage, exception );
      }
      return xmlGregorianCalendar;
   }

   public static XMLGregorianCalendar getXMLGregorianCalendar()
   {
      GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.getTime();
      return DateUtils.getXMLGregorianCalendarFromDate( gregorianCalendar.getTime() );
   }

   /**
    * Used to a clone a new instance of existing sourceXMLGregorianCalendar 
    * @param sourceTimestamp is a instance of XMLGregorianCalendar class
    * @return cloneXMLGregorianCalendar is a instance of XMLGregorianCalendar class
    */
   public static XMLGregorianCalendar cloneXMLGregorianCalendar( XMLGregorianCalendar sourceXMLGregorianCalendar )
   {

      return Optional.ofNullable( sourceXMLGregorianCalendar )
            .map( DateUtils::getDateFromXMLGregorianCalendar )
            .map( DateUtils::getXMLGregorianCalendarFromDate )
            .orElse( null );

   }

   public static String getElapseTime( long startTime )
   {
      long endTime = System.currentTimeMillis();
      long diff = endTime - startTime;
      final long hr = TimeUnit.MILLISECONDS.toHours( diff );
      final long min = TimeUnit.MILLISECONDS.toMinutes( diff - TimeUnit.HOURS.toMillis( hr ) );
      final long sec = TimeUnit.MILLISECONDS.toSeconds( diff - TimeUnit.HOURS.toMillis( hr ) - TimeUnit.MINUTES.toMillis( min ) );
      final long ms = TimeUnit.MILLISECONDS.toMillis( diff - TimeUnit.HOURS.toMillis( hr ) - TimeUnit.MINUTES.toMillis( min )
            - TimeUnit.SECONDS.toMillis( sec ) );
      return StringUtils.formatMessage( "%02d Hours, %02d Minutes, %02d Seconds, and %03d Mesc.", hr, min, sec, ms );

   }

}
