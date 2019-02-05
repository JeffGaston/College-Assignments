/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.util.Scanner;
public class Jeff_Gaston_HW2_2{
   public static boolean leap= true;
   public static void main(String[] args){
      Scanner kb= new Scanner(System.in);
      
      int c=0;
      
      System.out.print("Enter an integer for the month (1-12): ");
      int mon= kb.nextInt();
      
      System.out.print("Enter a year: ");
      int year= kb.nextInt();
      System.out.println();
      
      leapYearCalc(year);
      int fDay= firstDay(mon, year);
      int dMon= Days(mon);
      
      System.out.println(Month(mon) +"\t"+ year);
      System.out.println(" S\t M\tTu\t W\tTh\t F\t S\n");
      
      for(int a= 0; a< fDay; a++){
         System.out.print("\t");
      }
      for(int b=1; b<= dMon; b++){
         if(b==1)
            c= fDay;
         if(c==7){
            System.out.print("\n");
            c=0;
         }
         System.out.printf("%2d ", b);
         c++;
      }
   }
   public static String Month(int x){
      switch(x){
         case 1: return "January";
         case 2: return "February";
         case 3: return "March";
         case 4: return "April";
         case 5: return "May";
         case 6: return "June";
         case 7: return "July";
         case 8: return "August";
         case 9: return "September";
         case 10: return "October";
         case 11: return "November";
         case 12: return "December";
         default: return "Invalid month";
      }
   }
   public static int firstDay(int M, int Y){
      int y = Y - (14 - M) / 12;
      int x = y + y/4 - y/100 + y/400;
      int m = M + 12 * ((14 - M) / 12) - 2;
      int d = (x + (31*m)/12) % 7;
      if(d== 6)
         return 0;
      else
         return d+1;
   }
   public static int Days(int y){
      if(y== 2 && leap== false)
         return 28;
      else if(y==2 && leap== true)
         return 29;
      else if(y== 4 || y== 6 || y== 9 || y== 11)
         return 30;
      else if(y== 1 || y== 3 || y== 5 || y== 7 || y== 8 || y== 10 || y== 12)
         return 31;
      else
         return 0;
   }
   public static void leapYearCalc(int y2){
      if((y2% 4 != 0) || (y2% 400 != 0))
          leap = false;
   }
}