# 백준2606 virus

def dfs(graph, start, visited):
    visited[start] = True
    count = 1
    for i in range(1, len(graph[start])):
        if graph[start][i] == 1 and not visited[i]:
            count += dfs(graph, i, visited)
    return count

N = int(input())
M = int(input())

graph = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

print(dfs(graph, 1, visited) - 1)
