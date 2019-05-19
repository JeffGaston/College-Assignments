/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: ForLoopSummer.java
   Description: Using a for loop, calculates the sum of integers
                inputed by the user.
   input: amount of input, k-amount of integers
   output: sum of integers
*/
import java.util.Scanner;

public class ForLoopSumer{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int input;
      int sum = 0;
      
      System.out.print("How many numbers would you like to enter? ");
      input = kb.nextInt();
      
      System.out.println("\nNow enter your numbers.");
      for(int counter = 1; counter <= input; counter++){
         System.out.print("Number #" + counter + ": ");
         sum += kb.nextInt();
      }
      
      System.out.println("\nSum of the "+ input+ " numbers: "+ sum);
   }
}