n = int(input())
arr = [0] * 1001

def f(n):
    if(n) == 1:
        return 1
    if(n) == 2:
        return 3
    if arr[n] !=0:
        return arr[n]
    arr[n] = (f(n - 1) + f(n - 2) * 2) % 10007
    return arr[n]

print(f[n])