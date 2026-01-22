import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
//	static int[][] dist;
	static boolean[][] visited;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int w,h;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    w = Integer.parseInt(st.nextToken());
		    h = Integer.parseInt(st.nextToken());

		    if (w == 0 && h == 0) break;
		    
		    //선언 세로가로
		    map = new int[h][w];
		    visited = new boolean[h][w];

		    for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			int count =0;
			//트리가 아니다. 그냥 map이다. 0부터 시작하자.
			for(int i=0; i<h; i++) {// 무조건 세로, 가로
			    for(int j=0; j<w; j++) {
					if(map[i][j] == 1 &&!visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
			
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
			
			for(int d =0; d<8; d++) {
				int nx = cx+dx[d];// x, y 새로 가로
				int ny = cy+dy[d];
				
				if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue; //무조건 세로, 가로
				if(visited[nx][ny])continue;
				if (map[nx][ny] == 0) continue;
				
				visited[nx][ny]= true;
				q.offer(new int[] {nx, ny});
			}
		}
		
	}
}
