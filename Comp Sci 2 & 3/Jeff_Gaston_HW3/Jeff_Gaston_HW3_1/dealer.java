import java.util.Random;

public class dealer extends deck{
   public static Random Rand= new Random();
   public static String[] used= new String[52];
   public static int counter= 0;
   
   public static String addCard(){
      String card;
      boolean avail;
      
      do {
         avail = true;
         card = cards[Rand.nextInt(4)][Rand.nextInt(13)];
         for(String s: used){
           if(s == null) {
               avail = true;
            }
            if(card.equals(s)){
               avail= false;
            }
         }
      }while(!avail);
      
      used[counter]= card;
      counter++;
      return card;
   }
}