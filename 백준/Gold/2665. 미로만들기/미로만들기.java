import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		dist = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String s= br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = s.charAt(j) -'0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		
		System.out.println(dist[N-1][N-1]);
	}
	static void bfs(int x, int y) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {x, y});
		dist[x][y] = 0;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int cx = cur[0];
			int cy = cur[1];
			

			for(int i = 0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
//				if(arr[nx][ny]==1)dq.addLast(dq.pollFirst());
				
				if(arr[nx][ny] == 1) {//흰방
				    if(dist[nx][ny] > dist[cx][cy]) {
				        dist[nx][ny] = dist[cx][cy];
				        dq.addFirst(new int[]{nx, ny});
				    }
				} else {//검은방
				    if(dist[nx][ny] > dist[cx][cy] + 1) {
				        dist[nx][ny] = dist[cx][cy] + 1;
				        dq.addLast(new int[]{nx, ny});
				    }
				}	
				
			}
		}
	}
	
}