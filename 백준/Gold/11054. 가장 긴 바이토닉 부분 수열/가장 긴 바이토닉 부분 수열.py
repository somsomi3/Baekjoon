import sys

input = sys.stdin.readline

# 입력 받기
n = int(input())
arr = list(map(int, input().split()))

# 증가하는 부분 수열 (LIS)
dp1 = [1] * n
for i in range(n):
    for j in range(i):
        if arr[j] < arr[i]:  # 증가 조건
            dp1[i] = max(dp1[i], dp1[j] + 1)

# 감소하는 부분 수열 (LDS) (거꾸로 계산)
dp2 = [1] * n
for i in range(n-1, -1, -1):
    for j in range(i+1, n):
        if arr[j] < arr[i]:  # 감소 조건
            dp2[i] = max(dp2[i], dp2[j] + 1)

# 바이토닉 수열의 최대 길이 계산
result = max(dp1[i] + dp2[i] - 1 for i in range(n))
print(result)
