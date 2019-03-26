{- ########################################################
	Name: Jeff Gaston
	Date: 2/5/2019
	Title: Prog1.hs
	Description: An amalgamation of various functions in Haskell
######################################################## -}

     module Prog2 where

-- Returns whether a given floating point number is less than zero
isNegative :: Float -> Bool
isNegative x
         | x < 0        = True
         | otherwise    = False

-- Returns whether some dividend is evenly divisible by a given divisor
hasRemainder :: Integer -> Integer -> Bool
hasRemainder x y = x `mod` y /= 0

-- Returns the 2nd greatest of three given integer argumets
middle :: Integer -> Integer -> Integer -> Integer
middle x y z
     | (x >= y && x <= z) || (x <= y && x >= z) = x
     | (y >= x && y <= z) || (y <= x && y >= z) = y
     | otherwise                                = z

-- Computes the NOR gate of two boolean arguments
nor :: Bool -> Bool -> Bool
nor x y
  | x == False && y == False  = True
  | otherwise                 = False

-- Computes the area of a triangle given its base and height
triangleArea :: Integer -> Integer -> Float
triangleArea x y = fromIntegral(x * y) /2

-- Multiplies a number by 3 but only if that number is smaller than or equal to 100
tripleNumber :: Integer -> Integer
tripleNumber input = if input <= 100 then (input*3) else input

-- Retuns whether a given character is a vowel (a,e,i,o,u) or not
isVowel :: Char -> Bool
isVowel x
      | x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' = True
      | otherwise                                                = False

-- Returns the equivalent letter grade for a given numerical integer grade, per the syllabus for this course.
letterGrade :: Integer -> String
letterGrade x
          | x >= 93           = "A"
          | x < 93 && x >= 90 = "A-"
          | x < 90 && x >= 87 = "B+"
          | x < 87 && x >= 83 = "B"
          | x < 83 && x >= 80 = "B-"
          | x < 80 && x >= 77 = "C+"
          | x < 77 && x >= 73 = "C"
          | x < 73 && x >= 70 = "C-"
          | x < 70 && x >= 67 = "D+"
          | x < 67 && x >= 63 = "D"
          | x < 63 && x >= 60 = "D-"
          | x < 60            = "F"
          | otherwise         = "Error"

-- Return the average of three integers.
averageThree :: Integer -> Integer -> Integer -> Float
averageThree x y z = fromIntegral(x+y+z)/ 3

-- Returns how many of three integer inputs are below its average value
howManyBelowAverage :: Integer -> Integer -> Integer -> Integer
howManyBelowAverage a b c
                  | ( avg > fromIntegral(a) && avg > fromIntegral(b)) || (avg > fromIntegral(b) && avg > fromIntegral(c)) || (avg > fromIntegral(a) && avg > fromIntegral(c)) = 2
                  | avg < fromIntegral(a) || avg < fromIntegral(b) || avg < fromIntegral(b) || avg < fromIntegral(c) || avg < fromIntegral(a) || avg < fromIntegral(c) = 1
                  | otherwise                                                                        = 0
                   where avg = averageThree a b c
