import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] arr;
	static int[][] dist;
	
	//같은 곳 또가면 안된다는 말은 없지만, 스타트링크 문제와 달리, 이것은 갔던 곳을 안갈수 있고 그러한 경우가 더빨라보인다.
	//그래서 visited를 만들자
	static boolean[][] visited;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];//세로 가로 , 행 열
		visited = new boolean[N][M];
		dist = new int[N][M];
		for(int i = 0; i < N; i++){
		    Arrays.fill(dist[i], -1);
		}
		
		//입력을 받자
		for(int i = 0; i< N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j)-'0'; 
			}
		}
		
		bfs(0, 0);//x, y시작점 좌표
		
		//항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
		System.out.println(dist[N-1][M-1]);
	}
	static void bfs(int x, int y) {
		Queue<int[]>q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		dist[x][y]=1; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx= cur[0];
			int cy = cur[1];
			
			for(int i = 0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if( nx < 0 || ny < 0 || nx >= N || ny >= M )continue;
				if(visited[nx][ny])continue;
				if(arr[nx][ny] == 0) continue;
				
				visited[nx][ny]= true;
				dist[nx][ny] = dist[cx][cy]+1;
				q.offer(new int[]{nx, ny});
				
			}
		}
		
	}
}