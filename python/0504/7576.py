# https://www.acmicpc.net/problem/7576
# 강사님 코드임
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(graph, queue, visited):
    while queue:
        row, col = queue.popleft()
        for i in range(4):
            nx = col + dx[i]
            ny = row + dy[i]
            if 0 <= nx < M and 0 <= ny < N and graph[ny][nx] == 0 and not visited[ny][nx]:
                queue.append((ny, nx))
                visited[ny][nx] = True
                graph[ny][nx] = graph[row][col] + 1


M, N = map(int, input().split())

graph = []
visited = [[False] * M for _ in range(N)]
# print(visited)
queue = deque()

for _ in range(N):
    graph.append(list(map(int, input().split())))
# print(graph)

for i in range(M):
    for j in range(N):
        if graph[j][i] == 1:
            queue.append((j, i))
            visited[j][i] = True

bfs(graph, queue, visited)

max_value = 0

for row in graph:
    print(row)

for item in graph:
    if 0 in item:
        print(-1)
        exit()
    max_value = max(max_value, max(item))
print(max_value - 1)