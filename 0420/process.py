from collections import deque
# https://school.programmers.co.kr/learn/courses/30/lessons/42587
def process(priorities, location):
    q = [(i, item)for i, item in enumerate(priorities)]
    print(q)
    count = 0
    while q:
        id, value = q.pop(0)
        if any(value < q[i][1] for i in range(len(q))):
            q.append((id, value))
        else:
            count += 1
            if id == location:
                return count
    return count

def process2(priorities, location):
    z = priorities[location]
    q = [(i, item) for i, item in enumerate(priorities)]
    print(q)
    # x = max(priorities)
    # print(x)
    count = 0
    # while q:
    # y = q.popleft()
    # if(y != x):
    #     q.append(y)
    # else:
    #     count += 1
    #     if(z == y):
    #         return count


print(process([2,1,3,2], 2))

