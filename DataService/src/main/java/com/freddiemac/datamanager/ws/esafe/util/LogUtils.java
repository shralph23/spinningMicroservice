package com.freddiemac.datamanager.ws.esafe.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.enums.LogLevel;

public class LogUtils
{
   
   private static final Logger LOGGER = LoggerFactory.getLogger( LogUtils.class );
   
   private LogUtils()
   {
   }
   
   public static void logServiceMessage(LogLevel logLevel, String format, Object... objects) {
      
      switch( logLevel ) {
         case TRACE:            
            LOGGER.trace( format, objects );          
            break;
         case DEBUG:            
            LOGGER.debug( format, objects );          
            break;
         case INFO:            
            LOGGER.info( format, objects );          
            break;
         case WARN:
            LOGGER.warn( format, objects );
            break;
         case ERROR:
            LOGGER.error( format, objects );
            break;
         default:
            break;
      }
      
   }

}
