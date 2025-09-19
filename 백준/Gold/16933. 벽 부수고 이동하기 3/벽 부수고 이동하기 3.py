from collections import deque
import sys
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

n, m, k = map(int, input().split())
INF = float('inf')

grid = [list(map(int, input().strip())) for _ in range(n)]
visited = [[[INF] * (k + 1) for _ in range(m)] for _ in range(n)]
visited[0][0][k] = 0

queue = deque()
queue.append((0, 0, 1, k))  # (x, y, time, remaining_walls)

answer = INF

while queue:
    x, y, time, remaining = queue.popleft()

    if x == m - 1 and y == n - 1:
        answer = min(answer, time)
        continue

    is_day = time % 2 == 1

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]

        if not (0 <= nx < m and 0 <= ny < n):
            continue

        if grid[ny][nx] == 0 and visited[ny][nx][remaining] > time:
            visited[ny][nx][remaining] = time
            queue.append((nx, ny, time + 1, remaining))

        elif grid[ny][nx] == 1 and remaining > 0 and visited[ny][nx][remaining - 1] > time:
            if is_day:
                visited[ny][nx][remaining - 1] = time
                queue.append((nx, ny, time + 1, remaining - 1))
            else:
                queue.append((x, y, time + 1, remaining))

print(answer if answer < INF else -1)
