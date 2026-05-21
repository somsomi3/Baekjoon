import java.util.*;

class Solution {

    boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    void bfs(int start, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next = 0; next < computers.length; next++) {
                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}