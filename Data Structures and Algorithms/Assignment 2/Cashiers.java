import java.util.*;
public class Cashiers{
   public static int[][] queues;
   public static int front[];
   public static int back[];
   public static int currentSize[];
   public static int index[];
   public static int customers;
   public static String input;
   
   public Cashiers(){
      queues= new int [3][6];
      front= new int[3];
      back= new int[3];
      currentSize= new int[3];
      customers= 1;
   }
   public static void main(String[] args){
   /*
      For front and back arrays, can use index and value as address for front and back numbers 
   */
      Scanner kb= new Scanner(System.in);
      new Cashiers();
      back[0] = 5;
      back[1] = 5;
      back[2] = 5;
      
      display();
      do{
      System.out.println("Input command E, 1, 2, 3, F, C, or Q: ");
      input= kb.nextLine().toUpperCase();
      
      switch(input){
         case "E":
            enqueue();
            break;
         case "1":
            dequeue(0);
            break;
         case "2":
            dequeue(1);
            break;
         case "3":
            dequeue(2);
            break;
         case "F":
            fill();
            break;
         case "C":
            clear();
            break;
         case "Q":
            break;
         default:
            System.out.println("Invalid input!");
            break;
      }
      
      }while(!input.equals("Q"));
   }
   public static void clear(){
      for(int a= 0; a< queues.length; a++){
         for(int b= 0; b< queues[a].length; b++){
            queues[a][b]= 0; 
         }
         currentSize[a]= 0;
      }
      display();
   }
   public static void fill(){
      clear();
      for(int a= 0; a < queues.length; a++){
            if(customers == 18)
               break;
         for(int b= 0; b < queues[a].length; b++){
            if(queues[a][b] == 0){
               queues[a][b] = customers;
               customers++;
            }
         }
         currentSize[a]= 6;
      }
      display();
   }
   public static void display(){
      System.out.println("Here is the current queue: ");
      for(int a= 0; a < queues.length; a++){
         System.out.println();
         
         for(int b= 0; b < queues[a].length; b++){
            System.out.printf("%3d", queues[a][b]);
            if(b == front[a])
               System.out.print("F");
            if(b == back[a])
               System.out.print("B");
               
            System.out.printf(" \t");
         }
      }
      System.out.println("\n");
   }
   public static int dequeue(int which){//Remove front and pick new front
      
      switch(which){
         case 0:
               if(queues[0][front[0]] == 0){
                  System.out.println("It's empty!");
                  front[0]= 0;
               }
               else{
                  System.out.println("Customer "+ queues[0][front[0]]+ " is finished");
                  queues[0][front[0]]= 0;
                  if(front[0] == 5){
                     front[0] = 0;
                     currentSize[0]--;
                  }
                  else{
                     front[0]++;
                     currentSize[0]--;
                  }
               }
            break;
         case 1:
               if(queues[1][front[1]] == 0){
                  System.out.println("It's empty!");
                  front[1]= 0;
               }
               else{
                  System.out.println("Customer "+ queues[1][front[1]]+ " is finished");
                  queues[1][front[1]]= 0;
                  if(front[1] == 5){
                     front[1] = 0;
                     currentSize[1]--;
                  }
                  else{
                     front[1]++;
                     currentSize[1]--;
                  }
               }
            break;
         case 2:
               if(queues[2][front[2]] == 0){
                  System.out.println("It's empty!");
                  front[2]= 0;
               }
               else{
                  System.out.println("Customer "+ queues[2][front[2]]+ " is finished");
                  queues[2][front[2]]= 0;
                  if(front[2] == 5){
                     front[2] = 0;
                     currentSize[2]--;
                  }
                  else{
                     front[2]++;
                     currentSize[2]--;
                  }
               }
            break;
      }
      display();
      return 1;
   }
   public static boolean enqueue(){
      int min= Math.min(Math.min(currentSize[0], currentSize[1]), currentSize[2]);
      
      if(currentSize[0] == min && currentSize[1] == min && currentSize[2] == min){
         if(min == 6){
            System.out.println("It is full!");
            return false;
         }
         else{
            currentSize[0]++;
            if(back[0]== 5)
               back[0]= 0;
            else
               back[0]++;
               
            queues[0][back[0]]= customers++;
         }
      }
      else if(currentSize[0] == min && currentSize[1] == min){
            currentSize[0]++;
            if(back[0]== 5)
               back[0]= 0;
            else
               back[0]++;
            queues[0][back[0]]= customers++;
      }
      else if(currentSize[0] == min && currentSize[2] == min){
            currentSize[0]++;
            if(back[0]== 5)
               back[0]= 0;
            else
               back[0]++;
            queues[0][back[0]]= customers++;
      }
      else if(currentSize[1] == min && currentSize[2] == min){
            currentSize[1]++;
            if(back[1]== 5)
               back[1]= 0;
            else
               back[1]++;
            queues[1][back[1]]= customers++;
      }
      else{
            if(min == currentSize[0]){
               currentSize[0]++;
               if(back[0]== 5)
                  back[0]= 0;
               else
                  back[0]++;
               queues[0][back[0]]= customers++;
            }
            else if(min == currentSize[1]){
               currentSize[1]++;
               if(back[1]== 5)
                  back[1]= 0;
               else
                  back[1]++;
               queues[1][back[1]]= customers++;
            }
            else if(min == currentSize[2]){
               currentSize[2]++;
               if(back[2]== 5)
                  back[2]= 0;
               else
                  back[2]++;
               queues[2][back[2]]= customers++;
            }
            else
               System.out.println("It's full!");
      }
      display();
      return true;
   }
}