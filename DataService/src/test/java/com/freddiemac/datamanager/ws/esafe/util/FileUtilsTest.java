package com.freddiemac.datamanager.ws.esafe.util;

import org.junit.Test;

import com.freddiemac.datamanager.ws.constant.TestConstants;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeOpenShiftSecretsException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FileUtilsTest
{

   @Test
   public void getCurrentDirectoryTest1()
   {
      
      String testName = "getCurrentDirectoryTest1";
      
      try
      {
      	System.out.println( "In test:'" + testName + "' Running from directory:'" + FileUtils.getCurrentWorkingDirectory() + "'" );
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );     

   }

   @Test
   public void confirmFileExistsTest1()
   {
      
      String testName = "confirmFileExistsTest1";

      try
      {
         String testFileName1 = new String( TestConstants.SECRETS_LOCATION_PATH + "garbage" );
         boolean flag1 = FileUtils.confirmFileExists(testFileName1);
         
         if( flag1 ) {
            System.err.println( "Error in test:'" + testName + "' File:'" + testFileName1 + "' should be missing!" );
            assertTrue( Boolean.FALSE );           
         }
         else {
            System.out.println( "In test:'" + testName + "' Success file:'" + testFileName1 + "' is missing!" );
         }
         
         String testFileName2 = new String( TestConstants.SECRETS_LOCATION_PATH );
         boolean flag2 = FileUtils.confirmFileExists(testFileName2);
         
         if( flag2 ) {
            System.err.println( "Error in test:'" + testName + "' File:'" + testFileName2 + "' should be missing!" );
            assertTrue( Boolean.FALSE );           
         }
         else {
            System.out.println( "In test:'" + testName + "' Success file:'" + testFileName2 + "' is missing!" );
         }
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );     

   }

   @Test
   public void confirmFileExistsTest2()
   {
      
      String testName = "confirmFileExistsTest2";
      
      try
      {
         String testFileName = new String("doc/README.md");
         boolean flag = FileUtils.confirmFileExists(testFileName);
         
         if( flag ) {
            System.out.println( "In test:'" + testName + "' Success file:'" + testFileName + "' exists!" );
         }
         else {
            System.err.println( "Error in test:'" + testName + "' File:'" + testFileName + "' exists!" );
            assertTrue( Boolean.FALSE );           
         }
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );     

   }

   @Test
   public void confirmDirectoryExistsTest1()
   {
      
      String testName = "confirmDirectoryExistsTest1";

      try
      {
         String testDirectory1 = new String("garbagedir");
         boolean flag1 = FileUtils.confirmDirectoryExists(testDirectory1);
         if( flag1 ) {
            System.err.println( "Error in test:'" + testName + "' Directory:'" + testDirectory1 + "' should be missing!" );
            assertTrue( Boolean.FALSE );           
         }
         else {
            System.out.println( "In test:'" + testName + "' Success Directory:'" + testDirectory1 + "' is missing!" );
         }
         
         String testDirectory2 = new String("doc/README.md");
         boolean flag2 = FileUtils.confirmDirectoryExists(testDirectory2);
         if( flag2 ) {
            System.err.println( "Error in test:'" + testName + "' Directory:'" + testDirectory2 + "' should be missing!" );
            assertTrue( Boolean.FALSE );           
         }
         else {
            System.out.println( "In test:'" + testName + "' Success Directory:'" + testDirectory2 + "' is missing!" );
         }
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );     

   }

   @Test
   public void confirmDirectoryExistsTest2()
   {

      String testName = "confirmDirectoryExistsTest2";

      try
      {
         String testDirectory = new String( "doc" );
         boolean flag = FileUtils.confirmDirectoryExists(testDirectory);
         
         if( flag ) {
            System.out.println( "In test:'" + testName + "' Success Directory:'" + testDirectory + "' exists!" );
         }
         else {
            System.err.println( "Error in test:'" + testName + "' Directory:'" + testDirectory + "' does not exist!" );
            assertTrue( Boolean.FALSE );           
         }
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
     
      System.out.println( "Successful test:'" + testName + "'" );     

   }

   @Test
   public void retrieveSecurityCodeFromSecretsLocationTest1()
   {

      String testName = "retrieveSecurityCodeFromSecretsLocationTest1";

      try
      {
         String securityCode = FileUtils.retrieveSecurityCodeFromSecretsLocation( TestConstants.SLMS_ABBREVIATION_UC, "garbage", TestConstants.SECRETS_LOCATION_PATH );
         
         System.err.println( "Error in test:'" + testName + "' SecurityCode:'" + securityCode + "'" );
         assertTrue( Boolean.FALSE );  
         
      }
      catch (EsafeOpenShiftSecretsException esafeOpenShiftSecretsException)
      {
         System.out.println("In test:'" + testName + "' due to exception:" + esafeOpenShiftSecretsException.toString());
         assertThat( esafeOpenShiftSecretsException.getClass(), equalTo( EsafeOpenShiftSecretsException.class ) );
      }
      catch (Exception e)
      {
         System.err.println("Error in test:'" + testName + "' due to exception:" + e.toString());
         assertTrue( Boolean.FALSE );
      }
     
      System.out.println( "Successful test:'" + testName + "'" );     

   }
   
}