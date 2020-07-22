package com.freddiemac.datamanager.ws.enums;

import java.util.stream.Stream;

public enum LogLevel
{
   UNKNOWN(6),
   ERROR(5),
   WARN(4), 
   INFO(3),
   DEBUG(2),
   TRACE(1);

   private final Integer value;

   LogLevel(Integer v) {
       value = v;
   }

   public int value() {
       return value;
   }

   public static LogLevel fromValue(Integer v) {
       for (LogLevel c: LogLevel.values()) {
           if (c.value.equals(v)) {
               return c;
           }
       }
       return null;
   }
   
   public static Stream<LogLevel> stream() {
      return Stream.of(LogLevel.values()); 
   }
   
}
