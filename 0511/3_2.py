dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def dfs(graph, visited, x, y):
    visited[y][x] = 1
    if graph[y][x] == 0:
        return 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph) and graph[ny][nx] != 0 and visited[ny][nx] == 0:
            dfs(graph, visited, nx, ny)
            visited[ny][nx] = visited[y][x] + 1
    return visited[4][4]


graph = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
visited = [[0] * (len(graph)) for _ in range(len(graph))]
print(dfs(graph, visited, 0, 0))