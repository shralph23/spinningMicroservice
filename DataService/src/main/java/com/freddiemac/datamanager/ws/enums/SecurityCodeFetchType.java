package com.freddiemac.datamanager.ws.enums;

public enum SecurityCodeFetchType
{

   OPEN_SHIFT_SECRETS("OpenShiftSecrets"), 
   DEFAULT("Default");

   private final String value;

   SecurityCodeFetchType(String v) {
       value = v;
   }

   public String value() {
       return value;
   }

   public static SecurityCodeFetchType fromValue(String v) {
       for (SecurityCodeFetchType c: SecurityCodeFetchType.values()) {
           if (c.value.equals(v)) {
               return c;
           }
       }
       throw new IllegalArgumentException(v);
   }

}
