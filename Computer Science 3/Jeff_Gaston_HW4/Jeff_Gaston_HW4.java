/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.util.*;
import java.io.*;
public class Jeff_Gaston_HW4{
   public static FileWriter writer;
   public static FileWriter writer2;
   public static ArrayList<String> output1= new ArrayList<String>();
   public static ArrayList<String> output2= new ArrayList<String>();
   public static Scanner kb;
   public static int palin= 0;
   public static void main(String[] args)throws IOException{
      try{
         kb= new Scanner(new File("Text.txt"));//File name to be read from
         writer= new FileWriter(new File("output1.txt"));
         writer2= new FileWriter(new File("output2.txt"));
         
         while(kb.hasNext()){
            String a= kb.next();
            palindrome(a);
         }
         System.out.println("The input file has: "+ palin+ " palindromes.");
         org();
         
         writer.close();
         writer2.close();   
      }
      catch(Exception e){
         System.out.println("File not found");
      }
   }
   public static void palindrome(String s)throws IOException{
      boolean pal= true;
      String buff= "";
      
      for(int a= (s.length()-1); 0 <= a; a--){
         char b= s.charAt(a);
         
         if(!Character.isLetter(b)){
            pal= false;
         }
         buff+= b;
      }
      if(buff.equalsIgnoreCase(s) && (pal == true)){
         palin++;
      }
      if(Character.toLowerCase(s.charAt(0)) <= 'm'){
         output1.add(s);
      }
      if(Character.toLowerCase(s.charAt(0)) > 'm'){
         output2.add(s);
      }
   }
   public static void org()throws IOException{
      output1.sort(String::compareToIgnoreCase);
      output2.sort(String::compareToIgnoreCase);
      Set<String> s= new LinkedHashSet<>(output1);
      Set<String> s2= new LinkedHashSet<>(output2);
      
      for(String ss: s){
         writer.write(ss + "\n");
      }
      for(String ss: s2){
         writer2.write(ss + "\n");
      }
   }
}