package com.freddiemac.datamanager.ws.esafe.util;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author f370576
 */
public class UUIDSmallGeneratorUtil
{

   private static final Logger LOGGER = LoggerFactory.getLogger( UUIDSmallGeneratorUtil.class );

   private static final UUIDSmallGeneratorUtil generator = UUIDSmallGeneratorUtil.getInstance();

   public synchronized String generateUniqueId()
   {
      String smallUUID = generator.generateRandomBasedUUID();
      LOGGER.info( smallUUID );

      return smallUUID;
   }

   private String generateRandomBasedUUID()
   {
      // get day of year in calendar and add milliseconds and good enough for testing, create specific string length

      // get current values
      Calendar calendar = Calendar.getInstance();

      int dayOfYear = calendar.get( Calendar.DAY_OF_YEAR ); // Field number for get and set indicating the day number
      // within the current year.
      String dayOfYearString = String.format( "%03d", dayOfYear );

      int secs = calendar.get( Calendar.SECOND );
      String secsString = String.format( "%02d", secs );

      int ms = calendar.get( Calendar.MILLISECOND );
      String msString = String.format( "%03d", ms );

      // small UUID - 8 character string
      return String.format( "%s%s%s", dayOfYearString, secsString, msString );

   }

   private static UUIDSmallGeneratorUtil getInstance()
   {
      return new UUIDSmallGeneratorUtil();
   }

}
