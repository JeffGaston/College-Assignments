
/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: TemperatureConversion.java
   Description: A program to print out a conversion table
   input: temperature range
   output: The conversion table between ranges
           of the conversion between fahrenheit and celsius
*/
import java.util.Scanner;

public class TemperatureConversion{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int startTemp;
      int endTemp;
      
      int farenheit;
      double celsius;
      
      System.out.print("Enter start temperature: ");
      startTemp = kb.nextInt();
      
      System.out.print("Enter end temperature: ");
      endTemp = kb.nextInt();
      
      System.out.println("Table of temperatures");
      System.out.println("F \t\t\t\t  C");
      
      for(farenheit = startTemp; farenheit <= endTemp; farenheit++){
         if((farenheit - startTemp) % 5 == 0)
            System.out.println("-----\t\t\t  -----");
         celsius = (double)(farenheit - 32) * 5/9;
         System.out.println(farenheit + "\t\t\t\t  " + celsius);
         
         if((farenheit == endTemp))
            System.out.println("-----\t\t\t  -----");
      }
   }
}
