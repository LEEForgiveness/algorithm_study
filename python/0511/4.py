# amount = 95000 coupons = [[50000, 4000, 0], [100000, 10000, 0], [150000, 30000, 0], [101000, 3000, 1], [30000, 1000, 1]]
# amount = 49000 coupons = [[30000, 5000, 1], [60000, 2000, 0], [70000, 17000, 0], [60000, 3000, 1]]
# amount = 30890 coupons = [[30000, 2859, 0], [50000, 4950, 0], [49990, 5045, 1]]
# amount = 50000 coupons = [[50000, 40000, 0], [150000, 100000, 0], [150000, 100000, 1]]
import heapq


# 쿠폰 1은 중복 가능(0을 쓴뒤에 쓸수 있음), 쿠폰 0은 0만 써야됨
# 최소 금액

def solution(amount, coupons):
    # print(amount)
    price = amount
    coupons.sort()
    ablecoupons1 = []
    ablecoupons2 = []
    coupons.sort(key=lambda x:x[0])
    for i in range(len(coupons)):
        if coupons[i][0] <= amount:
            if coupons[i][2] == 0:
                ablecoupons1.append(coupons[i])
            if coupons[i][2] == 1:
                ablecoupons2.append(coupons[i])

    # print(ablecoupons1)
    # print(ablecoupons2)
    minPrice2 = price
    if len(ablecoupons1) != 0:
        for coupon1 in ablecoupons2:
            if price - coupon1[1] < minPrice2:
                minPrice2 = price - coupon1[1]
    minPrice = minPrice2
    for coupon in ablecoupons1:
        if minPrice2 - coupon[1] < minPrice:
            minPrice = minPrice2 - coupon[1]

    # print("minPrice = ", minPrice)
    return minPrice

# amount = 49000
# coupons = [[30000, 5000, 1], [60000, 2000, 0], [70000, 17000, 0], [60000, 3000, 1]]
# amount = 95000
# coupons = [[50000, 4000, 0], [100000, 10000, 0], [150000, 30000, 0], [101000, 3000, 1], [30000, 1000, 1]]
# amount = 30890
# coupons = [[30000, 2859, 0], [50000, 4950, 0], [49990, 5045, 1]]
amount = 50000
coupons = [[50000, 40000, 0], [150000, 100000, 0], [150000, 100000, 1]]
result = solution(amount, coupons)
for i in range(len(coupons)):
    if coupons[i][0] > amount:
        amount = coupons[i][0]
        if solution(amount, coupons) < result:
            result = solution(amount, coupons)

if result < 0:
    result = 0

print(result)
