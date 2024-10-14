heim = set(["Andi", "Ben", "Carl", "Daniel"])
gast = set(["Emil", "Finn", "Gerd", "Holger"])
star = set(["Rafael"])

heim_v_alle = {(h, a) for h in heim for a in gast | star}

star_v_gast = {(s, g) for s in star for g in gast}

paare = heim_v_alle | star_v_gast

print(paare)