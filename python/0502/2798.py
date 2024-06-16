# https://www.acmicpc.net/problem/2798

N, M = map(int, input().split())

K = list(map(int,input().split()))

result = 0

for i in range(len(K)):
    for j in range(i + 1, len(K)):
        for k in range(j + 1, len(K)):
            if K[i] + K[j] + K[k] <= M:
                result = K[i] + K[j] + K[k]

print(result)