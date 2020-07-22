package com.freddiemac.datamanager.ws.esafe.util;

import java.util.UUID;

/**
 * @author f370576
 */

public class UUIDGeneratorUtils
{

   private static final UUIDGeneratorUtils generator = UUIDGeneratorUtils.getInstance();

   public synchronized String generateUniqueId()
   {
      UUID uuid = generator.generateRandomBasedUUID();
      return uuid.toString();
   }

   private UUID generateRandomBasedUUID()
   {
      return UUID.randomUUID();
   }

   private static UUIDGeneratorUtils getInstance()
   {
      return new UUIDGeneratorUtils();      
   }

}
