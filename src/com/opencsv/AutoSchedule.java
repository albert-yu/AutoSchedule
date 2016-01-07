package com.opencsv;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

/**
 * 
 * @author Albert Yu
 * @version 0.1 11-12-15
 */
public class AutoSchedule
{
   
   /**
    * Take a string with commas and spaces in it and returns a list of the
    * separated components.
    * @param str, a string in the format 'xxx, xxxx, xxxx'
    * @return separated, an ArrayList<String>
    */
   private static ArrayList<String> separateByCommas(String str)
   {
      ArrayList<String> separated = new ArrayList<String>();
      StringBuilder currentWord = new StringBuilder();
      int i =0;
      while (i < str.length() - 1)
      {
         String temp = new StringBuilder().append(str.charAt(i)).append(str.charAt(i + 1)).toString();
         if (temp.equals(", "))
         {
            separated.add(currentWord.toString());
            currentWord = new StringBuilder();
            i += 2;
         }
         
         else
         {
            currentWord.append(str.charAt(i));
            i++;
         }
      }
      separated.add(currentWord.append(str.charAt(i)).toString());
      return separated;
   }
   
   
   /**
    * Creates the master schedule which will follow the formatting:
    * Outer key: 'Mon'
    * Inner key: '9 - 9:50 AM'
    * Value: empty ArrayList
    * NOTE: This is NOT the same thing as a Schedule object, where the value 
    * is a boolean, not ArrayList.
    * @return masterSched, a HashMap2D
    */
   private static HashMap2D<String, ArrayList<String>> createMasterSched()
   {
      HashMap2D<String, ArrayList<String>> masterSched = new HashMap2D<String, ArrayList<String>>();
      
      for (int i = 0; i < Schedule.weekdays.length; i++)
      {
         masterSched.put(Schedule.weekdays[i]);
         for (int j = 0; j < Schedule.listOfTimes.length; j++)
         {
            ArrayList<String> emptyArrayList = new ArrayList<String>();
            masterSched.put(Schedule.weekdays[i], Schedule.listOfTimes[j], emptyArrayList);
         }
      }
      return masterSched;
   }
   
   
   /**
    * Stores the rows of the csv file in an ArrayList
    * @param csvFileName, the string containing the name of the csv file
    * @return allRows, an ArrayList containing the rows of csv file
    */
   private static ArrayList<String[]> storeSchedule(String csvFileName)
   {
      ArrayList<String[]> allRows = new ArrayList<String[]>();
      CSVReader reader = null;
      try
      {
         //Get the CSVReader instance with specifying the delimiter to be used
         reader = new CSVReader(new FileReader(csvFileName),',');
         String [] nextLine;
         //Read one line at a time
         while ((nextLine = reader.readNext()) != null)
         {
            //System.out.println(nextLine[0]);
            allRows.add(nextLine);
         }
      }
      catch (Exception e) 
      {
         e.printStackTrace();
      }
      finally 
      {
         try 
         {
            reader.close();
         } 
         catch (IOException e) 
         {
            e.printStackTrace();
         }
      }
      
      return allRows;
   }
   
   /**
    * Uses information from a csv row to create a Schedule object
    * @param row
    * @return sched, a Schedule object
    */
   private static Schedule csvRowToScheduleObj(String[] row)
   {
      Schedule sched = new Schedule();
      
      for (int i = 3; i < row.length; i++)
      {
         sched.put(Schedule.indexToWeekday.get(i));
         ArrayList<String> timesAvail = separateByCommas(row[i]);
         for (int j = 0; j < Schedule.listOfTimes.length; j++)
         {
            if (timesAvail.contains(Schedule.listOfTimes[j]))
            {
               sched.put(Schedule.indexToWeekday.get(i), Schedule.listOfTimes[j], true);
            }
            else
            {
               sched.put(Schedule.indexToWeekday.get(i), Schedule.listOfTimes[j], false);
            }
         }
      }
      
      return sched;
   }
   
   
   public static void main(String[] args)
   {
      HashMap2D<String, ArrayList<String>> masterSched = createMasterSched();
      ArrayList<String[]> storedSched = storeSchedule("sample.csv");
      
      //Skip first row, which contains the column headings
      for (int i = 1; i < storedSched.size(); i++)
      {
         Schedule studentSched = csvRowToScheduleObj(storedSched.get(i));
         Student student = new Student(storedSched.get(i)[1], studentSched);
         
         //Loop over weekdays and times to find out which students are available
         //at a given (weekday, time slot) pair
         for (int j = 0; j < Schedule.weekdays.length; j++)
         {
            for (int k = 0; k < Schedule.listOfTimes.length; k++)
            {
               if (student.schedule.get(Schedule.weekdays[j], Schedule.listOfTimes[k]) == true)
               {
                  masterSched.get(Schedule.weekdays[j], Schedule.listOfTimes[k]).add(student.getName());
                  //System.out.println(Schedule.weekdays[j]);
                  //System.out.println(Schedule.listOfTimes[k]);
                  //System.out.println(masterSched.get(Schedule.weekdays[j], Schedule.listOfTimes[k]));
               }

            }
         }
      }

      for (int i = 0; i < Schedule.weekdays.length; i++)
      {
         System.out.println(Schedule.weekdays[i] + ": ");
         for (int j = 0; j < Schedule.listOfTimes.length; j++)
         {
            System.out.println("Students available at " + Schedule.listOfTimes[j]);
            System.out.println(masterSched.get(Schedule.weekdays[i], Schedule.listOfTimes[j]));
            System.out.println();
         }
      }

      
      
   }
   
}
