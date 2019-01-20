import java.util.Scanner;
public class Jeff_Gaston_HW3_1{
   public static void main(String[] args){
      Scanner kb= new Scanner(System.in);
      dealer d= new dealer();
      d.inDeck();
      
      int in;
      do{
         System.out.print("Please enter an integer(n) between 0 & 10: ");
         in= (kb.nextInt()-1);
      }while(in < (-1) || in > 10);
      
      System.out.println("Here are the hands: ");
      for(int a= 0; a<= in; a++){
         String[] out= new String[5];
         
         for(int b= 0; b < 5; b++){
            out[b] = d.addCard();  
         }
         
         System.out.println("\nHand: "+ (a+1));
         for(String s: out)
            System.out.println(s);
         System.out.println();
      }
   }
}