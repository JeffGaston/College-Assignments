/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/7/2019
   Title: TestAverage.java
   Description: Outputs the average of three test scores.
   input: three test scores
   output: average
*/

import java.util.Scanner;

public class TestAverage{
   public static void main(String[] args){
      
      int test1;
      int test2;
      int test3;
      double average;
      
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Enter grade 1: ");
      test1 = kb.nextInt();
      
      System.out.print("Enter grade 2: ");
      test2 = kb.nextInt();
      
      System.out.print("Enter grade 3: ");
      test3 = kb.nextInt();
      
      average = (test1 + test2 + test3)/3.0;
      
      System.out.println("Average test grade: "+ average);
   }
}