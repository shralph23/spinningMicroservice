package com.freddiemac.datamanager.ws.esafe.exception;

public class EsafeException extends Exception
{

   private static final long serialVersionUID = 1L;

   private final String errorCode;

   /**
    * @param message is a instance of String class
    * @param errorDetails is a instance of String class
    */
   public EsafeException( String message )
   {
      super( message );
      this.errorCode = null;
   }

   /**
    * @param message is a instance of String class
    * @param errorDetails is a instance of String class
    * @param cause is a instance of Throwable class
    */
   public EsafeException( String message, Throwable cause )
   {
      super( message, cause );
      this.errorCode = null;
   }

   /**
    * @param message is a instance of String class
    * @param errorCode is a instance of String class
    * @param errorDetails is a instance of String class
    * @param cause is a instance of Throwable class
    */
   public EsafeException( String message, String errorCode, Throwable cause )
   {
      super( message, cause );
      this.errorCode = errorCode;
   }

   /**
    * @return errorCode is a instance of String class
    */
   public String getErrorCode()
   {
      return errorCode;
   }

}
