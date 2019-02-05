/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.io.*;
import java.util.*;
public class InternetUsers{
   static String arr[] = new String[201];
   static String country[]= new String[201];
   static int population[]= new int[201];
   static String shellCount[]= new String[201];
   static int shellPop[]= new int[201];
   static Hashtable <Integer, String> table = new Hashtable<Integer, String>(250);
   public static void main(String[] args)throws Exception{
   
      Scanner stdln = new Scanner(new File("CountrySortedAlpha.txt"));
      PrintWriter out = new PrintWriter("CountryUnsortedAlpha.txt");
      Random rand = new Random();
      String line;
      int where = 0;
         
      for(int i= 0; stdln.hasNextLine(); i++){//lines = to array & seperate country from population
         arr[i] = stdln.nextLine(); //line = array
         StringTokenizer st = new StringTokenizer(arr[i]);
         while(st.hasMoreTokens()){//seperate countries and population into parallel array in alphabetical order
            String stt= st.nextToken();
            try{
               population[i] = Integer.parseInt(stt);
            }
            catch(Exception e){
               if(country[i] == null)
                  country[i]= stt;
               else
                  country[i] = country[i] + " "+ stt;
            }
         }
      }
      stdln.close();
      
      //unsort text files
      System.out.println("Unsorting Phase \n");
      for(int j= 201; j >= 1; j--){//j vary from 201 down to 1
         where= rand.nextInt(j);//random number called where between j and 1
         
         for(int iter= 0; iter <= where; iter++){

            if(arr[iter].equals("null")){
               where++;
            }
            
            if(iter == where){
               if(!(arr[iter].equals("null"))){
                  out.println(arr[iter]);//print to text file 
                  arr[iter]= "null";
               }
            }
         }
      }
      out.close();
      
      System.out.println("CountryUnsortedAlpha.txt saved \n");
        
      System.out.println("============SORT BY USER PERCENTAGE============== \n");
      shellsort(country, population);
      System.out.println("End shellsorting phase \n");
      
      System.out.println("============PUT INTO HASH TABLE============== \n");
      hashing();
      System.out.println("End hashing phase \n");
      
      System.out.println("============SEARCH HASH TABLE============== \n");
      search();
      System.out.println("Thank you for using this program! \n");
   }
   public static void shellsort(String [] a, int b[]){
      int j;
      
      for(int gap= a.length /2; gap > 0; gap/=2){
         for(int i = gap; i < a.length; i++){
            String tmp= a[i];
            int tmp2 = b[i];
            for(j= i; j >= gap && tmp2 > b[j -gap]; j -= gap){
               a[j] = a[j-gap].trim();
               b[j] = b[j-gap];
            }
            a[j] = tmp;
            b[j] = tmp2;
         }
       }
       for(int i= 0; i < b.length; i++){
         shellCount[i] = a[i];
         shellPop[i] = b[i];
         System.out.printf("%-26s   %3d\n", shellCount[i], shellPop[i]);
       }
   }
   public static void hashing(){
      String str;
      String str2;
      int hash;
      
      for(int a= 0; a < population.length; a++){
         str= shellCount[a] + " "+ shellPop[a];
         char[] ch= shellCount[a].toCharArray();
         hash = hashing2(ch);
         hash %= 250;
         table.put(hash, shellCount[a]);
         System.out.printf("%-26s       hash to:         %3d\n", str, hash);

      }
   }
   public static int hashing2(char[] x){
      int has= 0;
      
      for(int bb= 0; bb < x.length; bb++){
         has += (int)x[bb];
      }
      if(table.get(has%250) == null)
         return has;
      else{
         do{
            has++;
         }while(table.get(has %250) != null);
      }
      return has;
   }
   public static void search(){
      Scanner kb= new Scanner(System.in);
      String look = " ";
      
      while(!look.equals("-1")){
         System.out.println("Name of country (case sensitive) - type -1 if done?");
         look= kb.nextLine();
         
         if(look.equals("-1"))
            break;
         else{
            getLookUp(look);
         }
      }
      kb.close();
   }
   public static void getLookUp(String c){
      int hash = 0;
      char[] ch= c.toCharArray();
      
      for(int in= 0; in< ch.length; in++){
         hash += (int)ch[in];
      }
      try{
         if(table.get(hash%250).equals(c))
            System.out.println(hash%250 + ": "+ table.get(hash%250));
         else{
            do{
               System.out.println(hash%250 + ": "+ table.get(hash%250));
               hash++;
            }while(!table.get(hash%250).equals(c));
            System.out.println(hash%250 + ": "+ table.get(hash%250));
         }
      }
      catch(Exception e){
         System.out.println("Not found in hash table!");
      }
   }
}