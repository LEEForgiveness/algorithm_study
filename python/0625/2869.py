A, B, V = map(int, input().split())

temp = (V - B) % (A - B)

if temp == 0:
    print((V - B) // (A - B))
else:
    print((V - B) // (A - B) + 1)

# (A - B) * (i - 1) + A >= V
# i - 1 >= V - A / (A - B)
# i >= (V - A) / (A - B) + 1