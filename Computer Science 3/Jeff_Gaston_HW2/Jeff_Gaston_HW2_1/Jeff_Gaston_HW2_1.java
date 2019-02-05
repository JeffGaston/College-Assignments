/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.util.Date;
public class Jeff_Gaston_HW2_1{
   public static String dash= "  -- ";
   public static String str= " |";
   public static String str3= "    |";
   public static String str4= " |   ";
   public static String str5= "     ";
   public static String str2= " |  |";
   public static void main(String[] args){
      //Instantiate a Date object
      Date currentTime= new Date();
      //Display time and date
      String stri= String.format("%tc", currentTime);
      System.out.println(stri);
      
      String stri1= stri.substring(11,16);
      System.out.println();
      
      for(int c= 0; c< 7;c++){
         for(int d= 0; d< 5; d++){
            switch(stri1.charAt(d)){
               case '0': System.out.print(zero(c));break;
               case '1': System.out.print(one(c));break;
               case '2': System.out.print(two(c));break;
               case '3': System.out.print(three(c));break;
               case '4': System.out.print(four(c));break;
               case '5': System.out.print(five(c));break;
               case '6': System.out.print(six(c));break;
               case '7': System.out.print(seven(c));break;
               case '8': System.out.print(eight(c));break;
               case '9': System.out.print(nine(c));break;
               default: System.out.print(colon(c));break;
            }
         }
         System.out.println();
      }
   }
   public static String zero(int a){
      switch(a){
         case 0: return dash;
         case 1: return str2;
         case 2: return str2;
         case 3: return str2;
         case 4: return str2;
         case 5: return str2;
         default: return dash;
      }
   }
   public static String one(int a){
      switch(a){
         case 0: return "  ";
         case 1: return str;
         case 2: return str;
         case 3: return "  ";
         case 4: return str;
         case 5: return str;
         default: return "  ";
      }
   }
   public static String two(int a){
      switch(a){
         case 0: return dash;
         case 1: return str3;
         case 2: return str3;
         case 3: return dash;
         case 4: return str4;
         case 5: return str4;
         default: return dash;
      }
   }
   public static String three(int a){
      switch(a){
         case 0: return dash;
         case 1: return str3;
         case 2: return str3;
         case 3: return dash;
         case 4: return str3;
         case 5: return str3;
         default: return dash;
      }
   }
   public static String four(int a){
      switch(a){
         case 0: return str5;
         case 1: return str2;
         case 2: return str2;
         case 3: return dash;
         case 4: return str3;
         case 5: return str3;
         default: return str5;
      }
   }
   public static String five(int a){
      switch(a){
         case 0: return dash;
         case 1: return str4;
         case 2: return str4;
         case 3: return dash;
         case 4: return str3;
         case 5: return str3;
         default: return dash;
      }
   }
   public static String six(int a){
      switch(a){
         case 0: return dash;
         case 1: return str4;
         case 2: return str4;
         case 3: return dash;
         case 4: return str2;
         case 5: return str2;
         default: return dash;
      }
   }
   public static String seven(int a){
      switch(a){
         case 0: return dash;
         case 1: return str3;
         case 2: return str3;
         case 3: return str3;
         case 4: return str3;
         case 5: return str3;
         default: return str5;
      }
   }
   public static String eight(int a){
      switch(a){
         case 0: return dash;
         case 1: return str2;
         case 2: return str2;
         case 3: return dash;
         case 4: return str2;
         case 5: return str2;
         default: return dash;
      }
   }
   public static String nine(int a){
      switch(a){
         case 0: return dash;
         case 1: return str2;
         case 2: return str2;
         case 3: return dash;
         case 4: return str3;
         case 5: return str3;
         default: return str5;
      }
   }
   public static String colon(int a){
      switch(a){
         case 0: return "    ";
         case 1: return "  - ";
         case 2: return " | |";
         case 3: return "  - ";
         case 4: return "  - ";
         case 5: return " | |";
         default: return"  - ";
      }
   }
}