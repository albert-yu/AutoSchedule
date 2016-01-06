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
    * The students in a given section
    */
   private static ArrayList<Student> students;
   
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
