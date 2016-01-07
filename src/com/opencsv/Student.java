package com.opencsv;
/**
 * A student with a name and a schedule
 * @author Albert Yu
 * @version 0.1 11-11-15
 */

public class Student
{
   
   private String name;
   private Schedule schedule;

   
   public Student(String fullName, Schedule sched)
   {
      name = fullName;
      schedule = sched;
   }
   
   /**
    * Returns a concatenation of the first and last names of the student.
    * @return a string with the first and last names separated by a space
    */
   public String getName()
   {
      return name;
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
