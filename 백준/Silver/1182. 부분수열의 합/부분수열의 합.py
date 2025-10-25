# 입력 받기
N, S = map(int, input().split())
num = list(map(int, input().split()))

cnt = 0  # 부분 수열 합이 S와 같은 경우의 수
ans = []  # 현재 탐색 중인 부분 수열을 저장할 리스트

def solve(start):
    global cnt
    # 현재 부분 수열의 합이 S와 같고, 부분 수열이 비어 있지 않을 때 카운트
    if sum(ans) == S and len(ans) > 0:
        cnt += 1

    # 부분 수열을 계속 확장하기 위해 재귀적으로 호출
    for i in range(start, N):
        ans.append(num[i])  # 현재 숫자를 부분 수열에 추가
        solve(i + 1)  # 다음 숫자 탐색을 위해 재귀 호출
        ans.pop()  # 현재 숫자를 부분 수열에서 제거

# 탐색 시작
solve(0)

# 결과 출력
print(cnt)
