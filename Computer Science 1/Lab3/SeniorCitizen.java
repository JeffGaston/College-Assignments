/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: SeniorCitizen.java
   Description: Program that asks user age and outputs whether they are a senior citizen
   input: age
   output: String if senior citizen
*/

import java.util.Scanner;

public class SeniorCitizen{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      int age;
      
      System.out.print("Enter age: ");
      age= kb.nextInt();
      
      if(age < 0)
         System.out.println("ERROR: negative age");
      else if(age < 65)
         System.out.println("You are not a senior citizen.");
      else 
         System.out.println("You are a senior citizen.");
   }
}