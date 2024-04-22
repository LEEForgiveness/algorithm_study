# https://school.programmers.co.kr/learn/courses/30/lessons/120876

def solution(lines):
    a = [0] * 200
    answer = 0
    for i in range(len(lines)):
        for j in range(len(lines[0])):
            lines[i][j] = lines[i][j] + 100
    for k,m in lines:
        for n in range(k, m):
            a[n] += 1
    # print(a)
    for x in range(200):
        if a[x] >= 2:
            answer += 1
    return answer

print(solution([[0, 1], [2, 5], [3, 9]]))