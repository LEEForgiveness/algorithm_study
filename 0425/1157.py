# https://www.acmicpc.net/problem/1157
#내가 안품 다시 풀어보기
words = list(input().strip().upper())
count_list = [0] * 26

for word in words:
    count_list[(ord(word) - ord('A'))] += 1

max_count = 0
max_count = 0
for i in range(26):
    if count_list[i] > max_count:
        max_count = count_list[i]
        max_index = i

if count_list.count(max(count_list)) > 1:
    print("?")
else:
    print(chr(max_index + ord('A')))