/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 3/12/2019
   Title: GradeSwitch.java
   Description: A program that uses a switch statement to print out
                letter grades
   input: grade
   output: letter grade
*/

import java.util.Scanner;

public class GradeSwitch{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int grade;
      int dividedGrade;                // grade/10
      char letterGrade;
      
      System.out.print("Enter grade: ");
      grade = kb.nextInt();
      
      dividedGrade = (int)(grade/10);
      
      switch(dividedGrade){
         case 10:
            letterGrade = 'A';
            break;
         case 9:
            letterGrade = 'A';
            break;
         case 8:
            letterGrade = 'B';
            break;
         case 7:
            letterGrade = 'C';
            break;
         case 6:
            letterGrade = 'D';
            break;
         default:
            letterGrade = 'F';
            break;
      }
      
      System.out.println("Letter grade is " + letterGrade);
   }
}