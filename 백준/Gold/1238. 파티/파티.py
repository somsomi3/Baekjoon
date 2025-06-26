import sys
import heapq

input = sys.stdin.readline
INF = float('inf')

# 입력 받기
N, M, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, t = map(int, input().split())  # a → b (가중치 t)
    graph[a].append((b, t))

# 다익스트라 알고리즘 (최단 경로 탐색)
def dijkstra(start):
    distance = [INF] * (N + 1)
    distance[start] = 0
    heap = [(0, start)]  # (거리, 노드)
    
    while heap:
        dist, node = heapq.heappop(heap)
        
        if dist > distance[node]:
            continue
        
        for next_node, weight in graph[node]:
            new_dist = dist + weight
            if new_dist < distance[next_node]:
                distance[next_node] = new_dist
                heapq.heappush(heap, (new_dist, next_node))
    
    return distance

# 1️⃣ 각 학생들의 집 → X번 마을 최단 거리
to_X = [dijkstra(i)[X] for i in range(1, N + 1)]

# 2️⃣ X번 마을 → 모든 학생들의 집 최단 거리
from_X = dijkstra(X)

# 3️⃣ 왕복 거리 계산
max_time = max(to_X[i] + from_X[i + 1] for i in range(N))

print(max_time)
