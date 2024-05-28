# https://www.acmicpc.net/problem/1260

from collections import deque

n, m, v = map(int, input().split())
graph = [[0] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)
for _ in range(m):
        x, y = map(int, input().split())
        graph[x][y] = graph[y][x] = 1

def dfs(graph, visited, start):
    visited[start] = True
    print(start, end=' ')
    for i in range(len(graph)):
        if graph[start][i] == 1 and visited[i] == False:
            dfs(graph, visited, i)

def bfs(graph, visited, start):
    q = deque([start])
    visited[start] = True
    while q:
        v = q.popleft()
        print(v, end=' ')
        for i in range(len(graph)):
            if graph[v][i] == 1 and visited[i] == False:
                q.append(i)
                print(q)
                visited[i] = True

dfs(graph, visited, v)
visited = [False] * (n + 1)
print(graph)
print(visited)
bfs(graph, visited, v)