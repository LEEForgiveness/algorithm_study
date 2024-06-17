N = int(input())

conference = list()

for _ in range(N):
    a, b = map(int, input().split())
    conference.append([a,b])

print(conference)

conference = sorted(conference, key = lambda x: (x[1], x[0]))

print(conference)

count = 1
end = conference[0][1]

for i in range(1, N):
    if end <= conference[i][0]:
        end = conference[i][1]
        count += 1

print(count)