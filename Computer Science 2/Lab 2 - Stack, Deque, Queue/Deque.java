public class Deque{
   private Node front;
   private Node rear;
   public int Hi= 3;
   private boolean yolo= true;
   
   public void Deque(){
      front = null;
      rear= null;
   }
   
   public boolean isEmpty(){
      return front == null;
   }
   public void Enq(String input){
      if(isEmpty()){
         front = new Node(input, null);
         rear = front;
      }
      else{
         rear.next = new Node(input, null);
         rear= rear.next;
      }
   }
   public String deque(){
      String data= front.data;
      front = front.next;
      return data;
   }
   public void push(String data){
      if(isEmpty()){
         front= new Node(data, front);
         rear= front;
      }
      else{
         front = new Node(data, front);
      }
   }
   public String pop(){
         String data= front.data;
         front = front.next;
      return data;
   }
   public void display(){
      Node elNode = front;
      if(!isEmpty()){
         while(elNode != null){
            System.out.println(elNode.data);
            elNode= elNode.next;
         }
      }
      else{
         System.out.println("Guess what?? this is empty");
      }
   }
}