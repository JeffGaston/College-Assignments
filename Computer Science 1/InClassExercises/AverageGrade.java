/*
Name: Jeff Gaston
Date: 4/2/19
Title: AverageGrade.java
Description: Program that repeatedly asks the user for a grade, loops 5 times,
             and outputs the average.
Input: Five grades
Ouput: Average grade
*/

import java.util.Scanner;

public class AverageGrade{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      final int NUM_GRADES = 5;
      
      int i;   // counting variable
      int grade; // last grade input by the user
      int sum = 0;    // running total of the sum of all grades entered so far
      
      for(i = 1; i <= NUM_GRADES; i++){
         System.out.print("Enter grade: ");
         grade = kb.nextInt();
         sum += grade;
      }
      System.out.println("Average grade: " + ((double) sum/NUM_GRADES));
   }
}