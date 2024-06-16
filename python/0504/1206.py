# https://www.acmicpc.net/problem/1260

from collections import deque

def bfs(graph, V, visited):
    queue = deque([V])
    visited[V] = True
    while queue:
        visit = queue.popleft()
        visited[visit] = True
        print(visit, end=' ')
        for i in range(1, len(graph[V])):
            if graph[visit][i] == 1 and visited[i] != True:
                queue.append(i)
                visited[i] = True #여기를 추가 안해서 틀렸음

# 강사님 코드
def dfs(graph, visited, V):
    visited[V] = True
    print(V, end=' ')
    for i in range(1, len(graph)):
        if not visited[i] and graph[V][i] == 1:
            dfs(graph, visited, i)

N, M, V = map(int, input().split())

graph = [[0] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)

for _ in range(M):
    i, j = map(int, input().split())
    graph[i][j] = graph[j][i] = 1
# print(graph)

bfs(graph, V, visited)
