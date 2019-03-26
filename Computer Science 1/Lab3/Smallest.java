/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: Smallest.java
   Description: Takes three numbers and outputs the smallest
   input: num1, num2, num3
   output: smallest number
*/

import java.util.Scanner;

public class Smallest{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int num1;
      int num2;
      int num3;
      
      System.out.print("Enter number #1: ");
      num1 = kb.nextInt();
      System.out.print("Enter number #2: ");
      num2 = kb.nextInt();
      System.out.print("Enter number #3: ");
      num3 = kb.nextInt();
      
      if(num1 <= num2 && num1 <= num3)
         System.out.println("Smallest number: "+ num1);
      else if(num2 <= num1 && num2 <= num3)
         System.out.println("Smallest number: "+ num2);
      else
         System.out.println("Smallest number: "+ num3);
   }
}