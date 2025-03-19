import sys

sys.setrecursionlimit(10**6)  # 재귀 깊이 제한 증가
input = sys.stdin.readline

# 입력 받기
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
stack = []

# 그래프 생성
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)  # A → B (A가 B보다 앞에 서야 함)

# DFS 함수
def dfs(node):
    visited[node] = True
    for next_node in graph[node]:
        if not visited[next_node]:
            dfs(next_node)
    stack.append(node)  # 방문이 끝난 노드를 스택에 추가 (위상 정렬 역순 저장)

# 모든 노드에 대해 DFS 수행
for i in range(1, N + 1):
    if not visited[i]:
        dfs(i)

# 스택을 역순으로 출력 (위상 정렬 결과)
print(*stack[::-1])
