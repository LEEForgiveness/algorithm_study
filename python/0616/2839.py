N = int(input())
# 설탕은 5kg, 3kg가 있음

count = 0

while N > 0:
    if N % 5 == 0:
        count += (N // 5)
        N = 0
    else:
        N -= 3
        count += 1

if N < 0:
    count = -1
    print(count)
    exit()

print(count)
