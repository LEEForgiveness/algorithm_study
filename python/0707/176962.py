def solution(plans):
    answer = []
    stack = []

    for plan in plans:
        h,m = plan[1].split(":")
        plan[1] = int(h) * 60 + int(m)
    
    plans.sort(key=lambda x: x[1])

    for i in range(len(plans) - 1):
        stack.append(plans[i])
        gap = plans[i + 1][1] - plans[i][i]
        stack and gap:
            if 
        
    return answer

print(solution([["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]))