/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 3/12/2019
   Title: StringMethods2.java
   Description: A program that demonstrates the capabilities of the
                String methods that we covered in class
   input: User's full name
   output: Name with 'Mc' if it doesn't it doesn't already have it.
*/

import java.util.Scanner;

public class StringMethods2{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      String name;
      String firstName;
      String lastName;
      String irishLastName;
      String mcSearch;
      
      System.out.print("Enter full name: ");
      name = kb.nextLine();
      
      firstName = name.substring(0, name.indexOf(" "));
      lastName = name.substring(name.indexOf(" ")+ 1, name.length());
      mcSearch = lastName.substring(0,2);
      
      if(mcSearch.equals("Mc"))
         System.out.println("Irish name: "+ name);
      else{
         irishLastName = "Mc" + lastName;
         System.out.println("Irish Name: "+ firstName + " "+ irishLastName);
      }
   }
}