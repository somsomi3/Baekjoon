T = int(input())  # 스위치 개수
arr = list(map(int, input().split()))  # 초기 스위치 상태

N = int(input())  # 학생 수
for _ in range(N):
    M, L = map(int, input().split())  # 성별, 받은 수
    L -= 1  # 0 기반 인덱스 조정

    if M == 1:  # 남자의 경우
        for i in range(L, T, L + 1):  # L+1 간격으로 스위치 반전
            if i < T:  # 인덱스 범위 체크
                arr[i] = 1 - arr[i]
    else:  # 여자의 경우
        arr[L] = 1 - arr[L]  # 본인 스위치 반전
        r = 1
        while L - r >= 0 and L + r < T and arr[L - r] == arr[L + r]:
            arr[L - r] = 1 - arr[L - r]
            arr[L + r] = 1 - arr[L + r]
            r += 1

# 출력
for i in range(0, T, 20):
    print(*arr[i:i + 20])
