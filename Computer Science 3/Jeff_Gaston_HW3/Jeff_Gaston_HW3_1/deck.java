/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.io.*;
public class deck{
   public static String[] suits= {"Spades", "Hearts", "Diamonds", "Clubs"};
   public static String[] values= {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
   public static String[][] cards= new String[4][13];
   public static void inDeck(){
      for(int a= 0; a< 4; a++){
         for(int b= 0; b < 13; b++){
            cards[a][b]= values[b] +" of "+ suits[a];
         }
      }
   }
}
/*
Spades: "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
Hearts: "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
Diamonds: "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
Clubs: "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
*/