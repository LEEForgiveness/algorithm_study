import heapq

# a = int(input("숫자입력:"))
# b = int(input("입력하세요.:"))
# c = input("입력하세요.:")
# total = 0
#
# for i in range(a):
#     total += b%10
#     b = b/10
# for i in range(a):
#     total += int(c[i])
#
# print(int(total))

# a = input("문장을 입력하세요:")
# b = a.split(' ')
# print(len(b))

# c = []
# for i in range(a):
#     c.append(input("입력하세요.:").strip())
# print(c)
# c1 = list(set(c))
# c2 = list(set(c))
# c2.sort(key=lambda x: len(x))
#
# heap = []
# for word in c1:
#     heapq.heappush(heap, (len(word), word))
#
# for word in c1:
#     print(word)
#
# for word in c2:
#     print(word)
# print(bool(-1))
#
# m = 10
# n = 20
# def gcd(m,n):
#     while(True):
#         if(n==0):
#             return m
#         r = m % n
#         gcd(n,r)
#
# print(gcd(10,20))

def dfs(graph, v, visited):
    visited[v] = True
    count = 1
    print(v, end=' ')
    for i in range(1, len(graph)):
        if not visited[i] and graph[v][i] == 1:
            count +=dfs(graph, i, visited)
    return count

n = int(input())
m = int(input())

graph = [[0] * (n + 1) for _ in range(n + 1)]
# graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    # graph[a].append(b)
    # graph[b].append(a)
    graph[a][b] = graph[b][a] = 1
print(graph)
print(dfs(graph, 1, visited) - 1)