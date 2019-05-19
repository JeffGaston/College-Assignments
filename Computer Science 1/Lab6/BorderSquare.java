/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/5/2019
   Title: BorderSquare.java
   Description: Draws outline of a rectangle pf asterisks
                based on inputed size
   input: Size
   output: Outline of rectangle
*/
import java.util.Scanner;

public class BorderSquare{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int input;
      
      System.out.print("Enter a size: ");
      input = kb.nextInt();
      
      for(int height = 1; height <= input; height++){
         for(int width = 1; width <= input; width++){
            if(height == 1 || height == input)
               System.out.print("*");
            else if((width == 1 || width == input))
               System.out.print("*");
            else
               System.out.print(" ");
         }
         System.out.println();
      }
   }
}