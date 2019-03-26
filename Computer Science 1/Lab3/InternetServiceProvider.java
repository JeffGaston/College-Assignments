/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: InternetServiceProvider.java
   Description: Calculates a customer's monthly bill based on a hard coded
                subscription package
   input: package number, and hoursUsed
   output: total charges for the month
*/

import java.util.Scanner;

public class InternetServiceProvider{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int pack;
      double hoursUsed;
      double bill;
      
      System.out.print("Package number: ");
      pack = kb.nextInt();
      
      System.out.print("Hours: ");
      hoursUsed = kb.nextDouble();
      
      if(pack == 1){
         bill = 9.95;
         
         if(hoursUsed > 10)
            bill= (hoursUsed - 10)* 2 + 9.95;
            
         System.out.println("Total cost: $"+ bill);
      }
      else if(pack == 2){
         bill= 13.95;
         
         if(hoursUsed > 20)
            bill = (hoursUsed - 20) + 13.95;
            
         System.out.println("Total cost: $"+ bill);
      }
      else if(pack == 3){
         System.out.println("Total cost: $19.95");
      }
      else
         System.out.println("Invalid package");
   }
}