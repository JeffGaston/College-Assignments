/*
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
public class Payroll{
   public static void main(String[] args){
      int hours;
      double payRate;
      double grossPay;
      
      //assigning initial vlaues
      hours = 40;
      payRate = 25.0;
      
      //calculation/
      grossPay = hours * payRate;
      
      //display output
      System.out.println("Your gross pay is $" + grossPay); 
   }
}