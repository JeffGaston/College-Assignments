/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 4/7/2019
   Title: Seasons.java
   Description: Output the season of an inputed date using a 
   single JOptionPane input box to prompt the user to enter 
   a date in the form Month Day, such as March 28. 
   input: Month, Day
   output: season
*/

import javax.swing.JOptionPane;

public class Seasons{
   public static void main(String[] args){
      
      String ioMonDay;     //User inputted Month and day
      String month;        //Program substring calculated Month
      int day;             //Program substring calcualted day
      
      // Get user input
      ioMonDay = JOptionPane.showInputDialog("Input a Month "+
                                                  "and a day");
      
      // Seperate month and day
      month =ioMonDay.substring(0, ioMonDay.indexOf(" "));
      day = Integer.parseInt(ioMonDay.substring(ioMonDay.indexOf(" ")+1,
                             ioMonDay.length()));
        
      // Find and output season
      if(month.equals("April") || month.equals("May") ||
         (month.equals("June") && day <= 20) || (month.equals("March")
         && day >= 21)){
            //output season
            JOptionPane.showMessageDialog(null, "Spring"); 
      } 
      else if(month.equals("July") || month.equals("August") ||
         (month.equals("September") && day <= 20) || (month.equals("June")
         && day >= 21)){
            //output season
            JOptionPane.showMessageDialog(null, "Summer"); 
      } 
      else if(month.equals("October") || month.equals("November") ||
         (month.equals("December") && day <= 20) || (month.equals("September")
         && day >= 21)){
            //output season
            JOptionPane.showMessageDialog(null, "Fall"); 
      }
      else{
         JOptionPane.showMessageDialog(null, "Winter");
      }
   }//end of main
}//end of class