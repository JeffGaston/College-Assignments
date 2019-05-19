{- ########################################################
	Name: Jeff Gaston
	Date: 3/2/2019
	Title: Prog3.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog3 where

import Data.Char
 
-- 1. Only using library functions, returns the sum of the last n numbers in the list, where n is the first argument
      -- to the function.
sumLastPart :: Int -> [Int] -> Int
sumLastPart x = sum.take x.reverse

-- 2. has identical behavior to the init function. May only use the standard Haskell functions that operate on lists
init' :: [Int] -> [Int]
init' [] = error "The init' function is not for an empty list"
init' [y] = []
init' xy = take(length (xy)-1) xy

-- 3. A recursive function that has the same behavior as init' but with no standard Haskell funcstions used.
init'' :: [Int] -> [Int]
init'' [] = error "The init'' function is not for an empty list"
init'' [y] = []
init'' (x:xy) = x : init' xy

-- 4. A recursive function that returns the ith item of the list, where the first item is index 1 without using standard
      -- Haskell functions that operate on lists 
elemAt :: Int -> [Int] -> Int
elemAt n (a:bc)
     | n == 0    = error "Not in scope"
     | n == 1    = a
     | otherwise = elemAt(n-1) bc

-- 5. A function that returns the number of times that an element occurs in the list using recursion instead of list
      -- comprehension
numTimes :: Int -> [Int] -> Int
numTimes a [] = 0
numTimes a (x:xy)
       | a == x    = 1 + numTimes a xy
       | otherwise = numTimes a xy

-- 6. A function that lowercases the first and only first letter of a String
lowerFirstLetter :: String -> String
lowerFirstLetter [] = []
lowerFirstLetter (x:xy) = (toLower x) :xy

-- 7. Uses recursion to return the conjuction of a list of boolean values.
and' :: [Bool] -> Bool
and' []       = True
and' (a:ab)   = a && (and' ab)

-- 8. Uses recursion to return the disjunction of a list of boolean values.
or' :: [Bool] -> Bool
or' []       = False
or' (a:ab)   = a || (or' ab)

-- 9. Uses insertion sort to sort of a list of triples (Float, Int, String) where only the second element is to be
      -- considered during the sorting process.
insert :: (Float, Int, String) -> [(Float, Int, String)] -> [(Float, Int, String)]
insert x [] = [x]
insert (x,y,z) ((a,b,c):xy) 
  | y < b     = (x,y,z):(a,b,c):xy
  | otherwise = (a,b,c):insert (x,y,z) xy

iSort' :: [(Float, Int, String)] -> [(Float, Int, String)]
iSort' []     = []
iSort' (a:bc) = insert a (iSort' bc)

-- 10. Takes two sorted lists in decreasing oder and merges them into a single sorted list in decreasing order.
merge :: [Int] -> [Int] -> [Int]
merge [] [] = []
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys)
    | x > y     = x:merge xs (y:ys)
    | y > x     = y:merge ys (x:xs) 
    | otherwise = y:(merge (x:xs) ys)