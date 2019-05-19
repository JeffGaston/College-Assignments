/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 1/29/2019
   Title: WagesConditional.java
   Description: Program that calculates weekly earnings, with a consideration for
                time-and-a-half- OT pay.
   input: hours worked, hourly wage
   output: weekly earnings
*/

import java.util.Scanner;

public class WagesConditional{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      int hours;              //number of hours worked
      double hourlyWage;      //pay per hour
      double weeklyEarning;
      
      System.out.print("Enter hours worked: ");
      hours = kb.nextInt();
      
      System.out.print("Enter hourly wage: ");
      hourlyWage = kb.nextDouble();
      
      if(hours <= 40){        //no OT
         weeklyEarning = hours * hourlyWage;
      }
      else{                 //OT
         weeklyEarning = 40 * hourlyWage + (hours -40) * (hourlyWage * 1.5);
      }
   }
}