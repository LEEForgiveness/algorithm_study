# 길 최단거리 찾기
# [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]] -> 11
# [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]] -> -1
# 시작점은 (0,0), 도착점(n,n)

from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def dfs(graph, visited2, x, y):
    visited2[y][x] = 1
    if graph[y][x] == 0:
        return 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph) and graph[ny][nx] != 0 and visited2[ny][nx] == 0:
            dfs(graph, visited, nx, ny)
            visited2[ny][nx] = visited[y][x] + 1

    print(visited2[len(graph) - 1][len(graph) - 1])

def bfs(graph, visited):
    q = deque()
    q.append((0, 0))
    visited[0][0] = True

    while q:
        x,y = q.popleft()
        visited[y][x] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < len(graph) and 0 <= ny < len(graph) and graph[ny][nx] !=0 and not visited[ny][nx]:
                q.append((nx, ny))
                graph[ny][nx] = graph[y][x] + 1

    if visited[len(graph) - 1][len(graph) - 1]:
        print(graph[len(graph) - 1][len(graph) - 1])
    else:
        print(-1)

graph = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
visited = [[False] * (len(graph)) for _ in range(len(graph))]
bfs(graph, visited)
graph2 = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
visited2 = [[0] * (len(graph)) for _ in range(len(graph))]
dfs(graph, visited2, 0, 0)


