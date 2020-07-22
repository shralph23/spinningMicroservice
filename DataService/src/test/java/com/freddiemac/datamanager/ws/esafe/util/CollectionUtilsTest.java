package com.freddiemac.datamanager.ws.esafe.util;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.freddiemac.datamanager.ws.config.EnvSpecificAppProperties;

@RunWith(SpringRunner.class)
@EnableConfigurationProperties(EnvSpecificAppProperties.class)
@TestPropertySource("classpath:application-test.yml")
public class CollectionUtilsTest
{

   @Autowired
   EnvSpecificAppProperties envSpecificAppProperties;
   
   @Test
   public void testCollectionUtilsTest1()
   {
      
      String testName = "testCollectionUtilsTest1";

      try {

         List< String > aListContainingDuplicates = Arrays.asList("44354354", "44354355", "44354355");

         Set< String > aSet = CollectionUtils.findDuplicates( aListContainingDuplicates );
         System.out.println( "In test:'" + testName + "' aSet:'" + aSet.toString() + "'" );
         assertThat( aSet.size(), equalTo( 1 ) );

      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
      
   }

   @Test
   public void testCollectionUtilsTest2()
   {
      String testName = "testCollectionUtilsTest2";

      try {

         List< String > aListContainingDuplicates = Arrays.asList("44354354", "44354355");

         Set< String > aSet = CollectionUtils.findDuplicates( aListContainingDuplicates );
         System.out.println( "In test:'" + testName + "' aSet:'" + aSet.toString() + "'" );
         assertThat( aSet.size(), equalTo( 0 ) );
      }
      catch( Exception e ) {
         System.out.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
   }

   @Test
   public void testCollectionUtilsTest3()
   {
      String testName = "testCollectionUtilsTest3";

      try {
         
         List< String > aListContainingDuplicates = Arrays.asList("44354354", "44354355", "44354354");

         Set< String > aSet = CollectionUtils.findDuplicatesAndIgnoreEmptyDatasInCollection( aListContainingDuplicates );
         assertThat( 1, equalTo( aSet.size() ) );
         System.out.println( "In test:'" + testName + "' aSet:'" + aSet.toString() + "'" );         
         
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
   }

   @Test
   public void testCollectionUtilsTest4()
   {
      String testName = "testCollectionUtilsTest4";

      try {

         List< String > aListContainingDuplicates = Arrays.asList("", "44354354", "44354355", "44354354", "");

         Set< String > aSet = CollectionUtils.findDuplicatesAndIgnoreEmptyDatasInCollection( aListContainingDuplicates );
         assertThat( aSet.size(), equalTo( 1 ) );
         System.out.println( "In test:'" + testName + "' aSet:'" + aSet.toString() + "'" );         
         
      }
      catch( Exception e ) {
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }

      System.out.println( "Successful test:'" + testName + "'" );
   }
   
   @Test
   public void testCollectionUtilsTest5() throws Exception
   {
      String testName = "testCollectionUtilsTest5";
      System.out.println( "In test:'" + testName );
      try {
         List<String> list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr = new  ArrayList< >();
         listarr.addAll( list );
         int limit=4;
         CollectionUtils.getLastNItems( listarr, limit );
         System.out.println( "In test:'" + testName + "' listarr:'" + listarr.toString() + "'" );         
         assertThat( listarr, hasItem( "9" ) );
         assertThat( listarr, not( hasItem( "5" ) ) );

      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest6() throws Exception
   {
      String testName = "testCollectionUtilsTest6";
      System.out.println( "In test:'" + testName );
      try {
         List<String> list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr = new  ArrayList< >();
         listarr.addAll( list );
         int limit=12;
         CollectionUtils.getLastNItems( listarr, limit );
         System.out.println( "In test:'" + testName + "' listarr:'" + listarr.toString() + "'" );         
         assertThat( listarr, hasItems( "1", "9" ) );
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest7() throws Exception
   {
      String testName = "testCollectionUtilsTest7";
      System.out.println( "In test:'" + testName );
      try {
         List<String> list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr = new  ArrayList< >();
         listarr.addAll( list );
         int limit=-1;
         CollectionUtils.getLastNItems( listarr, limit );
         System.out.println( "In test:'" + testName + "' listarr:'" + listarr.toString() + "'" );         
         assertThat( listarr, hasItems( "1", "9" ) );

      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest8() throws Exception
   {
      String testName = "testCollectionUtilsTest8";
      System.out.println( "In test:'" + testName );
      try {
         ArrayList<String> listarr = new  ArrayList< >();
         int limit=3;
         CollectionUtils.getLastNItems( listarr, limit );
         System.out.println( "In test:'" + testName + "' listarr:'" + listarr.toString() + "'" );         
         assertThat( listarr, not( hasItem( "1" ) ) );

      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest9() throws Exception
   {
      
      String testName = "testCollectionUtilsTest9";
      
      try {
         Boolean logFlag1 = Boolean.FALSE;      
         List<String> list1 = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr1 = new ArrayList< >();
         listarr1.addAll( list1 );
         int listLimit1 = 4;
         String dataExists1 = listarr1.get( 3 ); //represent - "4"
         String dataNotExists1 = listarr1.get( 8 ); //represent - "9"
         System.out.println( "In test:'" + testName + "' Initial List Contents:'" + listarr1.toString() + "'" ); 
         CollectionUtils.getFirstNItems( listarr1, listLimit1, logFlag1, "TestList" );                   
         System.out.println( "In test:'" + testName + "' List Limit:'" + listLimit1 + "' Final List Contents:'" + listarr1.toString() + "'" );
         assertThat( listarr1, hasItem( dataExists1 ) );
         System.out.println( "In test:'" + testName + "' Data still Exists in List:'" + dataExists1 + "'" );
         assertThat( listarr1, not( hasItem( dataNotExists1 ) ) );
         System.out.println( "In test:'" + testName + "' Data does Not Exists in List:'" + dataNotExists1 + "'" );
         
         Boolean logFlag2 = Boolean.TRUE;      
         List<String> list2 = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr2 = new ArrayList< >();
         listarr2.addAll( list2 );
         int listLimit2 = 4;
         String dataExists2 = listarr2.get( 3 ); //represent - "4"
         String dataNotExists2 = listarr2.get( 8 ); //represent - "9"
         System.out.println( "In test:'" + testName + "' Initial List Contents:'" + listarr2.toString() + "'" ); 
         CollectionUtils.getFirstNItems( listarr2, listLimit2, logFlag2, "TestList" );                   
         System.out.println( "In test:'" + testName + "' List Limit:'" + listLimit2 + "' Final List Contents:'" + listarr2.toString() + "'" );
         assertThat( listarr1, hasItem( dataExists2 ) );
         System.out.println( "In test:'" + testName + "' Data still Exists in List:'" + dataExists2 + "'" );
         assertThat( listarr1, not( hasItem( dataNotExists2 ) ) );
         System.out.println( "In test:'" + testName + "' Data does Not Exists in List:'" + dataNotExists2 + "'" );
         
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest10() throws Exception
   {
      
      Boolean logFlag = Boolean.TRUE;      
      String testName = "testCollectionUtilsTest10";
      
      try {
         
         List<String> list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         ArrayList<String> listarr = new  ArrayList< >();
         listarr.addAll( list );
         int listLimit = 0;
         String dataExists1 = listarr.get( 3 );
         String dataExists2 = listarr.get( 8 );
         System.out.println( "In test:'" + testName + "' Initial List Contents:'" + listarr.toString() + "'" ); 
         CollectionUtils.getFirstNItems( listarr, listLimit, logFlag, "TestList" );                   
         System.out.println( "In test:'" + testName + "' List Limit:'" + listLimit + "' Final List Contents:'" + listarr.toString() + "'" );
         assertThat( listarr, hasItems( dataExists1, dataExists2 ) );
         System.out.println( "In test:'" + testName + "' Data still exists in List:'" + dataExists1 + "'" );
         System.out.println( "In test:'" + testName + "' Data still exists in List:'" + dataExists2 + "'" );
         
         list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         listarr = new  ArrayList< >();
         listLimit = 0;
         System.out.println( "In test:'" + testName + "' Initial List Contents:'" + listarr.toString() + "'" ); 
         CollectionUtils.getFirstNItems( listarr, listLimit, logFlag, "TestList" );                   
         System.out.println( "In test:'" + testName + "' List Limit:'" + listLimit + "' Final List Contents:'" + listarr.toString() + "'" );
         
         list = Arrays.asList( "1","2","3","4","5","6","7","8","9" );
         listarr = new  ArrayList< >();
         listarr.addAll( list );
         listLimit = 9;
         dataExists1 = listarr.get( 3 );
         dataExists2 = listarr.get( 8 );
         System.out.println( "In test:'" + testName + "' Initial List Contents:'" + listarr.toString() + "'" ); 
         CollectionUtils.getFirstNItems( listarr, listLimit, logFlag, "TestList" );                   
         System.out.println( "In test:'" + testName + "' List Limit:'" + listLimit + "' Final List Contents:'" + listarr.toString() + "'" );
         assertThat( listarr, hasItems( dataExists1, dataExists2 ) );
         System.out.println( "In test:'" + testName + "' Data still exists in List:'" + dataExists1 + "'" );
         System.out.println( "In test:'" + testName + "' Data still exists in List:'" + dataExists2 + "'" );
         
         
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   }
   
   @Test
   public void testCollectionUtilsTest11() throws Exception
   {
      String testName = "testCollectionUtilsTest11";
      System.out.println( "In test:'" + testName );
      try {
         ArrayList<Long> listarr = new ArrayList< >();
         listarr.add( 100L );
         listarr.add( 200L );

         Boolean result = CollectionUtils.itemExistsInCollection( listarr, 200L );
         assertThat( result, equalTo( Boolean.TRUE ) );     
         
         result = CollectionUtils.itemExistsInCollection( listarr, 300L );
         assertThat( result, equalTo( Boolean.FALSE ) );
         
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   @Test
   public void testCollectionUtilsTest12() throws Exception
   {
      String testName = "testCollectionUtilsTest12";
      System.out.println( "In test:'" + testName );
      try {
         ArrayList<String> listarr = new ArrayList< >();
         
         Boolean result = CollectionUtils.doesCollectionContainsValue( listarr );
         assertThat( result, equalTo( Boolean.FALSE ) );         
         
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
   
   @Test
   public void testCollectionUtilsTest13() throws Exception
   {
      String testName = "testCollectionUtilsTest13";
      
      try {
         ArrayList<String> listarr = new ArrayList< >();
         
         Boolean result = CollectionUtils.isCollectionEmpty( listarr );
         assertThat( result, equalTo( Boolean.TRUE ) );         
         System.out.println( "In test:'" + testName + "' Array:'" + listarr + "' Result:'" + result + "'" );

         listarr.add( "324734234" );
         result = CollectionUtils.isCollectionEmpty( listarr );
         assertThat( result, equalTo( Boolean.FALSE ) );         
         System.out.println( "In test:'" + testName + "' Array:'" + listarr + "' Result:'" + result + "'" );
         
      }catch(Exception e){
         System.err.println( "Error in test:'" + testName + "' due to exception:" + e.toString() );
         assertTrue( Boolean.FALSE );
      }
      System.out.println( "Successful test:'" + testName + "'" );
   } 
   
}

