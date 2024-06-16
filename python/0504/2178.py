# https://www.acmicpc.net/problem/2178

from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 강사님 코드
def bfs(graph, x, y, visited):
    queue = deque([(y, x)])
    visited[y][x] = True
    while queue:
        row, col = queue.popleft()
        for i in range(4):
            nx = col + dx[i]
            ny = row + dy[i]
            if 0 <= nx < M and 0 <= ny < N and graph[ny][nx] == 1 and not visited[ny][nx]:
                queue.append((ny, nx))
                visited[ny][nx] = True
                graph[ny][nx] = graph[row][col] + 1

N, M = map(int, input().split())

graph = []
visited = [[False] * M for _ in range(N)]


for _ in range(N):
    graph.append(list(map(int, input().strip())))

bfs(graph, 0, 0, visited)
print(graph[N - 1][M - 1])