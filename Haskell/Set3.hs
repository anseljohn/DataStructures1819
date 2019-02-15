-- 8
multOfC a b c = filter (\x -> c `mod` x == 0) [a..b]

-- 9
noCommon list n =  [ x | x <- list, x `mod` n /= 0]

-- 10
not13Floor floor = [ x | x <- [0..floor], x /= 13 ]

-- 11
sum $ map (\x -> (27*(x^2)) - (12*x) - 20) [0..1000]

-- 12
numDivOf num = length $ filter (\x -> num `mod` x == 0) [1..num]

-- 13
replaceSpace string = [if x == ' ' then '_' else x | x <- string]

-- 14
afterChars string phrase = concat [x:phrase | x <- string]

-- 15
[ [x | x <- [0..9]], x | x <- [0..9]]





