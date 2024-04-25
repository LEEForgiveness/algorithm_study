# https://www.acmicpc.net/problem/1181

N = int(input())
words = []
for _ in range(N):
    word = input()
    words.append(word)

words = list(set(words))

words.sort()
words.sort(key=len)
for i in words:
    print(i)

