import java.util.Scanner;
public class Lab2{
   private static Scanner kb= new Scanner(System.in);
   private static Deque joe= new Deque();
   public static void main(String[] args){
         String input;
         int buffer;
         boolean quit;
      do {
         quit= false;
         System.out.println("(0) quit\n(1) queue function\n(2) Stack functions\n(3) Display dequeue");
         buffer = kb.nextInt();
         if (buffer == 0) {
            quit = true;
            } else if (buffer == 1) {
               queueMenu();
            } else if (buffer == 2) {
               stackMenu();
            } else if (buffer == 3) {
               joe.display();
            }
      } while(!quit);
      System.exit(0);
   }
   public static void stackMenu(){
         String input;
         int buffer;
         boolean quit;
      do {
         quit = false;
         System.out.println("(0) return to previous menu\n(1)push\n(2)pop(3)");
         buffer= kb.nextInt();
         if (buffer == 0) {
            quit= true;
            } else if (buffer == 1) {
               System.out.println("Please enter the data");
                  kb.nextLine();
                  input= kb.nextLine();
                  joe.push(input);
            } else if (buffer == 2) {
               joe.pop();
            }
         } while(!quit);
      }
   public static void queueMenu(){
         String input;
         int buffer;
         boolean quit;
         do {
         quit = false;
         System.out.println("(0) return to previous menu\n(1)Enqueue\n(2)Dequeue");
         buffer= kb.nextInt();
              if (buffer == 0) {
                  quit = true;
            } else if (buffer == 1) {
               System.out.println("Please enter the data");
               kb.nextLine();
               input= kb.nextLine();
               joe.Enq(input);
               
            } else if (buffer == 2) {
               joe.deque();
            }
         } while(!quit);
      }
}