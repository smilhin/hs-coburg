import itertools

# Liste der Kugeln
kugeln = [1, 2, 3, 4]

# Erzeuge alle Permutationen der Kugeln (jeweils 3 Kugeln werden gezogen)
l = list(itertools.permutations(kugeln, 3))

print(l)