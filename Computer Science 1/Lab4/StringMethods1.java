/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 3/12/2019
   Title: StringMethods1.java
   Description: A program that demonstrates the capabilities of the
                String methods that we covered in class
   input: User's full name
   output: length of full name, first name, last name,
           first name uppercased, last name uppercased,
           the letter number of the first i in the name
           or error message if there is no i
*/

import java.util.Scanner;

public class StringMethods1{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      String name;
      String firstNameUpperCase;
      String lastNameLowerCase;
      char firstChar;
      char lastChar;
      int nameLength;
      int firstILetterNumber;
      int indexOfSpace;
      
      System.out.print("Enter full name: ");
      name = kb.nextLine();
      
      indexOfSpace = name.indexOf(" ");
      firstNameUpperCase = name.substring(0,indexOfSpace).toUpperCase();
      lastNameLowerCase = name.substring(indexOfSpace,name.length()).toLowerCase();
      
      System.out.println("Length: "+ (name.length()));
      System.out.println("First character: "+ name.substring(0,1));
      System.out.println("Last character: "+ name.charAt(name.length()-1));
      System.out.println("First name capitalized: "+ firstNameUpperCase);
      System.out.println("Last name lowercased: "+ lastNameLowerCase);
      
      if(name.indexOf('i') == -1){
         System.out.println("First i: no i exists");
      }
      else{
         firstILetterNumber = name.indexOf('i') +1;
         System.out.println("First i: letter number "+ firstILetterNumber);
      }
   }
}