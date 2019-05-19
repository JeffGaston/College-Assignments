/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: ConsonantsCounter.java
   Description: Accepts a word entered by the user and outputs
                the number of consonants.
   input: String
   output: number of consonants
*/

import java.util.Scanner;

public class ConsonantCounter{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      String input;
      int consonantsCounter = 0;
      
      System.out.print("Enter word: ");
      input = kb.nextLine().toUpperCase();
      
      for(int counter = 0; counter < input.length(); counter++){
         if(input.charAt(counter) == 'O' || input.charAt(counter) == 'E' ||
            input.charAt(counter) == 'A' || input.charAt(counter) == 'U'){
               consonantsCounter++;
         }
      }
      System.out.println("\nNumber of consonants: " +
                          (input.length() - consonantsCounter));
   }
}