public class Jeff_Gaston_HW1{
   private static boolean sudoku= true;
   public static void main(String[] args){
      
      int input[][]= {{1,8,4,9,6,3,7,2,5},
                      {5,6,2,7,4,8,3,1,9},
                      {3,9,7,5,1,2,8,6,4},
                      {2,3,9,6,5,7,1,4,8},
                      {7,5,6,1,8,4,2,9,3},
                      {4,1,8,2,3,9,6,5,7},
                      {9,4,1,3,7,6,5,8,2},
                      {6,2,3,8,9,5,4,7,1},
                      {8,7,5,4,2,1,9,3,6}};
      
      RowXColumn(input);
      if(sudoku == true)
         Blocks(input);
      
      System.out.println("True or false, is this a sudoku puzzle solution: " + sudoku);
      
   }
   public static void RowXColumn(int [][]a){ 
   
      for(int row=0; row < a.length; row++){
         for(int col=0; col< a[row].length; col++){
            for(int x= row+1; x< a.length; x++){//Checks columns
               if(a[row][col] == a[x][col])
                  sudoku = false;
            }
            for(int y= col+1; y< a[row].length; y++){//Checks rows
               if(a[row][col] == a[row][y])
                  sudoku = false;
            }
         }
      }
   }
   public static void Blocks(int [][]b){
   
      for(int row= 0; row< (b.length); row+= 3){
         for(int col= 0; col< (b[row].length); col+= 3){
         
            for(int p= row; p< (row+2); p++){
               for(int p1= col; p1< (col+2); p1++){//picks out value to compare
               
                  for(int comp= p; comp < p+2; comp++){//compares
                     for(int comp2= p1+1; comp2 < p1+2; comp2++){
                        if(b[p][p1] == b[comp][comp2])
                           sudoku= false;
                     }
                  }
               }
            }
         }
      }
   }
}
