
import java.io.*;
import java.util.*;

public class Main {
	static int T, M, N, K;
//	static int x, y; //x,y가 1인 지점의 좌표이다.-> i랑 j로 대체함.
	//위의 x,y를 입력 받아서 만들,, map을 boolean타입으로 만들어 보자
	static boolean[][] map;
	static boolean[][] visited;
	//count를 여기서 부터 선언 해야 하나?
//	static int count;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		T= Integer.parseInt(br.readLine());
				
        while (T-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(st.nextToken());
    		N= Integer.parseInt(st.nextToken());
    		K= Integer.parseInt(st.nextToken());
    	    map = new boolean[N][M]; 
    	    visited = new boolean[N][M]; 
        	
			for (int i = 0; i < K; i++) {
			    st = new StringTokenizer(br.readLine());
			    int x = Integer.parseInt(st.nextToken());
			    int y = Integer.parseInt(st.nextToken());
			    map[y][x] = true; // 배추 있음
			}
			
	        int count = 0;
	        for (int y = 0; y < N; y++) {
	            for (int x = 0; x < M; x++) {
	                if (map[y][x] && !visited[y][x]) {
	                    dfs(y, x);
	                    count++;
	                }
	            }
	        }
	        sb.append(count).append('\n');
	        }   
		System.out.print(sb);  
	}
  


	static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if (visited[ny][nx] || !map[ny][nx]) continue;

			dfs(ny, nx);
		}
	}
}
