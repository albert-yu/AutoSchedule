package com.opencsv;
/**
 * A student with a name and a schedule
 * @author Albert Yu
 * @version 0.1 11-11-15
 */

public class Student
{
   
   private String firstName;
   private String lastName;
   private Schedule schedule;

   
   public Student(String first, String last)
   {
      firstName = first;
      lastName = last;
      schedule = new Schedule();
      
   }
   
   /**
    * Returns a concatenation of the first and last names of the student.
    * @return a string with the first and last names separated by a space
    */
   public String getName()
   {
      return firstName + " " + lastName;
   }
   
   /**
    * Returns the schedule associated with the student
    * @return Schedule mySchedule
    */
   public Schedule getSchedule()
   {
      return schedule;
   }
   

}
