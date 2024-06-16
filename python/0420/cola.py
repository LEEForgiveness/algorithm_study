def cola(a, b, n):
    #a가 받는 빈병 갯수, b가 a개를 가져다주면 마트가 주는 콜라 병 수, n이 상빈이가 가지고 있는 병 갯수
    count = 0
    while n >= a:
        c = n % a
        print("c:",c)
        n = (n // a) * b
        print("n:",n)
        count += n
        print("count:",count)
        n = n + c
    return count

print(cola(2, 1, 20))
print(cola(3, 1, 20))