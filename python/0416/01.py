# backjoon 2606 dfs

def dfs(graph, v, visited):
    visited[v] = True
    count = 1
    print(v, end=' ')
    for i in range(1, len(graph)):
        if not visited[i] and graph[v][i] == 1:
            count += dfs(graph, i, visited)
    return count

n = int(input())
m = int(input())

graph = [[0] * (n+1) for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

# print(graph)

print(dfs(graph, 1, visited) - 1)

