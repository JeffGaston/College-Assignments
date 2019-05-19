/*
   Name: Jeff Gaston
   Date: 1/31/2019
   Title: PayrollInput.java
   Description: A program for calculating the weekly earnings
                of an employee
   Input: name, hours worked, pay rate
   Ouput: weekly earnings
*/

import java.util.Scanner;
public class PayrollInput{
   public static void main(String[] args){
      Scanner keyboard= new Scanner(System.in);
      
      int hours;
      double payRate;
      String employeeName;
      
      System.out.print("Enter your name: ");
      employeeName = keyboard.nextLine();
      
      System.out.print("Enter hours worked: ");
      hours = keyboard.nextInt();
      
      System.out.print("Enter your pay rate: ");
      payRate = keyboard.nextDouble();
      
      double weeklyEarnings;
      weeklyEarnings = hours * payRate;
      
      System.out.println(employeeName + ", you earned $"+ weeklyEarnings+
                         " last week");
   }
}