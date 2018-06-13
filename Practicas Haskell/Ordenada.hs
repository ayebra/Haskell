ordenada_ins :: Ord a => [a] -> [a]
ordenada_ins [] = []
ordenada_ins (x:xs) = inserta x (ordenada_ins xs)