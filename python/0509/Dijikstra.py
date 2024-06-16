import sys
import heapq
from collections import defaultdict

inputs = sys.stdin.readline()
INF = int(1e9)

n, e = map(int, input().split())
start = int(input())

graph = defaultdict(list)
# graph 메트릭스 만들어주기
for _ in range(e):
    start, end, distance = map(int, input().split())
    graph[start].append((end, distance))
    graph[end].append((start, distance))

# list만들어주기
distance = [INF] * (n + 1)

def dijikstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, fivot = heapq.heappop(q)
        if distance[fivot] < dist:
            continue
        for node, cost in graph[fivot]:
            if distance[node] > dist + cost:
                distance[node] = dist + cost
                heapq.heappush(q, (distance[node], node))

    return distance

dijikstra(start)