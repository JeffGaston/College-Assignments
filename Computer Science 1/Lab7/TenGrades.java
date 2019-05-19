/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 5/2/2019
   Title: TenGrades.java
   Description: Outputs the minimum value, maximum value, and average of
                10 exam grades (between 0 and 100) from keyboard.
   Input: int grades
   Ouput: Double minimum, Double maximum, Double average
*/

import java.util.Scanner;

public class TenGrades{
   public static Scanner kb = new Scanner(System.in);
   
   public static int getValue(){
      int value = -1;
      
      System.out.print("Enter number: ");
      value = kb.nextInt();
      
      while(value < 0 || value > 100){
         System.out.println("Grade out of range. Please re-enter.");
         System.out.print("Enter number: ");
         value = kb.nextInt();
      }
      
      return value;
   }
   public static int minimum(int grade, int lowest){
      if(grade < lowest)
         return grade;
         
      else 
         return lowest;
   }
   public static int maximum(int grade, int highest){
      if(grade > highest)
         return grade;
      else
         return highest;
   }
   public static double calcAverage(int sum, int total){
      double average = (((double)sum)/total);
      return average;
   }
   public static void displayResult(int highest, int lowest, double average){
      System.out.print("The largest number is " + highest + ", the smallest number"
                      + " is " + lowest + ", and the average of the numbers is " 
                      + average);
   }
   public static void main(String[] args){
      // we're reading in ten grades
      final int NUM_GRADES = 10;
   
      // want to start lowest grade seen so far at
      // a very high number
      int lowest = Integer.MAX_VALUE;
   
      // start highest grade at a low number
      int highest = Integer.MIN_VALUE;
   
      double average;  // average of entered grades
      int sum = 0;     // running total
   
      // loop to enter grades
      for (int i = 1; i <= NUM_GRADES; i++)
      {
         int grade = getValue();  // next grade
   
         // is there a new lowest grade?
         lowest = minimum(grade, lowest);
         highest = maximum(grade, highest);
   
         // add current grade to the sum
         sum += grade;
      }
   
      // determine average
      average = calcAverage(sum, NUM_GRADES);
      // output answers
      displayResult(highest, lowest, average);
   }
}