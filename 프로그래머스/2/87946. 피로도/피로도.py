def solution(k, dungeons):
    answer = 0
    visited = [False] * len(dungeons)

    def dfs(fatigue, cnt):
        nonlocal answer
        answer = max(answer, cnt)

        for i in range(len(dungeons)):
            need, consume = dungeons[i]

            if not visited[i] and fatigue >= need:
                visited[i] = True
                dfs(fatigue - consume, cnt + 1)
                visited[i] = False

    dfs(k, 0)
    return answer
