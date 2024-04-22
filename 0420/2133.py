# n = 1 -> X
# n = 2 -> 3
# n = 3 -> X
# n = 4 -> 11
# n = 5 -> X
# n = 6 -> 41

def f(n):
    if(n == 0):
        return 1
    f(n - 2) * 3 +