def dfs(graph, v, visited):
    count = 0
    print(v, end=' ')
    visited[v] = True
    for i in range(n + 1):
        count += dfs(graph, i, visited)
    return count

n = int(input())
m = int(input())

graph = [[0] * (n + 1) for _ in (n+1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

print(dfs(graph, 1, visited) - 1)