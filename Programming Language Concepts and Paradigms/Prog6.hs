{- ########################################################
	Name: Jeff Gaston
	Date: 4/11/2019
	Title: Prog6.hs
	Description: An amalgamation of various functions
######################################################## -}

     module Prog6 where

-- Tree1 is a data type representation of a binary tree
data Tree1 = Leaf1 Int
           | Node1 Tree1 Int Tree1

-- Tree2 is a data type representation of a general tree whose interior nodes can have an arbitrary
   -- number of children
data Tree2 a = Leaf2 a
             | Node2 [Tree2 a]

-- static values for Tree1
t1 :: Tree1
t1 = Node1(Leaf1 7) 8 (Node1(Leaf1 9) 10 (Leaf1 11))

-- static values for Tree2
t3 :: Tree2 Int 
t3 = Node2 [Leaf2 1, Node2 [Node2 [Leaf2 2, Leaf2 3], Leaf2 4, Leaf2 5, Leaf2 6], Leaf2 7, Leaf2 8]


-- 1. preorder take a tree argument and returns as a list in preorder traversal of the tree.
preorder :: Tree1 -> [Int]
preorder (Leaf1 a) = [a]
preorder (Node1 left x right) = [x] ++ preorder left
                                    ++
                                preorder right

-- 2. postorder takes a tree argument and returns as a list in postorder traversal of the tree.
postorder :: Tree1 -> [Int]
postorder (Leaf1 a) = [a]
postorder (Node1 left x right) = postorder left
                                    ++
                                postorder right ++ [x]

-- 3. sumPositives takes a tree argumet and returns the sum of positive integers in the tree.
sumPositives :: Tree1 -> Int
sumPositives tre = sum([x | x <- xs, x >= 0])
  where xs = preorder tre 

-- 4. countInteriorNodes reutrns the numer of interior nodes in the given tree.
countInteriorNodes :: Tree1 -> Int
countInteriorNodes (Leaf1 x) = 0
countInteriorNodes (Node1 left x right) = 1 + (countInteriorNodes left) + (countInteriorNodes right)

-- 5. depth returns the depth of a tree. (A tree with only a root node is defined to have depth =1.)
maxDepth (Leaf1 x) = 1
maxDepth (Node1 left x right) = (maxDepth left) + (maxDepth right)

depth :: Tree1 -> Int
depth (Leaf1 x) = 1
depth (Node1 (Leaf1 _) _ (Leaf1 _))     = 2
depth (Node1 left x right)
   |maxDepth left >= maxDepth right     = (maxDepth left) + 1
   |otherwise                           = (maxDepth right) + 1

-- 6. occurs returns whether a given argument is present in a given tree.
occurs :: Eq a => a -> Tree2 a -> Bool
occurs (x) (Leaf2 y)  = x == y
occurs (x) (Node2 []) = False
occurs (x) (Node2 (y:ys)) = occurs x y || occurs x (Node2 ys)

-- 7. countLeaves takes a tree argument and returns the number of leaves in the tree.
countLeaves :: Tree2 a -> Int
countLeaves (Leaf2 x)  = 1
countLeaves (Node2 []) = 0
countLeaves (Node2 (y:ys)) = countLeaves y + countLeaves (Node2 ys)

-- 8. sumTree takes a tree of integers and returns the sum of all integers in the tree.
sumTree :: Tree2 Int -> Int 
sumTree (Leaf2 x)      = x
sumTree (Node2 [])     = 0
sumTree (Node2 (y:ys)) = sumTree y + sumTree (Node2 ys)

-- 9. post2 returns a postorder traversal of the nodes in the tree.
post2 :: Tree2 a -> [a]
post2 (Leaf2 x)      = [x]
post2 (Node2 [])     = []
post2 (Node2 (y:ys)) = post2 y ++ post2 (Node2 ys)

-- 10. depthK returns all nodes that are at depth k in the tree without specific order.
depthK :: Int -> Tree2 a -> [a]
depthK k (Leaf2 x)
   |k == 1         = [x]
   |otherwise      = []
depthK _ (Node2[]) = []
depthK k (Node2 (y:ys))
   |k > 1          = depthK (k-1) y ++ depthK (k) (Node2 ys)
   |otherwise      = []

{-- 
	_
5		7
	_
6		8

Tree2 a = Leaf2 a
        | Node2 [Tree2 a]

t2 :: Tree2	
								Leaf2 6		Leaf2 8
						(Node2[(		),(			)])
t2 = Node2 [(Leaf2 5),									,(Leaf2 7)]

--}