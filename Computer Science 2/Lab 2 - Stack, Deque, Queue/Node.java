public class Node{
   public Node next;
   public String data;
   
   Node(String data, Node next){
      this.next= next;
      this.data= data;
   }
   Node(String data){
      this.next= null;
      this.data= data;
   }
}