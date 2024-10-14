from datetime import datetime

def tagDesJahres(tag, monat, jahr):
    if(0 < tag < 32 and 0 < monat < 13 and jahr != 1023):
        tdj = datetime(jahr, monat, tag).timetuple().tm_yday
        print("Der ", tag,".", str(monat).zfill(2), ".", jahr, " ist der ", tdj, ". Tag des Jahres", sep='')
        return tdj
    else:
        print("Ungültiges Datum")
        return 0