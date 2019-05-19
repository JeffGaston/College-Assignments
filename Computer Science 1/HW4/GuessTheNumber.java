/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/27/2019
   Title: GuessTheNumber.java
   Description: A "number guessing" game using the Random class
                in the Java API. The program picks a number 
                from 1-100 and gives user 7 attempts at guessing
                the number. Program will output whether the number is
                higher or lower after every guess. 
   input: Guess
   output: output String higher, lower, lost, or win
*/
import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber{
   public static void main(String[] args){
      Random rand = new Random();
      
      boolean guessing = true;   // Checks if user is still guessing
      int userGuess = 0;         // User's guess
      int number;                // Program generated number 1-100
      int guessCount = 1;        // Amount of guesses the user has made
      
      number = 1 + rand.nextInt(100); // Gets number to guess

      do{
         // Get user's guess and check if it's not within the parameters
         do{
         userGuess = Integer.parseInt(JOptionPane.showInputDialog("Enter"
                                                 + " a number 1-100 "
                                                 + ". Guess # " +guessCount
                                                 + ":"));
         }while(userGuess < 1 || userGuess > 100);

         // Check if userGuess is higher, lower, or equal to number
         if(userGuess < number && guessCount < 7){
            JOptionPane.showMessageDialog(null, "Guess a higher number");
            ++guessCount;
         }
         else if(userGuess > number && guessCount < 7){
            JOptionPane.showMessageDialog(null, "Guess a lower number");
            ++guessCount;
         }
         else if(userGuess == number && guessCount < 7){
            JOptionPane.showMessageDialog(null, "Congratualations, you"
                                          + " guessed correctly!");
            guessing = false;
         }
         else{
            JOptionPane.showMessageDialog(null,"You did not guess the"
                                               + " number. It was "
                                               + number
                                               + " better luck next time"
                                               + "!");
            guessing = false;
         }
      }while(guessing);
   }//end of main
}//end of class