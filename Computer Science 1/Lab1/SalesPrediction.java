/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 1/29/2019
   Title: SalesPrediction.java
   Description: predicts the total sales of the East Coast division of a company 
                generates at a rate of 62 percent of profits for 4.6 million 
                dollars.
   input: none(values are hard-coded)
   output: The total sales for the East Coast division.
*/

public class SalesPrediction{
   public static void main(String[] args){
      double eastPercentage= 0.62;
      int totalSales= 4600000;
      double eastGenerate = totalSales * eastPercentage;
      
      System.out.println("The total sales will be $" + eastGenerate);
   }
}