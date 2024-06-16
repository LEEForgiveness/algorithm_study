# https://www.acmicpc.net/problem/1012

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]

def dfs(graph, visited, x, y):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1 and not visited[nx][ny]:
            dfs(graph, visited, nx, ny)
    return 1

# 강사님 코드
def dfs2(graph, x ,y):
    graph[x][y] = 0
    for i in range(4):
        ny = x + dy[i]
        nx = y + dx[i]
        if 0 <= nx < M and 0 <= ny < N and graph[nx][ny] == 1:
            dfs2(graph, ny, nx)

T = int(input())
for _ in range(T):
    #M은 가로 N은 세로 심어져있는 위치의 개수 K
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    count = 0
    for _ in range(K):
        a, b = map(int, input().split())
        graph[b][a] = 1
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1 and not visited[i][j]:
                count += dfs(graph, visited, i, j)
    print(count)