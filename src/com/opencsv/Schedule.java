package com.opencsv;

import java.util.HashMap;

/**
 * A schedule with hours available.
 * @author Albert Yu
 * @version 0.1 11-11-2015
 */
public class Schedule extends HashMap2D<String, Boolean>
{
   /**
    * The list of weekdays
    */
   public static String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri"};
   
   /**
    * The list of hours
    */
   public static String[] listOfTimes = {"9 - 9:50 AM", "10 - 10:50 AM", "11 - 11:50 AM", "12 - 12:50 AM", "1 - 1:50 AM", "2 - 2:50 AM",
         "3 - 3:50 AM", "4 - 4:50 AM"};
   
   private HashMap2D<String, Boolean> schedule;
   
   
   public static HashMap<Integer, String> indexToWeekday = createIndexToWeekday();
   /**
    * This will create a HashMap that will map the csv row indices to their
    * appropriate weekday. 
    * @return HashMap, which gets stored as a static field
    */
   private static HashMap<Integer, String> createIndexToWeekday()
   {
      HashMap<Integer, String> whatWeWant = new HashMap<Integer, String>();
      whatWeWant.put(3, "Mon");
      whatWeWant.put(4, "Tue");
      whatWeWant.put(5, "Wed");
      whatWeWant.put(6, "Thu");
      whatWeWant.put(7, "Fri");
      return whatWeWant;
   }
   
   /**
    * This will construct a Schedule object that assumes all days and
    * all hours are not free
    */
   public Schedule()
   {
      schedule = new HashMap2D<String, Boolean>();
      for (int i = 0; i < weekdays.length; i++)
      {
         schedule.put(weekdays[i]);
         for (int j = 0; j < listOfTimes.length; j++)
         {
            schedule.put(weekdays[i], listOfTimes[j], false);
         }
      }
   }
   
}
