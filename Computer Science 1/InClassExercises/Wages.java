/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 1/29/2019
   Title: Wages.java
   Description: Program that calculates pay based on an individual's
                hourly wage and number of hours worked.
   input: hourly wage, number of hours worked
   output: weekly earnings
*/
public class Wages{
   public static void main(String[] args){
      int regularHours; //Number of "normal" hours worked last week
      int overtimeHours; //number of OT hours worked last week
      
      regularHours = 40;
      overtimeHours = 5;
      
      double normalHourlyPay;
      double overtimeHourlyPay;
      
      normalHourlyPay = 12.50;
      overtimeHourlyPay = 23.80;
      
      double normalWages; //How much money somoene made from "normal" hours alone
      double overtimeWages; //How much money someone made from the OT hours
      //normalWages = 40 * 12.50;
      normalWages = regularHours * normalHourlyPay;
      overtimeWages = overtimeHours * overtimeHourlyPay;
      
      double totalWages; //combined money made last week
      totalWages = normalWages + overtimeWages;
      
      System.out.println("You made $" + totalWages +" last week.");
   }
}