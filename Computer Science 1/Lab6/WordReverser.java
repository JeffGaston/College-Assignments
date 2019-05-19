/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: WordReverser.java
   Description: Outputs a given String reversed
   input: String
   output: Reverse of String
*/
import java.util.Scanner;

public class WordReverser{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      String input;
      String output = "";
      
      System.out.print("Enter a word: ");
      input = kb.nextLine();
      
      for(int count= input.length()-1; count >= 0 ;count--){
         output += input.charAt(count);
      }
      
      System.out.println("Reversed: " + output);
   }
}