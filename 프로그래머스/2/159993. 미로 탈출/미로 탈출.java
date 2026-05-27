import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] dist;
    
    static String[] mapArr;
    static int n;
    static int m;
    
    public int solution(String[] maps) {
        int answer = 0;
        mapArr = maps;
        //세로 가로
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m]; //세로 가로
        dist = new int[n][m];
        
        //시작점
        int sx = 0;
        int sy = 0;
        
        //레버좌표
        int x = 0;
        int y = 0;
        
        //문 좌표
        int a = 0;
        int b = 0;
        
        //레버, 문 찾기
        for(int i = 0; i< maps.length; i++){
            String s = maps[i];
            for(int j = 0; j < maps[0].length(); j++){
                char c = s.charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                }else if(c=='L'){
                    x = i;
                    y = j;
                }else if(c =='E'){
                    a = i;
                    b = j;
                }
                
            }
        }
        
        bfs(sx, sy);
        int q = dist[x][y];
        
        if (!visited[x][y]) {
            return -1;
        }
        
        //dist 초기화, visited도 초기화
        visited = new boolean[n][m];
        dist = new int[n][m];

        bfs(x, y);
        int w = dist[a][b];
        
        //문자 쪼개면서 돌면서 'O'또는 '문'이면 가능 하고 , X는 지나갈수 없다.
        //레버를 누르러 갈때에도, 문으로 갈때에도(굳이 레버는 넣어줄 필요가 없다
        //최단 거리를 구하기 때문에 또한번 레버를 지날 필요가 없다.)
        if (!visited[a][b]) {
            return -1;
        }

        answer= q+ w;
        
        return answer;
    }
    public void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visited[x][y]= true;
        //여기서 dist 를 fill해줬어야 했나...?
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int cx = cur[0];
            int cy = cur[1];
            
            for(int d = 0; d< 4; d++){
                
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                

                if(nx<0|| ny<0|| nx>=n|| ny>=m)continue;//이거 제일 먼저
                if(visited[nx][ny])continue;
                // if(배열에서 X이면 안됨.. 그럼 arr을 만들어야 하나..? )
                if (mapArr[nx].charAt(ny) == 'X') continue;
                    
                visited[nx][ny] = true;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.offer(new int[] {nx, ny});
            }     
        }        
    } 
}