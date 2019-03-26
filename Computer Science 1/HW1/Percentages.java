/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: Percentages.java
   Description: This program asks the user for number of males and number of females
                registered in a class. Then displays the percentage of males and
                females. If a percent exceeds 85% then it outputs 
                "That is a lopsided percentage!"
   input: number of males, number of females
   output: percent of males and percent of females
*/

import java.util.Scanner;

public class Percentages{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int males;                       //number of males
      int females;                     //number of females     
      double sum;                      //Total of males and females
      double percentOfMales;
      double percentOfFemales;
      
      System.out.print("Enter number of males: ");
      males = kb.nextInt();
      
      System.out.print("Enter number of females: ");
      females = kb.nextInt();
      
      sum = males + females;           //calculates total
      
      percentOfMales = (males/sum) *100;   //calculate class percent of males
      percentOfFemales = (females/sum) *100;//class percent of females
      
      System.out.println("The percentage of male is "+ percentOfMales +"%");
      System.out.println("The percentage of females is "
                          + percentOfFemales + "%");
      
      if(percentOfMales >= 85 || percentOfFemales >= 85) //checks if lopsided
         System.out.println("That is a lopsided percentage!");
         
   }//end of main
}//end of class