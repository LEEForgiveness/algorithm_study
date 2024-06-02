dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(graph, y, x):
    print("dfs")
    graph[y][x] = 0
    count = 1
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < len(graph[0]) and 0 <= ny < len(graph) and graph[ny][nx] == 1:
            dfs(graph, ny, nx)
    return count

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1
    print(graph)
    count = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                dfs(graph, i, j)
                count += 1
    print("count: ", count)