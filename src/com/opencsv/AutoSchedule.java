package com.opencsv;

import java.util.ArrayList;
import java.util.HashMap;
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
    * The students in a given section
    */
   private static ArrayList<Student> students;
   
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
      while (i < str.length())
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
      separated.add(currentWord.toString());
      return separated;
   }
   
   /**
    * Creates the master schedule which will follow the formatting:
    * Outer key: 'Mon'
    * Inner key: '9 - 9:50 AM'
    * Value: empty ArrayList
    * @return masterSched, a HashMap2D
    */
   private HashMap2D<String, ArrayList<String>> createMasterSched()
   {
      HashMap2D<String, ArrayList<String>> masterSched = new HashMap2D<String, ArrayList<String>>();
      ArrayList<String> emptyArrayList = new ArrayList<String>();
      for (int i = 0; i < Schedule.weekdays.length; i++)
      {
         masterSched.put(Schedule.weekdays[i]);
         for (int j = 0; j < Schedule.listOfTimes.length; j++)
         {
            masterSched.put(Schedule.weekdays[i], Schedule.listOfTimes[j], emptyArrayList);
         }
      }
      return masterSched;
   }
   
   public static void main(String[] args)
   {
      CSVReader reader = null;
      try
      {
          //Get the CSVReader instance with specifying the delimiter to be used
          reader = new CSVReader(new FileReader("sample.csv"),',');
          String [] nextLine;
          //Read one line at a time
          while ((nextLine = reader.readNext()) != null)
          {
              for(String token : nextLine)
              {
                  //Print all tokens
                  System.out.println(token);
              }
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
      
   }
   
}
