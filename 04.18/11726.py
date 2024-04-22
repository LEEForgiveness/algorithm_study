N = int(input())
arr=[0] * 1001
def dp(N):
    if N == 1:
        return 1
    elif N == 2:
        return 2
    if arr[N] != 0:
        return arr[N]
    arr[N] = (dp(N-1) + dp(N-2)) %10007

    return arr[N]
print(dp(N))