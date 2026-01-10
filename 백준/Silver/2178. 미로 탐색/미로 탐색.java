import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] arr;
	
	static boolean[][] visited;
	static int[][] dist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		visited = new boolean[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
		    Arrays.fill(dist[i], -1);
		}
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}

		bfs(0, 0);//시작점 입력
		
		System.out.println(dist[N-1][M-1]);
		
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{x, y});
	    visited[x][y] = true;
		dist[x][y] =1;
		
		while(!q.isEmpty()) {
			int[] cur =q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int k=0; k<4; k++) {
				int nx = cx+dx[k];
				int ny = cy+dy[k];
				
				if(nx<0||ny<0||nx >= arr.length || ny >= arr[0].length) continue;
	            if (arr[nx][ny] == 0) continue;
	            if (visited[nx][ny]) continue;
	            
	            visited[nx][ny]= true;
	            dist[nx][ny]= dist[cx][cy]+1;
	            q.add(new int[] {nx, ny});
			}
		}
	}
}	
