por :: Int -> Int -> Int 
m `por` 0 = 0
m `por` n = m + (m `por` (n - 1))