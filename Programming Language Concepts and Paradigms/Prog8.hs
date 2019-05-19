{- ########################################################
	Name: Jeff Gaston
	Date: 5/1/2019
	Title: Prog8.hs
	Description: An amalgamation of various functions
######################################################## -}

      module Prog8 where

-- 1. sumSqNeg computes the "sum of squares of negatives" using the foldr higher-order function.
sumSqNeg :: [Int] -> Int
sumSqNeg xs = foldr (+) 0 (map (^2) (filter (<0 ) xs))

-- 2. containing (without any higher order functions) returns whether each element in the first 
   -- list is also in the second list.
containing :: Eq a => [a] -> [a] -> Bool
containing x [] = False
containing [] y = True
containing (x:xs) y
  | x `elem` y = containing xs y
  | otherwise  = False

-- 3. total applies the function (first argument) to every element in the list (second argument) 
   -- and sums the results using the map higher-order function.
total :: (Int -> Int) -> [Int] -> Int
total f x = sum (map f x)

-- 4. containing' (with higher order functions) that returns whether each element in the first list
   -- is also in the second list. 
containing' :: Eq a => [a] -> [a] -> Bool
containing' _ [] = False
containing' xs ys = foldr (&&) True (map elem' xs)
       where
          elem' v
             |v `elem` ys        = True
             |otherwise          = False

-- 5. lengths returns a list of lengths of the given strings using map.
lengths :: [String] -> [Int]
lengths xs = map length xs

-- 6. product' returns the product of a nonempty list of numbers.
product' :: Num a => [a] -> a
product' xs = foldr (*) 1 xs 

-- 7. max' returns the largest element of a nonempty list.
max' :: Ord a => [a] -> a
max' x = foldr max (last x) x

-- 8. append' appends two lists. 
append' :: [a] -> [a] -> [a]
append' x y = foldr (:) y x 

-- 9. filterFirst removes the first element from the list (second argument) that does not satisfy
   -- a given predicate function (first argument). 
filterFirst :: (a -> Bool) -> [a] -> [a]
filterFirst x ys = foldr (:) [] (filterF x ys)
  where
    filterF _ [] = []
    filterF a (z:zs)
      | x z       = z:filterF x zs
      | otherwise = zs

-- 10. filterLast that removes the last element from the list (second argument) that does not satisfy 
    -- a given predicate function (first argument)
filterLast :: (a-> Bool) -> [a] -> [a]
filterLast x ys = reverse (foldr (:) [] (filterFirst x (reverse ys)))