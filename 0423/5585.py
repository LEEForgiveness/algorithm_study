# https://www.acmicpc.net/problem/5585
n = int(input())

a = 1000 - n
b = [500, 100, 50, 10, 5, 1]
count = 0
for i in b:
    count +=(a // i)
    a = a % i
print(count)