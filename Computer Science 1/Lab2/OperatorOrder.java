/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/7/2019
   Title: OperatorOrder.java
   Description: Solves arithmetic equations 2a^2 + 4a - 29 and (4c +ac)/ 3b
   input: three integers
   output: results
*/

import java.util.Scanner;

public class OperatorOrder{
   public static void main(String[] args){
      Scanner kb= new Scanner(System.in);
      
      int a;
      int b;
      int c;
      double value1;
      double value2;
      
      System.out.print("Enter the value for variable a: ");
      a = kb.nextInt();
      
      System.out.print("Enter the value for variable b: ");
      b = kb.nextInt();
      
      System.out.print("Enter the value for variable c: ");
      c = kb.nextInt();
      
      value1 = 2*(a*a) + 4*a - 29;
      value2= (4*c + a*c)/ 3.0*b;
      
      System.out.println("Answer for the first equation is:" + value1);
      System.out.println("Answer for the second equation is: "+ value2);
   }
}