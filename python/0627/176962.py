from datetime import datetime, timedelta

p = "12:40"

t = "50"

p = datetime.strptime(p,'%H:%M')

# print(p + timedelta(minutes=int(t)))

if p + timedelta(minutes=int(t)) > datetime.strptime("14:00", '%H:%M'):
    print("야미")
else:
    print("요미")

from collections import deque
from datetime import datetime, timedelta


def solution(plans):
    answer = []
    q = deque()

    plans.sort(key=lambda x: x[1])

    q.append(plans[0])
    # print(bool((datetime.strptime(plans[2][1], '%H:%M') + timedelta(int(plans[2][2]))).time() > datetime.strptime(plans[3][1],'%H:%M').time()))
    for i in range(1, len(plans)):
        plan = q.pop()
        # print((datetime.strptime(plan[1], '%H:%M') + timedelta(minutes=int(plan[2]))).time())
        # print(datetime.strptime(plans[i][1],'%H:%M').time())
        if (datetime.strptime(plan[1], '%H:%M') + timedelta(minutes=int(plan[2]))).time() > datetime.strptime(plans[i][1],'%H:%M').time():
            q.append(plan)
            q.append(plans[i])
        else:
            answer.append(plan[0])
            q.append(plans[i])
            # print(answer)

    # print(q)
    while q:
        answer.append(q.pop()[0])

    return answer
plans = [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]
print(solution(plans))

from collections import deque
from datetime import datetime, timedelta


def solution(plans):
    answer = []
    q = deque()

    plans.sort(key=lambda x: x[1])

    q.append(plans[0])

    for i in range(1, len(plans)):
        plan = q.pop()

        if (datetime.strptime(plan[1], '%H:%M') + timedelta(minutes=int(plan[2]))).time() > datetime.strptime(
                plans[i][1], '%H:%M').time():
            q.append(plan)
            q.append(plans[i])
        else:
            answer.append(plan[0])
            q.append(plans[i])

    while q:
        answer.append(q.pop()[0])

    return answer


def solution2(plans):
    answer = []
    stack = []

    for plan in plans:
        h, m = plan[1].split(":")
        plan[1] = int(h) * 60 + int(m)
        plan[2] = int(plan[2])

    plans.sort(key=lambda x: x[1])

    for i in range(len(plans) - 1):
        stack.append(plans[i][0], plans[i][2])
        gap = plans[i + 1][1] - plans[i][1]
        while stack and gap:
            if stack[-1][1] <= gap:
                subject, playtime = stack.pop()
                gap -= playtime
                answer.append(subject)
            else:
                stack[-1][1] -= gap
                gap = 0
    answer.append(plans[-1][0])

    for i in range(len(stack)):
        answer.append(stack[~i][0])

    return answer
