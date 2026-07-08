import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] land;
    static int n, m;

    public int solution(int[][] land) {
        Solution.land = land;
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        
        int[] oil = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, oil);
                }

            }
        }
        int answer = 0;

        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, oil[i]);
        }

        return answer;
    }

    public void bfs(int x, int y, int[] oil) {
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visited[x][y] =true;
        
        HashSet<Integer> set = new HashSet<>();
        
        set.add(y);
        
        int count = 1;
        
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {

                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (land[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;

                q.offer(new int[]{nx, ny});

                count++;

                set.add(ny);
            }
        }

        for (int col : set) {
            oil[col] += count;
        }

    }
}