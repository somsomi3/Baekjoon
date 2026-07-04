import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][][] cost;
    static int N;
    static int[][] map;
    public int solution(int[][] board) {
        map = board;
        N = board.length;
        
        cost = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs();
        
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, cost[N - 1][N - 1][d]);
        }

        return answer;
    
    }
    public void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        q.offer(new int[]{0, 0, 3});

        cost[0][0][1] = 0;
        cost[0][0][3] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int curDir = cur[2];
            
            
            for(int d = 0; d< 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if (map[nx][ny] == 1)
                    continue;
                
                int newCost;

                if (curDir == d)
                    newCost = cost[cx][cy][curDir] + 100;
                else
                    newCost = cost[cx][cy][curDir] + 600;

                if (newCost < cost[nx][ny][d]) {
                    cost[nx][ny][d] = newCost;
                    q.offer(new int[]{nx, ny, d});
                }
            }
        }
    }
}