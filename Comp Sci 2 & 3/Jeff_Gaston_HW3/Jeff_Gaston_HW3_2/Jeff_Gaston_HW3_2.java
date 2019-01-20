import java.util.Random;
public class Jeff_Gaston_HW3_2{
   public static void main(String[] args){
      Random rand= new Random();
      blackJackHand b= new blackJackHand();
      b.inDeck();
      
      int sum= (21- rand.nextInt(6));
      int sum2= 0;
      int counter= 0;
      String[] player= new String[10];
      
      System.out.println(sum);
      do{
         player[counter]= b.addCard();
         int buff= b.cardValue();
         sum2+= buff;
         counter++;
         if((counter== 1) && (buff== 1)){
            sum2= 11;
         }
         if((counter == 2) && (sum== 10) && (buff == 1)){
            sum2= 21;
         }
      }while(sum2 <=  sum);
      
      for(String s: player){
         if(s== null){
            break;
         }
         else{
            System.out.print(s +", ");
         }
      }
      System.out.print("\nSummation is: "+ sum2);
   }
}