# 문제
# 피카츄는 "pi", "ka", "chu"를 발음할 수 있다. 따라서, 피카츄는 이 세 음절을 합친 단어만 발음할 수 있다. 예를 들면, "pikapi"와 "pikachu"가 있다.
# 문자열 S가 주어졌을 때, 피카츄가 발음할 수 있는 문자열인지 아닌지 구하는 프로그램을 작성하시오.

# 출력
# 문자열 S가 "pi", "ka", "chu"를 이어 붙여서 만들 수 있으면 "YES"를 아니면 "NO"를 출력한다.
# 반례 kpia -> 답은 no, 출력은 yes가 나옴

pikachu = ["pi","ka","chu"]
a = input()

for s in pikachu:
    while s in a:
        a = a.replace(s, " ")
        # print(a)

a = a.replace(" ", "")

if len(a) > 0:
    print('NO')
else:
    print('YES')