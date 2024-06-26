N = int(input())
P = list(map(int, input().split()))

P.sort()

print(P)


temp2 = 0
for i in range(len(P),0, -1):
    temp = 0
    for j in range(i):
        temp += P[j]
    temp2 += temp

print(temp2)