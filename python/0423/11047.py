# https://www.acmicpc.net/problem/11047

n, k = map(int, input().split())
coin = []

for i in range(n):
    c = int(input())
    if(k > c):
        coin.append(c)
    