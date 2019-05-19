{- ########################################################
	Name: Jeff Gaston
	Date: 2/14/2019
	Title: Prog2.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog2 where

-- 1. Uses recursion to compute the sum of all numbers from 1 to numbers
sum' :: Integer -> Integer
sum' n 
   | n < 0       = error "Value must be greater than 0"
   | n == 0      = 0
   | n > 0       = sum'(n -1) + n
   | otherwise   = n

-- 2. Returns the integer square root of a positive integer n.
integerSqrt :: Integer -> Integer
integerSqrt x
  | x <= 0    = error "integerSqrt must have an input greater than 0"
  | x == 1    = 1
  | otherwise = floor (sqrt(fromIntegral x))

-- 4. Recursively computes the result of raising some base numbers, b, to some exponent, e.
exponent' :: Integer -> Integer -> Integer
exponent' b e
        | e == 0        = 1
        | e == 1        = b
        | e > 1         = b * exponent' b (e - 1)
        |otherwise      = b

-- 5. Redefines the built-in infix || operator without guards in the definition but use pattern matching and only have two definitons
or' :: Bool -> Bool -> Bool
False `or'` False                = False
or' _ _                          = True 

-- 6. Takes a triple, and returns a version in decreasing order
maxThree :: (Integer, Integer, Integer) -> Integer
maxThree (x,y,z)
       | x >= y && x >= z                         = x
       | y >= x && y >= z                         = y
       | otherwise                                = z

midThree :: (Integer, Integer, Integer) -> Integer
midThree (x,y,z)
       | (x >= y && x <= z) || (x <= y && x >= z) = x
       | (y >= x && y <= z) || (y <= x && y >= z) = y
       | otherwise                                = z
minThree :: (Integer, Integer, Integer) -> Integer
minThree (x,y,z)
       | x <= y && x <= z                         = x
       | y <= x && y <= z                         = y
       | otherwise                                = z

orderTriple :: (Integer, Integer, Integer) -> (Integer, Integer, Integer)
orderTriple x =(maxThree x, midThree x, minThree x)

-- 7. Swaps the characters in a quadruple (4-tuple) in te following way: the first elements swaps with the last, and the middle two flip
swap :: (Char, Char, Char, Char) -> (Char, Char, Char, Char)
swap (a, b, c, d) = ( d, c, b, a)

-- 8. Takes a String and returns a list of the ascii values of characters in that string.
asciiNums :: String -> [Int]
asciiNums a = [(fromEnum n) | n <- a]

-- 9. Picks out all instances of an integer n from a list
matches :: Integer -> [Integer] -> [Integer]
matches a b = [n | n <- b, n ==a]

-- 10. Returns True if an element is a memeber of a list, and False if otherwise.
element :: Integer -> [Integer] -> Bool
element a b
      | length (matches a b) == 0         = False
      | otherwise                         = True 