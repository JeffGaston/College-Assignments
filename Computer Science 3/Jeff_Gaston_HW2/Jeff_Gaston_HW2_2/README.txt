Description:
This program outputs a String in a calendar format to the console with an input of month and year from the user. 

How to use:
To use the program, run it and input and follow the prompts in the console.

Problem solving:
My problem solving approach for this program was to seperate the question between what was input to the program vs output by the program. From there,
I broke the subcategories of input and output into what would be a method, field or simple line of code in the program like a method to calculate the first day
of the month for the year. With the problem in smaller parts, I was able to write psuedocode to tackle them each individually then write the actual program
from my notes when I was done. It was broken into the following:

inputs: integer month, integer year from keyboard
output: Integer month converted to String month name, integer year, days of the week, first day of the week followed by chronological days of the month aligned
with days of the week

Contemplated Questions:
How many days in each month?
Solution- Searched on google and found only variable month to be February from leap years. I added a boolean field to alter February based on leap years and wrote
a method to determine if inputed year is a leap year.

How do you determine the first day of a month?
Solution- Wrote method based on Zeller's congruence