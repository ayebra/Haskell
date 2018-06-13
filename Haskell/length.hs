reverse2 :: [a] - [a]
reverse2 [] = []
reverse2 (x:xs) = reverse2 xs ++ [x]