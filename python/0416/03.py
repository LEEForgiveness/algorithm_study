# backjoon 2606 bfs 
from collections import deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    count = 0
    while queue:
        v = queue.popleft()
        count += 1
        print(v, end=' ')
        for i in graph[v]: 
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    return count - 1

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

print(bfs(graph, 1, visited))