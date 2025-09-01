from sys import stdin

input = stdin.readline
INF = int(1e9)  # 10억을 INF로 사용

def floyd_warshall(n, graph):
    # 플로이드-워셜 알고리즘 수행
    for k in range(1, n + 1):  # 경유지
        for i in range(1, n + 1):  # 출발지
            for j in range(1, n + 1):  # 도착지
                if graph[i][k] != INF and graph[k][j] != INF:  # 경로가 없을 경우 연산 방지
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    # 결과 출력
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if graph[i][j] == INF:
                print(0, end=" ")  # 갈 수 없는 경우 0 출력
            else:
                print(graph[i][j], end=" ")
        print()

def main():
    n = int(input())  # 도시 개수
    m = int(input())  # 버스 개수

    # 그래프 초기화 (INF로 초기화)
    graph = [[INF] * (n + 1) for _ in range(n + 1)]

    # 자기 자신으로 가는 경로는 0
    for i in range(1, n + 1):
        graph[i][i] = 0

    # 그래프 입력 받기
    for _ in range(m):
        start, end, cost = map(int, input().split())
        graph[start][end] = min(graph[start][end], cost)  # 최소 비용 업데이트

    # 플로이드-워셜 실행
    floyd_warshall(n, graph)

if __name__ == "__main__":
    main()
