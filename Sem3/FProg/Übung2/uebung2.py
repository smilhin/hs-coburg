def wochentag(day, month, year):
    leapyear = ((year % 4 == 0) and (year % 100 != 0)) or (year % 400 == 0)
    y=year
    m = month

    daysInMonth = [
        0,
        31,
        29 if leapyear else 28,
        31,
        30,
        31,
        30,
        31,
        31,
        30,
        31,
        30,
        31
    ]

    if month > 12 or day > daysInMonth[month]:
        print(f"{day:02}.{month:02}.{year} ist ein ungültiges Datum")
        return 'ungültig'


    if month == 1:
        m = 13
        y -= 1

    elif month == 2:
        m = 14
        y -= 1


    j = y % 100
    c = y // 100

    wnum = (day + (26 * (m + 1) // 10) + (5*j // 4) + (c // 4) + 5*c - 1) % 7

    wtag = {
        1: "Montag",
        2: "Dienstag",
        3: "Mittwoch",
        4: "Donnerstag",
        5: "Freitag",
        6: "Samstag",
        0: "Sonntag"

    }[wnum]

    print(f"Der {day:02}.{month:02}.{year} ist ein {wtag}.")
    return wtag