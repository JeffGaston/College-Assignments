/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Description: A program to introduce using multiple classes
*/

import java.util.Scanner;

public class GbeApp{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      GbeClass gbeObject = new GbeClass();
      
      System.out.println("Please enter a password that meets the following "+
                          "criteriea: "+ 
                          "\nAt least six characters" +
                          "\nAt least one uppercase" +
                          "\nAt least one lowercase" +
                          "\nAt least one digit");
      String temp = kb.next();
      gbeObject.setPass(temp);
      gbeObject.getTest();
   }
}