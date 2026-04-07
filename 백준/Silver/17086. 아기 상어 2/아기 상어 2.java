import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0;d<8;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                if(dist[nx][ny] == 0 && map[nx][ny] == 0){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }
}