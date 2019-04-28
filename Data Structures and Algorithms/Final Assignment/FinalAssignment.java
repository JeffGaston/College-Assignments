/*
   Name: Jeff Gaston
   My HackerRank: hackerrank.com/jeffgaston59
   My Github: github.com/JeffGaston
*/
import java.util.Scanner;
import java.util.NoSuchElementException;

public class FinalAssignment{

/* Three-way heap and heapsort
 * Date supplied in array declaration
 * Children of parent i are 3i-1, 3i, and 3i+1
 * Parent of child j is (j+1)/3
*/
  
  private int size;
  private int [] data;
  
  public int size(){
	  return size;
  }
  public FinalAssignment() //constructor
  {
      data = new int[14];
      size = 0;
  }

  public boolean isEmpty()
  { 
	  boolean ifEmpty;
	  if(size == 0){
		  ifEmpty = true;
	  }
	  else{
		  ifEmpty = false;
	  }
	  return ifEmpty;
  }
 
  //display method for Final object to use
  public void display()
  {
	  for(int i = 1; i < size+1; i++){
		  System.out.printf("%3d \t", data[i]);
	  }
	  System.out.println();
	  
  }  
   
  public boolean add(int elt)
  {
       int hole = percolateUp(++size, elt);
       data[hole] = elt;
       return true;
  }
 
  private int percolateUp(int hole, int elt)
  {
      while(hole != 1 && data[(hole+1)/3]> elt){
          data[hole] = data[(hole+1)/3];
          hole = (hole+1)/3;
       }
       return hole;
  }
 
  public int remove()
  {
      if(size == 0){
          throw new NoSuchElementException("remove");
       }
       int top = data[1];
       int insert = data[size--];
       int hole = percolateDown(1, insert);
       data[hole] = insert;
       return top;
  }
 
  private int percolateDown(int hole, int elt)
  {
      while(true){
          int left = (3* hole)-1, center= (3* hole), right = (3* hole)+1;
          
          if(left > size){
             break;
          }
          
          int child;
          
          if(left == size){
             child = left;
          }
          else if(data[center] <= data[right] && data[center] <= data[left]){
             child = center;
          }
          else if(data[left] <= data[center] && data[left] <= data[right]){
        	  child = left;
          }
          
          else{
             child = right;
          }
          if(elt <= data[child]){
             break;
          }
          else{
             data[hole] = data[child];
             hole = child;
          }
       }
       return hole;
  }
    
}// FinalAssignment class

class Container //for other display and main methods
{ 
    //display method for arrays (notFinal object)
    public static void display(int [] array)
    {
       for(int a = 0; a < array.length; a++){
    	   if(array[a] != 0){
    		   System.out.printf("%3d \t",array[a]);
    	   }
       }
       System.out.println();
       
    }
    

    public static void main(String[] args) throws Exception {
        int []A ={14,34,12,28,100,23,46,16,22,11,89,78,26};
        System.out.println("Array:");  
        display(A);

        FinalAssignment H = new FinalAssignment();
                
        System.out.println("===================================="); 
        System.out.println("Add to Heap:");
        for(int i = 0; i < A.length; i++){
        	H.add(A[i]);
        	H.display();
        }
         
        System.out.println("====================================");
        System.out.println("Remove from Heap:");
        
        for(int i = 0; i < A.length; i++){
        	A[i] = H.remove();
        	H.display();
        }
        
        System.out.println("Array:"); 
        display(A);
    }//main
}//container