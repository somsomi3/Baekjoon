import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int M, N, K;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0 ; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[y][x] = 1;
				
			}
			
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				for(int j =0; j<M; j++) {
					if(!visited[i][j]&&graph[i][j]==1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y]= true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(visited[nx][ny])continue;
				if(graph[nx][ny]==0)continue;
				
				visited[nx][ny]= true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
