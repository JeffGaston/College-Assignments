/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 1/29/2019
   Title: AboutMe.java
   Description: Outputs the user's age, initial, name and desired annual income.
   input: none(values are hard-coded)
   output: information about the user
*/

public class AboutMe{
   public static void main(String[] args){
      
      String fullName;     //full name of user
      char firstInitial;   //initial of user
      int age;             //user's age 
      double annualPay;    //user's pay
      
      fullName = "Jeff Gaston";
      firstInitial = 'J';
      age = 21;
      annualPay = 100000.0;
      
      System.out.println("My name is "+ fullName + ", my age is " + age + " and");
      System.out.println("I hope to earn $" + annualPay + " per year. -- " + firstInitial);
   }//ends the main
}//ends the AboutMe class