# https://www.acmicpc.net/problem/11726
# n = 1 -> 1
# n = 2 -> 2
# n = 3 -> 3
# n = 4 -> 5
# n = 5 -> 8
import sys
sys.setrecursionlimit(2000) #이걸 안해주면 재귀 횟수가 1000으로 제한되있어서 recursive runtime error발생
arr = [0] * 1001

def dp(n):
    if n == 0:
        return 1
    if n == 1:
        return 1
    if arr[n] > 0:
        return arr[n]
    arr[n] = dp(n - 1) + dp(n - 2)
    return arr[n]

n = int(input())
print(dp(n) % 10007)
