import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int d = 0; d < 4; d++) {
            cost[0][0][d] = 0;
            q.offer(new int[]{0, 0, d, 0});
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], c = cur[3];
            
            for (int nd = 0; nd < 4; nd++) {
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;
                
                int nc = c + 100;
                if (dir != nd) nc += 500;
                
                if (cost[nx][ny][nd] > nc) {
                    cost[nx][ny][nd] = nc;
                    q.offer(new int[]{nx, ny, nd, nc});
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, cost[n-1][n-1][d]);
        }
        
        return answer;
    }
}