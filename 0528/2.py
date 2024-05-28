# https://www.acmicpc.net/problem/1260

def init():
    n, m, v = map(int, input().split())
    graph = [[0] * (n + 1) for _ in range(n + 1)]
    visited = [False] * (n + 1)
    for _ in range(m):
        x, y = map(int, input().split())
        graph[x][y] = graph[y][x] = 1

def dfs(graph, visited, start):
    visited[start] = True
    for i in range(len(graph)):
        graph[start]