def rechne(func, *numbers):
    return tuple(func(num) for num in numbers)

def sq(z):
    return z*z

print(rechne(sq, 1, 3, 4, 7))