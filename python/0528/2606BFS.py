from collections import deque

n = int(input())
node = int(input())
graph = [[0] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(node):
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = 1

def bfs(graph, visited, start):
    q = deque()
    q.append(start)
    count = 1
    visited[start] = True
    while q:
        a = q.popleft()
        for i in range(len(graph)):
            if graph[a][i] == 1 and visited[i] == False:
                q.append(i)
                print(q)
                visited[i] = True
                count += 1
    return count

print("bfs: ", bfs(graph, visited, 1) - 1)