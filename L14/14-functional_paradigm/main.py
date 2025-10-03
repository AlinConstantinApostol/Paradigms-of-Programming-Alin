from functools import reduce

l = [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]
l = list(filter(lambda x: x >= 5, l))
l = map(lambda pair: pair[0] * pair[1], # aplicam inmultirea pe fievare pereche
                    [l[i:i + 2] for i in range(0, len(l), 2)
                     # impartim lista in perechi consecutive de cate 2 elemente
                     if i + 1 < len(l)])
l = reduce(lambda acc, x: acc + x, l, 0)


print(l)
