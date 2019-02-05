/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/

import java.util.Scanner;

public class CoinApp{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      Coin CoinObject = new Coin();
      System.out.print("Without toss, the coin starts off on "+
                        CoinObject.sideUp() + "\n");
      System.out.println("Press '1' if you would like to play coin toss "+
                        "or another number to end");
      
      int in = kb.nextInt();
      
      if(in == 1){
         System.out.println("Press '1' if you think heads comes up the most or"+
                              " '2' if you think tails.");
         int guess = kb.nextInt();
         CoinObject.think2(guess);
         System.out.println("How many tosses would you like? \n");
         int tosses= kb.nextInt();
         System.out.println("Tossing...\n");
         CoinObject.toss(tosses);
      }
      else{
         System.out.println("Aww \n");
      }
      if(in != 1)
         System.out.println("Enjoy your day!");
      else{
         CoinObject.setChart();
         System.out.println(CoinObject.think());
      }
   }
}