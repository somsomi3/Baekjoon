import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] dist;
	static boolean[][] visited;
//	static final int[] dx = {0, 0, 0, 0};
//	static final int[] dy = {-1, 1, 0, 0};
//	static final int[] dz = {0, 0, 1, -1};
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//6, 4는 M, N
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];// 세로N 가로M
        visited = new boolean[N][M];
        dist = new int[N][M];
        
        Queue<int[]> q = new ArrayDeque<>();
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==1)q.offer(new int[] {i,j});
			}
		}
//		for(int i =0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<M; j++) {
//				Queue<int[]> q = new ArrayDeque<>();
//				if(arr[i][j] == 1) {
//					q.offer(new int[] {i, j});
//				}
//			}
//		}
		
		
		bfs(q);
		
		int ans = 0;
		for(int i= 0; i<N; i++) {
			for(int j =0; j<M; j++) {
//				if(arr[i][j] =0 || arr[i][j] =1) {
				if(arr[i][j] == 0) {
					System.out.println("-1");
					return;
				}
               ans = Math.max(ans, dist[i][j]);
			}
		}
		System.out.println(ans);
	}
	
	static void bfs(Queue<int[]> q) {
//		Queue<int[]> qq = new ArrayDeque<>();
//		visited[x][y]= true;
//		dist[x][y] = 1;
//        qq.offer(new int[]{x, y});
		
		while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
			
			for(int k =0; k<4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
				
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//                if (visited[nx][ny] || arr[nx][ny] == 0) continue;
                if (arr[nx][ny] != 0) continue;
			
                arr[nx][ny] = 1; // 익은 표시 추가 
				visited[nx][ny]= true;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.offer(new int[]{nx, ny});
				
			}
		}
	}
}
