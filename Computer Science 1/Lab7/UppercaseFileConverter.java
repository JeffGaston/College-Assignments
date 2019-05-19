/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 5/2/2019
   Title: UppercaseFileConverter.java
   Description: Prompts the user to input the filenames of two files
                and prints text in first file to second file in uppercase.
   Input: String filenames, text file
   Ouput: Text file
*/
import java.util.Scanner;
import java.io.*;

public class UppercaseFileConverter{
   public static void main(String[] args)throws IOException{
      Scanner kb = new Scanner(System.in);
      String fileName;
      String fileName2;
      
      System.out.print("Enter read file: ");
      fileName = kb.nextLine();
      
      System.out.print("Enter read file 2: ");
      fileName2 = kb.nextLine();
      
      kb.close();
      
      Scanner inputFile  = new Scanner(new File(fileName));
      PrintWriter writer = new PrintWriter(fileName2);
      
      while(inputFile.hasNext()){
         writer.print(inputFile.nextLine().toUpperCase() + "\n");
      }
      
      inputFile.close();
      writer.close();
   }
}