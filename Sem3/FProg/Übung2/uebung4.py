l = list(map(lambda n: list(filter(lambda x: x % 5 == 0, range(1, n + 1))), [47, 11, 4]))
print(l)