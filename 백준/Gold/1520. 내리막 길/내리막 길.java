import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//세로 수= 행, 가로수 = 열
		M = Integer.parseInt(st.nextToken());//세로수 = 행
		N = Integer.parseInt(st.nextToken()); // 가로수 = 열
		
		
		arr = new int[M][N];
		dp = new int[M][N];
	    for (int[] d : dp) Arrays.fill(d, -1); // 메모이제이션 초기화
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		//시작점은 0,0... 1,1로 할때에는 어떻게 해야하는지 확실히 익혀두기.
		int start = arr[0][0];
		
        System.out.println(dfs(0, 0));
		
		
	}
	static int dfs(int x, int y) {
        // 도착점 도달 시 경로 1개
        if (x == M - 1 && y == N - 1) return 1;

        // 이미 계산된 경우
        if (dp[x][y] != -1) return dp[x][y];
		//dp[x][y]= (x, y) 지점에서 도착점까지 가는 경로의 수
		
		//첫점은 항상 초기화 
		dp[x][y] = 0;
		
		for(int i= 0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>(M-1) || ny>(N-1)) continue;
			
			//이동할 곳이 작으면, 
			if (arr[nx][ny] < arr[x][y]) {
				dp[x][y] = dp[x][y] + dfs(nx, ny);
			}
//			visited[nx][ny]= true; //어렵게 들어가면 오히려틀림.
		}
		return dp[x][y];
	}
}
