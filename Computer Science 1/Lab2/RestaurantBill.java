/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/7/2019
   Title: RestaurantBill.java
   Description: Calculates the tax on an item.
   input: The cost of an item and the tax rate.
   output: The tax on the item and the item's total cost 
*/

import java.util.Scanner;

public class RestaurantBill{
   public static void main(String[] args){
      
      //Scanner object for reading from keyboard input
      Scanner kb = new Scanner(System.in);
      
      double price;           //item purchased
      double taxRate;         //township tax rate
      double tax;             //computed tax owed
      double total;           //computed grand total
      double tipPercentage;   //user inputted tip percentage
      double tip;             //computed tip
      
      System.out.println("Program to compute tax");
      System.out.println("----------------------");
      
      System.out.print("Enter price of food: ");
      price = kb.nextDouble();
      
      System.out.print("Enter tax rate in percent (e.g. .08 for 8%): ");
      taxRate = kb.nextDouble();
      
      System.out.print("Enter tip percentage (e.g. .15 for 15%): ");
      tipPercentage= kb.nextDouble(); 
      //end of user input
      
      //compute tax and total
      tax = taxRate * price;
      tip = price * tipPercentage;
      total = price + tax + tip;
      
      //output final numbers
      System.out.println("Tax on food is "+ tax);
      System.out.println("Tip is  "+ tip);
      System.out.println("Total price is "+ total);
   }//ends main
}//ends the tax class