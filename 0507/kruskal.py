from collections import defaultdict
from heapq import heappush, heappop
class Graph:
    def __init__(self, vertices):
        self.V =vertices
        self.graph = defaultdict(list)

    def add_edge(self, start, end, weight):
        self.graph[start].append((end, weight))
        self.graph[end].append((start, weight))

    def kruskal(self):

        parent = {i:i for i in range(self.V)}

        def findUnion(v): #unionfind 구현
            if parent[v] != v:
                parent[v] = findUnion(parent[v])
            return parent[v]

        def unionParent(start, end):
            p1 = findUnion(start)
            p2 = findUnion(end)
            parent[p2] = p1

        edges = []
        for start in range(self.V):
            for end, dis in self.graph[start]:
                heappush((edges, dis, start, end)) #정렬

        mst = []
        while edges:
            dis, start, end = heappop(edges)
            if findUnion(start) != findUnion(end):
                unionParent(start, end)
                mst.append((start, end, dis))

        return mst
if __name__ == "__main__":
    g = Graph([0,1,2,3,4,5,6])
    g.add_edge(4,6,73)
    g.add_edge(0,1,67)

