# 숫자 3개 -> 소수
# input 3~50개
# 조합해서 더 3개씩 더해서 나올 수 있는 소수의 개수를 출력하시오

def isPrimeNumber(num):
    if num == 1: #num이 1일 수도 있으니깐
        return False
    for i in range(2, num):
        if num % i == 0:
            return False

    return True

def solution(numbers):
    sum = 0
    answer =0
    # for i in range(len(numbers) -2):
    #     for j in range(i+1, len(numbers) - 1):
    #         for k in range(j+1, len(numbers)):
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            for k in range(j+1, len(numbers)):
                print(i,j,k)
                sum = numbers[i] + numbers[j] + numbers[k]
                if isPrimeNumber(sum):
                    answer += 1

    print(answer)


solution([1, 2, 7, 6, 4])