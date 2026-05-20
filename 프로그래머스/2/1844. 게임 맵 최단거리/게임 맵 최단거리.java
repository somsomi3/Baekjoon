import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        //세로, 가로
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx<0 || ny< 0|| nx>=n|| ny>=m)continue;//범위 검사 먼저
                if (maps[nx][ny] == 0) continue;
                if(visited[nx][ny])continue;
                
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y]+1;
                
                q.offer(new int[]{nx, ny});
                
            }
        }
        return dist[n-1][m-1];
    }
}