/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/16/2019
   Title: WordAnalyzer.java
   Description: Prompts the user to enter a word
                and tracks the largest and smallest words entered.
                Then outputs the words with the greatest and
                the least number of characters, and the average
                length of each word entered.
   input: Strings
   output: longest String, shortest String, and average of all
           inputted strings
*/
import javax.swing.JOptionPane;

public class WordAnalyzer{
   public static void main(String[] args){
      
      String wordInputted;             //Most recently String input
      String longestWord = "";         //Longest String input
      String shortestWord = "";        //Shorstest String input
      int sumOfLengths = 0;            //Sum of length of inputted Strings
      int stringCount = 0;             //Count of Strings inputted
      double averageLength;            //Average of all String inputs
      
      //Get number of words from user
      stringCount = Integer.parseInt(JOptionPane.showInputDialog("How many"
                                                + " words would " +
                                                "you like to enter?"));
      //Loop through number of words
      for(int counter = 1; counter <= stringCount; counter++){
         //Get words
         wordInputted = JOptionPane.showInputDialog("Enter word #" + 
                                                    counter);
         //Keep track of lengths for average                                           
         sumOfLengths += wordInputted.length();
         
         //Check if words are largest or smallest
         if(wordInputted.length() > longestWord.length()){
            longestWord = wordInputted;
            
            if(counter == 1)
               shortestWord = longestWord;
         }
         if(wordInputted.length() < shortestWord.length()){
            shortestWord = wordInputted;
         }
      }
      
      //Calculate average
      averageLength = (double)(sumOfLengths/stringCount);
      
      //Output to user
      JOptionPane.showMessageDialog(null, "The word with the greatest " +
                                          "number of characters: " + 
                                          longestWord + 
                                          "\nThe Word with the least " +
                                          "number of characters: " + 
                                          shortestWord +
                                          "\nThe average length of each " +
                                          "word entered: "+ averageLength);
   }//end of main
}//end of class