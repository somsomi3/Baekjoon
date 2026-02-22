import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static int[][] graph;
	static boolean[][] visited;
	//최소몇번만을 dist로 표현하자.
	static int[][] dist;
	
	static int N;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			graph = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			bfs(x1, y1);
			
			sb.append(dist[x2][y2]).append("\n");
		}
		System.out.println(sb);
		
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int d = 0; d < 8; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[nx][ny])continue;
				
				visited[nx][ny]= true;
				dist[nx][ny] = dist[cx][cy]+1;
				q.offer(new int[] {nx, ny});
			}

				
		}
		
	}
}