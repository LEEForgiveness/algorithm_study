from collections import deque

dx = [1, 0, -1 ,0]
dy = [0, -1, 0, 1]

def bfs(graph, visited):
    q = deque()
    q.append((0, 0))
    visited[0][0] = True

    while q:
        x, y = q.popleft()
        visited[y][x] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(graph) and 0 <= ny < len(graph) and graph[ny][nx] != 0 and not visited[ny][nx]:
                q.append((nx, ny))
                graph[ny][nx] = graph[y][x] + 1

    if visited[len(graph) - 1][len(graph) - 1]:
        print(graph[len(graph) - 1][len(graph) - 1])
    print(-1)

graph = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
visited = [[False] * (len(graph)) for _ in range(len(graph))]
bfs(graph, visited)