n = 10
parent = [i for i in range(n+1)]

def getParent(parent, x):
    if parent[x] == x:
        return x
    return getParent(parent, parent[x])

def unionParent(a, b):
    # a와 b의 부모 노드를 찾는다.
    a = getParent(parent, a)
    b = getParent(parent, b)
    # a가 b보다 작다면 b의 부모 노드는 a가 된다.
    if a < b:
        parent[b] = a
    # 그렇지 않은 경우는 a의 부모 노드를 b로 설정한다.
    else:
        parent[a] = b

def findUnion(a,b):
    if getParent(parent, a) == getParent(parent, b):
        return True
    return False


# (1,2), (2,3), (4,5), (5,6), (6,7), (7,8), (8,9)
unionParent(1, 2)
unionParent(2, 3)
unionParent(4, 5)
unionParent(5, 6)
unionParent(6, 7)
unionParent(7, 8)
unionParent(8, 9)

print(parent)
print(parent)
print(findUnion())