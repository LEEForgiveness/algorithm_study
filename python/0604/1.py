# https://programmers-story.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC-deque-TypeError-cannot-unpack-non-iterable-int-object

from collections import deque

dx = [0,1,0,-1]
dy = [1,0,-1,0]

def bfs(maps, visited):
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] == 1 and visited[nx][ny] == False:
                q.append((nx, ny))
                visited[nx][ny] == True
                maps[nx][ny] = maps[x][y] + 1

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * len(maps[0]) for _ in range(len(maps))]
    answer = 0
    bfs(maps, visited)
    answer = maps[n - 1][m - 1]
    if answer == 1:
        return -1
    return answer