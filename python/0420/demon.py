# https://school.programmers.co.kr/learn/courses/30/lessons/120808
import math

def d(numer1, denom1, numer2, denom2):
    a = denom1 * numer2 + numer1 * denom2
    b = denom1 * denom2
    c = math.gcd(a ,b)
    return [a/c, b/c]

print (d(1, 2, 3, 4))