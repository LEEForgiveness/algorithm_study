n = int(input())

for i in range(n, 0, -1):
    for j in range(1, n+1):
        print(' ' * (n - j), end='')
        print('*' * (i*2 -1), end='')
        print(' ' * (n - j))