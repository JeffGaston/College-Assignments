/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/

import java.util.Random;

public class Coin{
   private int side[] = {0, 0};
   private int yolo;
   Random rand = new Random();
   
   public String sideUp(){
      if(rand.nextInt(2) == 0)
         return "heads";
      else
         return "tails";
   }
   public void toss(int flips){
      for(int count = 0; count < flips; count++){
         sideUp();
         System.out.println(sideUp());
         
         if(sideUp() == "heads")
            ++side[0];
         else
            ++side[1];
      }
   }
   public void setChart(){
      System.out.println("Heads\tTails");
      System.out.println(side[0] +"\t" + side[1]);
   }
   public void think2(int thought){
      yolo = thought;
   }
   public String think(){
      if(side[0] > side[1] && yolo == 1)
         return "You guessed correctly!";
      if(side[1] > side[0] && yolo == 2)
         return "You guess correctly!";
      if(side[1] == side[0])
         return "Tie!";
      else
         return "Yeah, you guessed wrong. Better luck next time!";
   }
}