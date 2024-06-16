# https://www.acmicpc.net/problem/1065

N = int(input())

count = 0

for i in range(1, N+1):
    if i < 100:
        count += 1
    else:
        j = str(i)
        if (int(j[0]) + int(j[2])) / 2 == int(j[1]):
            count += 1

print(count)