{- ########################################################
	Name: Jeff Gaston
	Date: 3/24/2019
	Title: Prog5.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog5 where

-- 1. A function that reverses a list using case expression inside of the function definition
      -- without built-in Haskell functions.
reverse' :: [a] -> [a]
reverse' x = case x of
  [] -> []
  (x:xs) -> (reverse' xs) ++ [x]

-- 2. Returns if some list is a palindrome
isPalindrome :: String -> Bool
isPalindrome abc = abc == (reverse' abc)

-- 3. Takes a string and a list of strings, and returns the remainder of the list after the given
      -- string is found. 

-- Following create data type sets
data Set = Set [Int]
         | EmptySet
     deriving Show

safeFindAfter :: String -> [String] -> Maybe [String]
safeFindAfter s (y:ys)
  | y == s    = Just ys
  | y /= s    = safeFindAfter s ys
  | otherwise = Just []

-- 4. Checks whether the given item is present in the given set.
member :: Int -> Set -> Bool
member _ (Set []) = False
member a (Set(x:xs))
  | a == x    = True 
  | a /= x    = member a (Set(xs))
  | otherwise = False 

-- 5. Returns the number of elements in a given set.
size :: Set -> Int
size (Set []) = 0
size (Set(x)) = length x

-- 6. Inserts the given item into a set. If the item is already in the set, simply returns the set unmodified.
add :: Int -> Set -> Set
add a (Set(x))
  | (member a (Set(x))) == True = Set(x)
  | otherwise                   = (Set(a:x))

-- 7. Returns the largest element from a set of integers.
safeRemoveMax :: Set -> Maybe Int
safeRemoveMax (Set []) = Nothing
safeRemoveMax (Set(x:xs))
  | xs == []     = Just x
  | x >= head xs = safeRemoveMax (Set(x:(tail xs)))
  | x < head xs  = safeRemoveMax (Set(xs))
  | otherwise    = Just x

-- 8. Returns whether two sets are equal.
equal' :: Set -> Set -> Bool
equal' (Set(x:[])) (Set(y)) = member x (Set(y))
equal' (Set(x:xs)) (Set(y))
  | member x (Set(y)) == True  = equal' (Set(xs)) (Set(y))
  | member x (Set(y)) == False = False
  | otherwise                  = True

equal :: Set -> Set -> Bool
equal (Set([])) (Set([])) = True
equal (Set([])) _         = False
equal  _ (Set([]))        = False
equal (Set(a)) (Set(b))
  | length a /= length b = False
  | otherwise            = equal' (Set(a)) (Set(b))

-- 9. Takes two sets and returns the union of both sets.
union :: Set -> Set -> Set
union (Set[]) (Set[])   = EmptySet
union (Set(a)) (Set[])  = (Set(a))
union (Set[]) (Set(b))  = (Set(b))
union (Set(a)) (Set(b)) = (Set(remDup a b))

remDup :: Eq a => [a] -> [a] -> [a]
remDup x [] = x
remDup [] y = y
remDup (x:xs) y
  | (elem) x y  = remDup xs y
  | otherwise   = x: remDup xs y

-- 10. Takes two sets and returns the intersection of them.
intersection :: Set -> Set -> Set
intersection (Set[]) (Set[])   = EmptySet
intersection (Set(a)) (Set[])  = (Set(a))
intersection (Set[]) (Set(b))  = (Set(b))
intersection (Set(a)) (Set(b)) = (Set(intersection' a b))

intersection' :: Eq a => [a] -> [a] -> [a]
intersection' [] _  = []
intersection'  _ [] = []
intersection' (x:xs) y
  | elem x y  = x : intersection' xs y
  | otherwise = intersection' xs y