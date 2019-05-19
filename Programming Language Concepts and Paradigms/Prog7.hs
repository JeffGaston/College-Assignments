{- ########################################################
	Name: Jeff Gaston
	Date: 4/16/2019
	Title: Prog7.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog7 where

data Expr1 = Val1 Int
           | Add1 Expr1 Expr1
           | Sub1 Expr1 Expr1
     deriving Show

-- 3. Create a Expr2 type constructor that also supports multiplication and division, in addition to the int literal,
      -- addition, and subtraction.
data Expr2 = Val2 Int
           | Add2 Expr2 Expr2
           | Sub2 Expr2 Expr2
           | Mul2 Expr2 Expr2
           | Div2 Expr2 Expr2 

data Expr3 = Val3 Int
           | Add3 Expr3 Expr3
           | Sub3 Expr3 Expr3
           | Mul3 Expr3 Expr3
           | Div3 Expr3 Expr3
           | If BExpr3 Expr3 Expr3
     deriving Show

data Tree a = Leaf a
            | Node (Tree a) (Tree a)

data BExpr3 = BoolLit Bool
            | Or BExpr3 BExpr3
            | EqualTo Expr3 Expr3
            | LessThan Expr3 Expr3
     deriving Show

-- 1. unique returns the list of elements that occur exactly once in the argument list without using list comprehension.
unique :: Eq a => [a] -> [a]
unique [] = []
unique (x:xs)
   |x `elem` xs        = unique (helper x xs)
   |otherwise          = x:(unique(helper x xs))

helper :: Eq a => a -> [a] -> [a]
helper x [] = []
helper x (y:ys)
  | x == y = helper x ys
  | otherwise = y:(helper x ys)
  
-- 2. value1 evaluates an expression
value1 :: Expr1 -> Int
value1 (Val1 n) = n
value1 (Add1 a1 a2) = (value1 a1) + (value1 a2)
value1 (Sub1 s1 s2) = (value1 s1) - (value1 s2)

-- 3. Refer to line 15 for question number 3.

-- 4. value2 evaluates an expression, but returns Nothing if there is a division by zero scenario.
value2 :: Expr2 -> Maybe Int
value2 (Val2 n) = (Just n)
value2 (Add2 a1 a2) = Just (helper' (value2 a1) + helper' (value2 a2))
value2 (Sub2 s1 s2) = Just (helper' (value2 s1) - helper' (value2 s2))
value2 (Mul2 m1 m2) = Just (helper' (value2 m1) * helper' (value2 m2))
value2 (Div2 d1 d2)
  | helper' (value2 d2) == 0 = Nothing
  | otherwise               = Just ((helper' (value2 d1)) `div` (helper' (value2 d2)))

helper' :: Maybe Int -> Int
helper' (Just n)  = n
helper' (Nothing) = 0

-- 5. Make the Expr2 type an instance of the Show class. Appropriate define the function show so that
   -- (Add2 (Val2 3) (Val2 4)) returns the string "3+4"
instance Show Expr2 where
  show (Val2 n) = show n
  show (Add2 a1 a2) = "(" ++ show a1 ++ "+" ++ show a2 ++ ")"
  show (Sub2 s1 s2) = "(" ++ show s1 ++ "-" ++ show s2 ++ ")"
  show (Mul2 m1 m2) = "(" ++ show m1 ++ "*" ++ show m2 ++ ")"
  show (Div2 d1 d2) = "(" ++ show d1 ++ "/" ++ show d2 ++ ")"

-- 6. piglatinize returns a word into its piglatin form: if it begins with a vowel, add to the end "yay", else
    -- move non-vowels to the end of the string until a vowel is at the front and then add to the end "ay".
    -- vowels are "a,e,i,o,u"
piglatinize :: String -> String 
piglatinize [] = ""
piglatinize str = if (hasVowel (head str)) 
               then str ++ "yay"
                    else if (not (hasVowel (head(tail(str))))) 
                    then ((tail(tail str))) ++ [(head str)] ++ [(head(tail str))] ++ "ay"
                        else (tail str)++[(head str)]++"ay"

-- checks if char is vowel (not including y")
hasVowel :: Char -> Bool
hasVowel v = v `elem`['a','e','i','o','u','A','E','I','O','U']

-- 7. balanced returns whether a tree is balanced or not using the data type Tree.
balanced :: Tree a -> Bool 
balanced (Leaf n) = True
balanced (Node left right)
   |(numLeaves left) - (numLeaves right) == 1  = True 
   |(numLeaves left) - (numLeaves right) == -1 = True
   |(numLeaves left) - (numLeaves right) == 0  = True
   | otherwise                                 = False

--returns number of leaves in subtree.
numLeaves :: Tree a -> Int
numLeaves (Leaf n) = 1
numLeaves (Node left right) = numLeaves left + numLeaves right

-- 9. bEval evaluates instances of the above boolean expression
bEval :: BExpr3 -> Bool
bEval (BoolLit True) = True
bEval (BoolLit False) = False
bEval (Or b1 b2)
   |bEval b1 || bEval b2   = True
   |otherwise              = False
bEval (EqualTo b1 b2)
   |helper'(value3 b1) == helper'(value3 b2)    = True
   |otherwise                                   = False
bEval (LessThan b1 b2)
   |helper'(value3 b1) < helper'(value3 b2)     = True
   |otherwise                                   = False
   
-- 10. value3 evaluates an expression
value3 :: Expr3 -> Maybe Int
value3 (Val3 n) = (Just n)
value3 (Add3 a1 a2) = Just (helper' (value3 a1) + helper' (value3 a2))
value3 (Sub3 s1 s2) = Just (helper' (value3 s1) - helper' (value3 s2))
value3 (Mul3 m1 m2) = Just (helper' (value3 m1) * helper' (value3 m2))
value3 (Div3 d1 d2)
   |helper' (value3 d2) == 0        = Nothing
   |otherwise                       = Just (helper' (value3 d1) `div` helper' (value3 d2))
value3 (If b d1 d2)
   |bEval b        = Just(helper' (value3 d1))
   |otherwise      = Just(helper' (value3 d2))