from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(graph, row, col):
    q = deque([(row, col)])
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < len(graph) and 0 <= nx < len(graph[0]) and graph[ny][nx] == 0:
                graph[ny][nx] = graph[y][x] + 1
                q.append((ny, nx))
                
M, N = map(int, input().split())
graph = [[0] * M for _ in range(N)]
for i in range(N):
    graph[i] = list(map(int, input().split()))
print(graph)
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if graph[i][j] == 1:
            bfs(graph, i, j)

for row in graph:
    print(row)

max_value = 0

for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(-1)
            exit()
        if max_value < graph[i][j]:
            max_value = graph[i][j]

print(max_value)