/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: SoftwareSales.java
   Description: Calculates a user's discount
   input: number of packages, price of each item
   output: percentage discount, price before discount, amount of discount, final price
*/

import java.util.Scanner;

public class SoftwareSales{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int quant;
      double price;
      double discPerc = 0;
      
      System.out.print("Unit price: ");
      price = kb.nextDouble();
      
      System.out.print("Quantity: ");
      quant = kb.nextInt();
      
      double totalPrice = quant * price;
      
      if(quant >= 10 && quant < 19){
         discPerc = .20;
      }
      else if(quant > 20 && quant < 49){
         discPerc = .30;
      }
      else if(quant > 50 && quant < 99){
         discPerc = .40;
      }
      else if(quant > 99){
         discPerc = .50;
      }
      
      System.out.println("Applied discount percentage: "+ discPerc* 100 + "%");
      System.out.println("Total price before discount: "+ totalPrice);
      System.out.println("Amount of the discount: "+ (totalPrice * discPerc));
      System.out.println("Final price: "+ totalPrice *(1 - discPerc));
   }
}