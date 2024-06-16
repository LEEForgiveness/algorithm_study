# 어떤 기계를 만드는데 기계에 들어가는 부품이 있고 부품명이 있고 부품을 누가 훔쳐갔는데 설계도와 같은 이름의 부품이 있으면 걸러내라
# ["A B C D E", "F G"] ["A b C d E", "E D C B A", "F G G G G", "A B C D E"] -> [1, 1, 1, 1]
# 원래 상품: ["A A b C", "X Y Z", "A X Y"] ["A A b c X Y Z", "A B C X", "A C B C B", "Q", "A A b"] -> [0, 0, 1, 0, 0]

# X, Y는 배열
def solution(x, y):
    answer = [0] * (len(y))
    for i in range(len(x)):
        x[i] = x[i].upper()
    for j in range(len(y)):
        y[j] = y[j].upper()

    print(x ,y)

    for k in x:
        k = set(k)
        print("k =", k)
        for l in range(len(y)):
            y[l] = set(y[l])
            print("y[l] = ", y[l])
            if k == y[l]: #set끼리 비교하면 순서 달라도 같은 값 들어있으면 같음
                answer[l] = 1
            print("answer = ", answer)
    print(answer)

def solution2(originals, fakes):
    answer = []
    for original in originals:
        set(original.upper().replace(" ",""))


solution(["A A b C", "X Y Z", "A X Y"], ["A A b c X Y Z", "A B C X", "A C B C B", "Q", "A A b"])
solution(["A B C D E", "F G"], ["A b C d E", "E D C B A", "F G G G G", "A B C D E"])

print(bool(set([1 ,3 ,2]) == set([3, 2 ,1])))
print(hash("ABC") == hash("BAC")) #False
print(hash("".join("ABC")))
print(hash("".join("BCA")))
print(hash("".join(set("ABC"))))
print(hash("".join(set("BCA"))))