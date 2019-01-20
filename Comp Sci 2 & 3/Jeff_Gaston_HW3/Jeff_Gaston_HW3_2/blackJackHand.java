import java.util.Random;
public class blackJackHand extends deck{
   public static Random Rand= new Random();
   public static String[] used= new String[52];
   public static int counter= 0;
   public static int value=0;
   public static String addCard(){
      String card;
      boolean avail;
      
      do {
         avail = true;
         value= Rand.nextInt(13);
         card = cards[Rand.nextInt(4)][value];
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
   public static int cardValue(){
      if(value >= 10){
         value = 10;
      }
      else{
         value+=1;
      }
      return value;
   }
}