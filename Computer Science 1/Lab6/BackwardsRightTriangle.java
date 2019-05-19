/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: BackwardsRightTriangle.java
   Description: Uses two nested for loops to draw backwards
                right triangle of specified size and 
                using specified character.
   input: Size and character
   output: Triangle
*/
import java.util.Scanner;

public class BackwardsRightTriangle{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      char userChar;
      int size;
      
      System.out.print("Enter a symbol: ");
      userChar = kb.nextLine().charAt(0);
      
      System.out.print("Enter a size: ");
      size = kb.nextInt();
      
      for(int height = 0; height < size; height++){
         for(int width = height; width < size; width++){
            System.out.print(userChar);
         }
         System.out.println();
      }
   }
}