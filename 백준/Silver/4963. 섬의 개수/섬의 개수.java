import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		    String s = br.readLine();
		    if(s.equals("0 0")) break;
		    
			StringTokenizer st =new StringTokenizer(s);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			//세로가로
			arr = new int[h][w]; 
			visited = new boolean[h][w];
			for(int i = 0; i< h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i< h; i++) {
				for(int j = 0; j< w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
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
		q.offer(new int[]{x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(nx < 0 || ny < 0|| nx>=h ||ny>=w)continue;
				if(visited[nx][ny])continue;
                if(arr[nx][ny] == 0) continue;

				
				visited[nx][ny]= true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
