/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 1/29/2019
   Title: StarPattern.java
   Description: Adds, subtracts, multiplies, performs integer division on 2 numbers
   input: none(values are hard-coded)
   output: The result of adding, subtracting, multiplying, dividing 2 numbers
*/

public class ArithmeticExpressions{
   public static void main(String[] args){
      int first;     //first integer
      int second;    //second integer
      int result;    //result of mathematical operation
      
      first = 10;
      second = 9;
      
      result = first + second;
      System.out.println("The value of " + first + " + " + second
                           + " is " + result);
      result = first - second;
      System.out.println("The value of " + first + " - " + second
                           + " is " + result);
      result = first * second;
      System.out.println("The value of " + first + " * " + second
                           + " is " + result);
      result = first / second;
      System.out.println("The value of " + first + " / " + second
                           + " is " + result);
   }//ends the main
}//ends the ArithmeticExpression class