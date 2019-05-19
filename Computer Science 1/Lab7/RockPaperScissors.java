/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 5/2/2019
   Title: RockPaperScissors.java
   Description: Game of Rock, Paper, Scissors between two users
                using methods to build the game.
   Input: String ("rock", "paper", or "scissors")
   Ouput: String victor
*/

import java.util.Scanner;

public class RockPaperScissors{
   
   static Scanner kb= new Scanner(System.in);
   
   // returns the player's move, where p is either 1 or 2 (representing player1 and player2)
   public static String getPlayerChoice(int player){
      String choice;
      
      System.out.print("Enter move (rock, paper, scissors), player "
                   + player + ": ");
      choice = kb.nextLine();
      
      while(!(isValid(choice))){
         System.out.println("INVALID MOVE! Please re-enter.");
         System.out.print("Enter move (rock, paper, scissors), player "
                      + player + ": ");
         choice = kb.nextLine();         
      }
      
      return choice;
   }
   // returns true if the user's entered move is valid
   // returns false otherwise
   public static boolean isValid(String userChoice){
      
      if(userChoice.equals("rock")){
         return true;
      }
      else if(userChoice.equals("scissors")){
         return true;
      }
      else if(userChoice.equals("paper")){
         return true;
      }
      else{
         return false;
      }
   }
   // outputs who won, e.g. "Game is a tie!", "P1 wins!", or "P2 wins!"
   public static void displayOutcome(String choice1, String choice2){
      String p1 = "P1 wins!";
      String p2 = "P2 wins!";
      String p3 = "Game is a tie!";
      String output;
      
      switch(choice1){
         case "rock":
            if(choice2.equals("paper"))
               output = p2;
            else if(choice2.equals("scissors"))
               output = p1;
            else 
               output = p3;
            break;
         case "scissors":
            if(choice2.equals("paper"))
               output = p1;
            else if(choice2.equals("rock"))
               output = p2;
            else 
               output = p3;
            break;
          case "paper":
            if(choice2.equals("rock"))
               output = p1;
            else if(choice2.equals("scissors"))
               output = p2;
            else 
               output = p3;
            break;
          default :
            output = p3;
      }
      System.out.println(output);
   }
   public static void main(String[] args){
      String p1Choice;
      String p2Choice;
      
      
      p1Choice = getPlayerChoice(1);
      p2Choice = getPlayerChoice(2);
      
      displayOutcome(p1Choice, p2Choice);
   }
}