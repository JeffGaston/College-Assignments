Description:
This program determines whether a two dimensional array is a possible solution to a sudoku puzzle and outputs a boolean to the console.

How to use:
To use the program, alter the values in the two dimensional array, and then compile and run the program.

Logic
My problem solving approach when facing this task was to breakdown the problem into seperate methods through a UML diagram. I broke it down to needing a method to check the
Rows and columns, a method to check the 3x3 blocks and of course the main method as the starting point. For the RowXColumn method, I wanted to pick out a value in the array, compare
it to the remaining values in it's Row and Column and then pick another value in the array and do the same thing. If it found a repeated value, an if statement would set
the sudoku boolean to false and it say that the array isn't a solution. As for the Blocks method to check for the 3x3 blocks, my logic was to seperate the 2D array into 9 logical blocks
by using for loops that increment by 3 to search through the rows and columns. Those for loops would have nested for loops which would iterate through 2 rows and columns and compare values.
It would set the sudoku boolean to false if it found repeating values. At the end of the program, it would print the outcome for the sudoku boolean to the console.