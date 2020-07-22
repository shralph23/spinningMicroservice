package com.freddiemac.datamanager.ws.esafe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionUtils {
   
   private static final Logger LOGGER = LoggerFactory.getLogger( CollectionUtils.class );   
  
   private CollectionUtils() {
   }
   
   /**
    * find the unique duplicate data present in the collections without ignoring empty strings
    * @param duplicateDatas is a instance of List< String > class
    * @return set is a instance of Set< String > class
    */
   public static Set< String > findDuplicates( Collection< String > duplicateDatas ) {
      
      Set< String > setUnique = new HashSet<>();                   

      return duplicateDatas.stream()
                              .filter( str -> !setUnique.add( str ) )
                              .collect( Collectors.toSet() );
      
   }

   /**
    * find the unique duplicate data present in the collections ignoring empty strings
    * @param duplicateDatas is a instance of List< String > class
    * @return set is a instance of Set< String > class
    */
   public static Set< String > findDuplicatesAndIgnoreEmptyDatasInCollection( Collection< String > duplicateDatas ) {

      Set< String > setUnique = new HashSet<>();                   
      
      return duplicateDatas.stream()
                              .map( String::trim )
                              .filter( str -> str.length() > 0 && !setUnique.add( str ) )
                              .collect( Collectors.toSet() );
      
   }

   /**
    * Deletes the null and Empty string from the collection  
    * @param datas is a instance of Collection< String > class
    * @return list is a instance of List< String > class
    */
   public static List<String> removeNullAndEmptyDatasInCollection( Collection<String> datas ) {
      return datas.stream()
                     .filter( StringUtils::doesValueExist )
                     .map( String::trim )
                     .collect( Collectors.toList() );
   }
   
   /**
    * Masks all the data present in the collection  
    * @param datas is a instance of Collection< String > class
    * @return list is a instance of List< String > class
    */
   public static List<String> maskDatasInCollection( Collection<String> datas ) {
      return datas.stream()
                     .filter( StringUtils::doesValueExist )
                     .map( String::trim )
                     .map( StringUtils::getMaskedString )
                     .collect( Collectors.toList() );
   }
   
   /**
    * purges the duplicate data in the collection
    * @param datas is a instance of Collection< T > class
    * @return list is a instance of List< T > class
    */
   public static <T> List<T> removeDuplicateDatasInCollection( Collection<T> datas ) {
      return new ArrayList<>(new HashSet<>( datas ));
   }
   
   /**
    * Converts any collection type to list string type
    * @param datas is a instance of Collection< ? > class
    * @return list is a instance of List< String > class
    */
   public static List<String> convertCollectionTypeToListStringType( Collection< ? > datas ) {
      
      return datas.stream()
                     .map( String::valueOf )
                     .collect( Collectors.toList() );
      
   }
   
   /**
    * 
    * Limit the size of the list based on the limit
    * ( i.e. (list size - limit) to list size)
    * 
    * @param list is an instance of List< ? >    
    * @param limit is used to reduce the size of the list 
    * 
    */
   public static void getLastNItems( List< ? > datas, int limit )
   {

      // limit list to maxSize items
      int theSize = datas.size();

      if( theSize > limit && limit > 0 ) {
         datas.subList( 0, theSize - limit ).clear();
      }
      
   }

   /**
    * 
    * Limit the size of the list based on the limit( i.e. 0 to limit)
    * also it is possible to log the message based on the 
    * logFlag boolean value
    * 
    * @param datas is an instance of List< ? >    
    * @param limit is used to reduce the size of the list 
    * @param logFlag is true in case you need to log the status
    * of the sublist operation on the list otherwise false 
    * 
    */
   public static void getFirstNItems( List< ? > datas, int limit, boolean logFlag, String listName ) {
            
      int datasSize = datas.size();
      
      if( datasSize > limit && limit > 0 ) {
         List< ? > finalSubDatas = datas.subList( limit, datasSize );
         if ( logFlag ) {  
            String theMessage = StringUtils.formatMessage( "Truncated the %s list to the required Size:'%s' from actual Size:'%s' - Removed these Items:'%s' from the %s list", 
                  listName, limit, datasSize, finalSubDatas, listName );
            LOGGER.warn( theMessage );                             
         }
         finalSubDatas.clear();
      }
            
   }        

   /**
    * 
    * Validate whether a item exists in the collection
    * @param datas is a instance of Collection<?> class
    * @param searchData is a instance of <T> generic type
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static <T> boolean itemExistsInCollection( Collection<?> datas, T searchData ) {
      
      return datas.contains( searchData );
      
   }
   
   /**
    * 
    * Validate whether a item exists in the collection
    * @param datas is a instance of Collection<String> class
    * @param pattern is a instance of String
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static boolean itemMatchingPatternExistsInCollection( Collection< String > datas, String value ) {
            
      return datas.stream()
                     .map( String::trim )
                     .anyMatch( value::matches );
      
   }
   
   
   /**
    * 
    * Validate whether a item exists in the collection
    * @param datas is a instance of Collection<String> class
    * @param validatedName is a instance of String which is name of field
    * @param validatedValue is a instance of String which is value of field
    * 
    * @return true in case the search String data is available in the collection;
    * otherwise false 
    * 
    */
   public static boolean itemMatchingPatternExistsInCollectionAndLog( Collection< String > datas, String validatedName, 
                                                                      String validatedValue, boolean maskedValidatedValueFlag,
                                                                      String messagePrefix ) {
      
      boolean patternMatchFlag = Boolean.FALSE;
      
      if ( CollectionUtils.doesCollectionContainsValue( datas ) ) {

         String exclusionValueTrim = datas.stream()
                                             .map( String::trim )
                                             .filter( validatedValue::matches )
                                             .findAny()
                                                .orElse( null );
         
         if ( StringUtils.isNotNull( exclusionValueTrim ) )  {
            String maskedValidatedValue = maskedValidatedValueFlag ? StringUtils.getMaskedString( validatedValue ) : validatedValue;
            LOGGER.info( "{} - Due to exclusion - ignoring {} value:'{}' due to exclusion value:'{}'", 
                         messagePrefix, validatedName, maskedValidatedValue, exclusionValueTrim );
            patternMatchFlag = Boolean.TRUE;
                  
         }
      
      }
      
      return patternMatchFlag;
      
   }
   
   
   /**
    * 
    * Validate whether the collection not null or empty
    * 
    * @param datas is a instance of Collection<?> class
    * 
    * @return true in case the dataCollection is not null or empty;
    * otherwise false
    * 
    */
   public static boolean doesCollectionContainsValue(Collection<?> datas) {
      
      boolean resultFlag = Boolean.FALSE;
      
      if( GeneralUtils.doesObjectExist( datas ) && !datas.isEmpty() ) {
            resultFlag = Boolean.TRUE;
      }
      
      return resultFlag;
      
   }
   

   public static boolean isCollectionEmpty(Collection<?> datas) {
      
      return !CollectionUtils.doesCollectionContainsValue(datas);
      
   }

   /**
    * 
    * @param data is a instance of String class
    * @param separator is used as a delimiter between strings
    * 
    * @return results is a instance of List<String> in case data contains value otherwise empty list
    * 
    */
   public static List<String> convertStringtoArrayList( String data, String separator ) {
      
      List<String> results = new ArrayList< >();
      
      if ( StringUtils.doesValueExist( data ) ) {
         results = Arrays.asList( data.trim().split( separator ) );
      } 
      
      return results;
      
   }
   
}
