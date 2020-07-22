package com.freddiemac.datamanager.ws.esafe.util;

public class DurationUtils
{

   private long start = -1;
   private long end = -1;
   private long duration = -1;

   public DurationUtils()
   {
      this.start = 0;
      this.end = 0;
      this.duration = 0;
   }

   public long getStart()
   {
      return start;
   }

   public long getEnd()
   {
      return end;
   }

   public long getDuration()
   {
      return duration;
   }

   public void start()
   {
      this.start = System.currentTimeMillis();
      this.end = 0;
      this.duration = 0;
   }

   public void end()
   {
      this.end = System.currentTimeMillis();
      this.duration = end - start;
   }

   public void add( Long increment )
   {
      // used to bump existing time
      this.start = 0;
      this.end = 0;
      this.duration = this.duration + increment;
   }

   @Override
   public String toString()
   {
      return "Duration [start=" + start + ", end=" + end + ", duration=" + duration + "]";
   }

}