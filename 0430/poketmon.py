# https://www.acmicpc.net/problem/1620

import sys

n, m = map(int, sys.stdin.readline().split())
poketmon = {}
poketmon2 = {}

for i in range(1, n+1):
    name = sys.stdin.readline().rstrip()
    poketmon[i] = name
    poketmon2[name] = i

for _ in range(m):
    q = sys.stdin.readline().rstrip()
    if q.isdigit():
        print(poketmon[int(q)])
    else:
        print(poketmon2[q])
        