# https://www.acmicpc.net/problem/2231

N = int(input())

result = 0

for i in range(N):
    j = str(i)
    sum = 0
    for k in j:
        sum += int(k)
    if sum + i == N:
        result = i

print(result)