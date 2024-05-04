# https://www.acmicpc.net/problem/1937

#출발하는 값에서 최대로 갈수 있는 칸 수를 기억해놓자
#백준에서 sys.setrecursionlimit(10**6)추가해야지 맞음
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

#강사님 코드임
def dfs(graph, x, y, n, memo):
    if memo[x][y] == -1:
        memo[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and graph[x][y] < graph[nx][ny]:
            memo[x][y] = max(memo[x][y], dfs(graph, nx, ny, n, memo) + 1)

    return memo[x][y]

n = int(input())

graph = []
memo = [[-1] * n for _ in range(n)]
max_value = 0
for i in range(n):
    graph.append(list(map(int, input().split())))
# print(graph)

for i in range(n):
    for j in range(n):
        if memo[i][j] == -1:
            max_value = max(dfs(graph, i, j, n, memo), max_value)
print(max_value)