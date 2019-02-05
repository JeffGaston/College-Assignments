/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Description: A program to introduce using multiple classes
*/

import java.lang.*;

public class GbeClass{
   private String password;
   private static int u[] = {0, 0, 0, 0};
   public void setPass(String yolo){
      password = yolo;
      test();
   }
   public void test(){
      for(int x = 0; x <= password.length(); x++){
         if(Character.isUpperCase(password.charAt(x)))
            u[0]++;
         else if(Character.isLowerCase(password.charAt(x)))
            u[1]++;
         else if(Character.isLowerCase(password.charAt(x)))
            u[2]++;
         else
            u[3]++;
      }
   }
   public void getTest(){
      if(password.length() < 6)
         System.out.println("The password must be 6 characters or more in length.");
      if(u[0] == 0)
         System.out.println("The password must contain an uppercase letter.");
      if(u[1] == 0)
         System.out.println("The password must contain a lowercase letter.");
      if(u[2] == 0)
         System.out.println("The password must contain a digit.");
      else
         System.out.println("The password meets the criteria!");
   }
}