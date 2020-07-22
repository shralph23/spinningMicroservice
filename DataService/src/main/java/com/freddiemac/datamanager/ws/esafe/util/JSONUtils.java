package com.freddiemac.datamanager.ws.esafe.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSONUtils
{

   private JSONUtils()
   {
   }

   /**
    * GSON Serialization a Object to JSON string with pretty format or without pretty format
    * 
    * @param object is a instance of Object class
    * @param prettyFormatFlag is a boolean type
    * @return JSON string based on the object input
    */
   public static String convertObjectToJSONStringUsingGSON( Object object, boolean prettyFormatFlag )
   {

      GsonBuilder gsonBuilder = new GsonBuilder();

      if( prettyFormatFlag ) {
         gsonBuilder.setPrettyPrinting();
      }
      Gson gson = gsonBuilder.disableHtmlEscaping().create();

      return gson.toJson( object );

   }

   /**
    * GSON Deserialization a JSON string to object based on the Class<?> type
    * 
    * @param jsonString is a instance of String class
    * @param clazz is a instance of Class<?> class
    * @return object is a instance of Object class
    */
   public static Object convertJSONStringToObjectUsingGSON( String jsonString, Class< ? > clazz )
   {

      GsonBuilder gsonBuilder = new GsonBuilder();
      Gson gson = gsonBuilder.disableHtmlEscaping().create();

      return gson.fromJson( jsonString, clazz );

   }

   /**
    * Jackson Serialization a Object to JSON string with pretty format or without pretty format
    * 
    * @param object is a instance of Object class
    * @param prettyFormatFlag is a boolean type
    * @return JSON string based on the object input
    * @throws JsonProcessingException
    */
   public static String convertObjectToJSONStringUsingJackson( Object object, boolean prettyPrinterFlag ) throws JsonProcessingException
   {

      if ( GeneralUtils.doesObjectExist( object ) ) {
         ObjectMapper objectMapper = new ObjectMapper();
   
         if( prettyPrinterFlag ) {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString( object );
         }
         else {
            return objectMapper.writeValueAsString( object );
         }
      }
      else {
         return null;
      }

   }

   /**
    * Jackson Deserialization a JSON string to object based on the Class<?> type
    * 
    * @param jsonString is a instance of String class
    * @param clazz is a instance of Class<?> class
    * @return object is a instance of Object class
    * @throws IOException
    * @throws JsonMappingException
    * @throws JsonParseException
    */
   public static Object convertJSONStringToObjectUsingJackson( String jsonString, Class< ? > clazz ) throws IOException
   {

      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue( jsonString, clazz );

   }

   /**
    * Jackson Convert a class to JSON Schema
    * 
    * @param clazz is a instance of Class< ? > class
    * @return jsonSchema is a instance of JsonSchema class
    */
   public static JsonSchema convertObjectToJSONSchemaUsingJackson( Class< ? > clazz ) throws JsonProcessingException
   {

      ObjectMapper mapper = new ObjectMapper();
      JsonSchemaGenerator schemaGen = new JsonSchemaGenerator( mapper );
      return schemaGen.generateSchema( clazz );

   }

}
