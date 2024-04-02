transform :: [Float] -> [Float]
transform values = map (sqrt . abs) values
