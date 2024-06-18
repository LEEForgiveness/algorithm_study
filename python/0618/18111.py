#다시 풀어보기
N, M, B = map(int, input().split())

graph = list()
values = dict()

for _ in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if graph[i][j] in values:
            values[graph[i][j]] += 1
        else:
            values[graph[i][j]] = 1

max_value = max(values)
min_value = min(values)
print(max_value)

working_time = 0
minium_time = int(1e9)
ground = 0
# 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.(2)
# 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.(1)
for i in range(min_value, max_value + 1):
    plus_block = 0
    minus_block = 0
    for key, value in values.items():
        if key > i:
            plus_block += (key - i) * value
        else:
            minus_block += (i - key) * value
    if plus_block + B < minus_block:
        continue
    else:
        working_time = (plus_block * 2) + minus_block
        if minium_time > working_time:
            minium_time = working_time
            ground = i
print(minium_time, ground)