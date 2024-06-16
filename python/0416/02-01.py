# backjoon 2606 dfs Type 2
def dfs(graph, v, visited):
    visited[v] = True
    count = 1
    for i in graph[v]:
        if not visited[i]:
            count += dfs(graph, i , visited)
    return count

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in graph:
    i.sort()

print(dfs(graph, 1, visited) - 1)