import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline
MAX = 50 + 10

dir_column = [0, 0, 1, -1]
dir_row = [1, -1, 0, 0]

def dfs(graph, row, column):
    graph[row][column] = 0
    
    for i in range(4):
        next_row = row + dir_row[i]
        next_column = column + dir_column[i]
        if 0 <= next_row < n and 0 <= next_column < m and graph[next_row][next_column] == 1:
            dfs(graph, next_row, next_column)

t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    
    for _ in range(k):
        column, row = map(int, input().split())
        graph[row][column] = 1
    
    count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(graph, i, j)
                count += 1
    
    print(count)