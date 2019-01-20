import java.io.*;
import java.util.*;
public class InternetUsers_Jeff{
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
               //System.out.println(stt);
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
      for(int j= 200; j >= 1; j--){//j vary from 201 down to 1
         where= rand.nextInt(201);//random number called where between j and 1
         
         for(int iter= 0; iter <= where; iter++){
            if(iter == where){
               if(!(arr[iter].equals("null"))){
                  //System.out.println(arr[iter]);//print to text file 
                  arr[iter]= "null";
               }
            }
         }
      }
         /*line[k] = stdln.nextLine();
         lineSort[k] = line[k];
         out.println(line[k]);*/
         
         shellsort(country, population);
         hashing();
   }
   public static void unsort(int lineNum)throws Exception{
      
   }
   public static void shellsort(String [] a, int b[]){
      int j;
      
      for(int gap= a.length /2; gap > 0; gap/=2){
         for(int i = gap; i < a.length; i++){
            String tmp= a[i];
            int tmp2 = b[i];
            for(j= i; j >= gap && tmp2 > b[j -gap]; j -= gap){
               a[j] = a[j-gap];
               b[j] = b[j-gap];
            }
            a[j] = tmp;
            b[j] = tmp2;
         }
       }
       for(int i= 0; i < b.length; i++){
         shellCount[i] = a[i];
         shellPop[i] = b[i];
       }
   }
   public static void hashing(){
      String str;
      String str2;
      int hash;
      
      for(int a= 0; a < population.length; a++){
         str= shellCount[a] + " "+ shellPop[a];
         System.out.println(str);
         char[] ch= shellCount[a].toCharArray();
         hash = hashing2(ch);
         hash %= 250;
         table.put(has, 
         
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
         }while(table.get(has%250) != null);
      }
      return has;
   }
}