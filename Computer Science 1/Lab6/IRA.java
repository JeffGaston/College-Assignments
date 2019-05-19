/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: IRA.java
   Description: Given a $2000 and an interest rate of %8
                per year, calculates when an IRA is worth
                1 million.
   input: none
   output: sum of integers
*/

public class IRA{
   public static void main(String[] args){
      
      int age = 22;
      double IRABalance = 0.00;
      
      while (IRABalance < 1000000){
         age++;
         IRABalance += (IRABalance* .08);
         IRABalance += 2000;
      }
      System.out.printf("Age: %d Balance: $%.2f", age, IRABalance);
   }
}