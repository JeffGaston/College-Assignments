/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
   Date: 5/2/2019
   Title: AreaRectangle.java
   Description: Asks the user to enter a width and length of a rectangle,
                and then displays the rectangle's area. Main method calls
                getLength, getWidth, calcArea, and displayData methods.
   Input: Double width, Double length
   Ouput: area
*/

import java.util.Scanner;

public class AreaRectangle{
   public static Scanner kb = new Scanner(System.in);
   public static double getLength(){
      System.out.print("Enter length: ");
      double length = kb.nextDouble();
      
      return length;
   }
   public static double getWidth(){
      System.out.print("Enter width: ");
      double width = kb.nextDouble();
      
      return width;
   }
   public static double calcArea(double length, double width){
      
      return (length * width);
   }
   public static void displayData(double length, double width, double area){
      System.out.print("A rectangle of dimensions " + length + " x " + width +
                        " has area " + area);
   }
   public static void main(String[] args){
      double length,    // The rectangle's length
             width,     // The rectangle's width
             area;      // The rectangle's area

      // Get the rectangle's length from the user.
      length = getLength();

      // Get the rectangle's width from the user.
      width = getWidth();

      // Compute the rectangle's area.
      area = calcArea(length, width);

      // Display the rectangle data.
      displayData(length, width, area);
   }
}