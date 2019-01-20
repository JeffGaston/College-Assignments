import java.util.*;

public class Assignment1
{

  public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String longNumber;
        int maxWidth= 0;
        long carry= 0;
        long sum= 0;
        String tString= "";
        long tLong= 0;
        LinkedList mainList = new LinkedList();
        LinkedList sumList = new LinkedList();
        LinkedList temp = null;
        
        System.out.print("Enter long numbers and input -1 to stop\n");
        do{
         longNumber= kb.nextLine();
         
         if(longNumber.equals("-1"))
            break;
         
         if(longNumber.length() > maxWidth){
            maxWidth = longNumber.length();
         }
         
			mainList.addFirst(new LinkedList());
			temp = (LinkedList) mainList.get(0);

				for (int a = 0; a < longNumber.length(); a++) {
					temp.addFirst(Character.getNumericValue(longNumber.charAt(a)));
				}
        }while(!longNumber.equals("-1"));
        	
        
         System.out.println(mainList);
          	
		   for (int b = 0; b < maxWidth; b++) {
			   sum = 0;
			
			   for (int c = 0; c < mainList.size(); c++) {
				   temp = (LinkedList) mainList.get(c);

				   
				   if (!temp.isEmpty()) {
					   tString = temp.pollFirst().toString().replace("[", "").replace("]","");
					   tLong = Long.parseLong(tString);
        
					   sum = tLong + sum;
				   }
			   }

			   sum+=carry;
			   long i = sum % 10;
			   carry = sum / 10;
			   sumList.addLast(i);
		     }
		   
		      if(carry > 0)
			      sumList.addLast(carry);
		   
		      tString = "";
		      for (int d = sumList.size(); d > 0; d--) {
			      tString = tString + sumList.get(d - 1).toString().replace("[", "").replace("]","");
		      }
		  
		      char ifzero = tString.charAt(0);

		      if (ifzero == '0') {
			      tString = tString.substring(1); 
		      }

		      System.out.println("Sum: " + tString);
          

    }//end main
}//end class