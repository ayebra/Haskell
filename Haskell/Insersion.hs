inserta :: Ord a => a -> [a] -> [a]
inserta e [] = [e]
inserta e (x:xs) | e <= x = e : (x:xs)
                 | otherwise = x : inserta e xs