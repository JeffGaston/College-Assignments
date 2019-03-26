{- ########################################################
	Name: Jeff Gaston
	Date: 3/16/2019
	Title: Prog4.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog4 where

-- 1. Takes two dates and returns whichever one is older
older :: (Int, Int, Int) -> (Int, Int, Int) -> (Int, Int,Int)
older (a,b,c) (x,y,z) 
  | (c<z) || (c<=z && a<x) || (c<=z && a<=x && b<y) = (a,b,c)
  | otherwise                                       = (x,y,z)

-- 2. Takes a month and a list of dates and returns how many dates in the list match the given month.
numInMonth :: Int -> [(Int, Int, Int)] -> Int
numInMonth _ [] = 0
numInMonth month ((m,d,y):xs)
  | month == m = 1 + (numInMonth month xs)
  | otherwise  = 0 + (numInMonth month xs)

-- 3. Takes a month and a list of dates and returns a list of dates that match the given month.
datesInMonth :: Int -> [(Int, Int, Int)] -> [(Int, Int, Int)]
datesInMonth _ [] = []
datesInMonth month ((m,d,y):xs)
  | month == m = (m,d,y):datesInMonth month xs
  | otherwise  = datesInMonth month xs 

-- 4. Takes a date and returns its string equivalent in the form "February 23, 2018".
dates2Str :: (Int, Int, Int) -> String
dates2Str (m,d,y)
  | m == 1    = "January " ++ show m ++ ", " ++ show y
  | m == 2    = "February " ++ show m ++ ", " ++ show y
  | m == 3    = "March " ++ show m ++ ", " ++ show y
  | m == 4    = "April " ++ show m ++ ", " ++ show y
  | m == 5    = "May " ++ show m ++ ", " ++ show y
  | m == 6    = "June " ++ show m ++ ", " ++ show y
  | m == 7    = "July " ++ show m ++ ", " ++ show y
  | m == 8    = "August " ++ show m ++ ", " ++ show y
  | m == 9    = "September " ++ show m ++ ", " ++ show y
  | m == 10   = "October " ++ show m ++ ", " ++ show y
  | m == 11   = "November " ++ show m ++ ", " ++ show y
  | otherwise = "December " ++ show m ++ ", " ++ show y

-- 5. Same as above, but do not use 12 conditionals. Instead, use a list holding 12 strings (the months)
      -- as well as the !! operator to index this list.
date2Str' :: (Int, Int, Int) -> String
date2Str' (m,d,y) = (["January ","February ","March ","April ","May ","June ",
                     "July ","August ","September ","October ","November ","December "])
                     !! (m-1) ++ show m ++ ", " ++ show y

-- 6. Takes a numeric day in the calendar year (between 1 and 365) and returns what month that day is in
      -- (excluding leap years).
monthLookup :: Int -> Int 
monthLookup day
  | (day >= 1) && (day <= 31)    = 1
  | (day >= 32) && (day <= 59)   = 2
  | (day >= 60) && (day <= 90)   = 3
  | (day >= 91) && (day <= 120)  = 4
  | (day >= 121) && (day <= 151) = 5
  | (day >= 152) && (day <= 181) = 6
  | (day >= 182) && (day <= 212) = 7
  | (day >= 213) && (day <= 243) = 8
  | (day >= 244) && (day <= 273) = 9
  | (day >= 274) && (day <= 304) = 10
  | (day >= 305) && (day <= 334) = 11
  | otherwise                    = 12

-- 7. Takes two numeric days (from previous problem) and returns an integer list of the months between 
      -- those dates (inclusive), e.g.: monthRange 23 101 should return [1,2,3,4]. If the second argument 
      -- is earlier than the first argument, return the empty list.
monthRange :: Int -> Int -> [Int]
monthRange a b
  | a > b     = []
  | otherwise = [x | x<- [1..12], (monthLookup a) <= x, x <= (monthLookup b)]

-- 8. Takes a date and returns whether it is valid (e.g. November 31 is not valid). Not considering leap years.
validDate :: (Int, Int, Int) -> Bool
validDate (m,d,y)
  | d <= ([31,28,31,30,31,30,31,31,30,31,30,31] !! (m-1)) = True
  | otherwise                                             = False

-- 9. Write a function validLeapDate that takes a date and returns whether it is a leap date, that is exactly 
      -- February 29th on a leap year. (Leap years are years that are either divisible by 400 or divisible by 
      -- 4 but not divisible by 100.)
validLeapDate :: (Int, Int, Int) -> Bool
validLeapDate (m,d,y)
  | ((y `mod` 400 == 0) || (y `mod` 4 == 0) && y `mod` 100 /= 0) = True
  | otherwise                                  = False

-- 10. Takes a date and returns the season that the date is in.
season :: (Int, Int, Int) -> String
season (m,d,y)
  | (m == 3 && d >= 20) || (m == 6 && d < 21) || m == 4 || m == 5    = "Spring"
  | (m == 6 && d >= 21) || (m == 9 && d < 23) || m == 7 || m == 8    = "Summer"
  | (m == 9 && d >= 23) || (m == 12 && d < 21) || m == 10 || m == 11 = "Fall"
  | otherwise                                                        = "Winter"
