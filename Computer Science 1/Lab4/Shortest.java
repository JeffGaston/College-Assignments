/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/26/2019
   Title: Shortest.java
   Description: Takes three Strings and outputs the number of chars
                in the shortest String
   input: string1, string2, string3
   output: int
*/

import java.util.Scanner;

public class Shortest{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      String string1;
      String string2;
      String string3;
      
      System.out.print("Enter String #1: ");
      string1 = kb.nextLine();
      System.out.print("Enter String #2: ");
      string2 = kb.nextLine();
      System.out.print("Enter String #3: ");
      string3 = kb.nextLine();
      
      if(string1.length() <= string2.length() && string1.length() <= string3.length())
         System.out.println("Number of characters in smallest string: "
                             + string1.length());
      else if(string2.length() <= string1.length() && string2.length() <= string3.length())
         System.out.println("Number of characters in smallest string: " 
                             + string2.length());
      else
         System.out.println("Number of characters in smallest string: "
                             + string3.length());
   }
}