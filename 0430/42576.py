def solution(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for part in participant:
        dic[hash(part)] = part
        temp += int(hash(part))
    print(temp)
    print(dic)
    for com in completion:
        temp -= hash(com)
    answer = dic[temp]
    return answer

    # participant.sort()
    # completion.sort()
    # for p, c in zip(participant, completion):
    #     if p != c:
    #         return p
    # return participant[-1]