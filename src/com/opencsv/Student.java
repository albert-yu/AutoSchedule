package com.opencsv;
/**
 * A student with a name and a schedule
 * @author Albert Yu
 * @version 0.1 11-11-15
 */

public class Student
{
   
   private String name;
   public Schedule schedule;

   
   public Student(String fullName, Schedule sched)
   {
      name = fullName;
      schedule = sched;
   }
   
   /**
    * Returns the name of the student
    * @return name, a string 
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
