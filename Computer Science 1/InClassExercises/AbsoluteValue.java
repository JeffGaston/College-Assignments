/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 2/5/2019
   Title: AboutMe.java
   Description: Program that asks the user for an int, and returns the absolute value.
   input: an entered int
   output: abs value of the entered int
*/
import java.util.Scanner;

public class AbsoluteValue{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      int enteredNumber; //number input by the user
      int answer;         //result of abs calculation
      
      //prompt + input
      System.out.print("Enter a number: ");
      enteredNumber = kb.nextInt();
      answer = enteredNumber;
      
      if(enteredNumber < 0){//is entered number negative?
         answer = enteredNumber * -1;
      }
      
      System.out.println("The absolute value of "+ enteredNumber + " is "+ answer);
   }
}