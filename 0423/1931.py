# https://www.acmicpc.net/problem/1931
# endtime 기준으로 start 타임이 그다음으로 크거나 같은 수를 계속 찾음
# time배열을 time.sort(key = lambda x: (x[1], x[0]))-> endtime을 기준으로 정렬한뒤에 starttime을 기준으로 정렬함