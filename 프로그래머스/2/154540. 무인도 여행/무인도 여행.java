import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static boolean[][] visited;
    static int[][] dist;
    
    static int n;
    static int m;
    static String[] map;
    
    public int[] solution(String[] maps) {
        
        map = maps;
        
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        // dist = new int[n][m];
        
        List<Integer> list = new ArrayList<>(); 
        // boolean flag = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int ans = bfs(i, j);
                    list.add(ans);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);


        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    public int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int sum = map[x].charAt(y) - '0';
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int d =0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx<0 || ny<0|| nx>= n|| ny>=m)continue;
                if(visited[nx][ny])continue;
                if (map[nx].charAt(ny) == 'X') continue;
                
                visited[nx][ny] = true;
                sum += map[nx].charAt(ny) - '0';
                q.offer(new int[] {nx, ny});
                
            }
            
        }
        return sum;
    }
}