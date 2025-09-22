import java.io.*;
import java.util.*;

public class Main {
	static int N, r1, r2, c1, c2;
	static int[][] map;
	static int[] arr;
	static final int[] dx = {-2, -2, 0, 0, 2, 2};
	static final int[] dy = {-1, 1, -2, 2, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
//		arr = new int[4];
		
//		for(int i= 0; i<4; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
		
		map =new int[N][N];
//		full.fill..
		for( int[] row: map) Arrays.fill(row, -1);
		
//		bfs(arr[1], arr[2]);

		System.out.println(bfs());
	}
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
//		q.add(new int{sx, sy});
		q.offer(new int[] {r1, c1});
		map[r1][c1]=0;
		 
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];
			
			for(int k= 0; k<6; k++) {
				int nx = x+ dx[k];
				int ny = y+ dy[k];
				
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] != -1) continue;
                
                map[nx][ny]= map[x][y]+1;
                if (nx == r2 && ny == c2) return map[nx][ny];
                q.offer(new int[]{nx, ny});
			}
		}
        return -1;
	}

}
