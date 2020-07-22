package com.freddiemac.datamanager.ws.esafe.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeConstants;
import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeOpenShiftSecretsException;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;


public final class FileUtils
{

   private static final Logger LOGGER = LoggerFactory.getLogger( FileUtils.class );

   private FileUtils()
   {
   }

   public static String getCurrentWorkingDirectory()
   {

      ClassLoader classLoader = FileUtils.class.getClassLoader();

      File classpathRoot = new File( classLoader.getResource( EsafeConstants.EMPTY_STRING ).getPath() );

      return classpathRoot.getPath();
   }

   /**
    * Checks whether the file exists on the system
    * 
    * @param fileName is a instance of String class
    * @return fileExists will true in case of file exists otherwise false
    */
   public static boolean confirmFileExists( final String fileName )
   {

      boolean fileExists = Boolean.FALSE;
      final File file = new File( fileName );

      if( file.exists() && file.isFile() ) {
         fileExists = Boolean.TRUE;
      }

      return fileExists;
   }

   /**
    * Checks whether the directory exists on the system
    * 
    * @param directoryName is a instance of String class
    * @return directoryExists will true in case of file exists otherwise false
    */
   public static boolean confirmDirectoryExists( final String directoryName )
   {

      boolean directoryExists = Boolean.FALSE;
      final File directory = new File( directoryName );

      if( directory.exists() && directory.isDirectory() ) {
         directoryExists = Boolean.TRUE;
      }

      return directoryExists;
   }

   /**
    * Gets the secret location path and the authentication user to retrieve security code
    * 
    * @param component is a instance of String class
    * @param authUser is the ID whose security code needs to be retrieved
    * @param secretLocationPath is the secret location of the password
    * @return the security code from the secret location
    */
   public static String retrieveSecurityCodeFromSecretsLocation( String component, String authUser, String secretLocationPath )
   {

      String securityCode = null;

      try {
         securityCode = new String( Files.readAllBytes( Paths.get( secretLocationPath + authUser ) ) );
         LOGGER.info(
               "Successfully fetched security code from openshift secrets for Component:'{}' - SecretLocationPath:'{}' - AuthUser:'{}' - SecurityCode:'********'",
               component, secretLocationPath, authUser );
      }
      catch( IOException ioException ) {
         String errorMessage = StringUtils.formatMessage( "Error in fetching security code from openshift secrets for Component:'%s' - SecretLocationPath:'%s' - AuthUser:'%s' - SecurityCode:''",
               component, secretLocationPath, authUser );
         String errorCodeMessage = EsafeRuntimeException.getExceptionLoggingMessage( EsafeErrorCodes.EC_SRS_OPEN_SHIFT_SECRETS_FETCH_EXCEPTION,
               ioException.getClass().getName(), errorMessage );
         LOGGER.error( errorCodeMessage, ioException );

         throw new EsafeOpenShiftSecretsException( errorMessage, EsafeErrorCodes.EC_SRS_OPEN_SHIFT_SECRETS_FETCH_EXCEPTION );
      }

      return securityCode;

   }

}
