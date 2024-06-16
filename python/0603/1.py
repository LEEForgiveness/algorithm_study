# n = 1 -> 1
# n = 2 -> 3
# n = 3 -> 5
# n = 4 -> 11
import sys

sys.setrecursionlimit(2000)

arr = [0] * 1001
def dp(n):
    if n == 0:
        return 1
    if n == 1:
        return 1
    if arr[n] > 0:
        return arr[n]
    arr[n] = dp(n - 1) + 2 * dp(n - 2)
    return arr[n]

n = int(input())
print(dp(n) % 10007)