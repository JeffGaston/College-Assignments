/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: Olympic.java
   Description: Program that gets a users time and outputs their placing
   input: (double) time
   output: (String) what they won
*/
import java.util.Scanner;

public class Olympic{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Enter time: ");
      double time = kb.nextDouble(); //time to complete the race
      
      if(time <= 4.5){
         System.out.println("Gold");
      }
      else if(time <= 9.2)
         System.out.println("Silver");
      else if(time <= 14.5){
         System.out.println("Bronze");
      }
      else{
         System.out.println("Did not place");
      }
   }
}