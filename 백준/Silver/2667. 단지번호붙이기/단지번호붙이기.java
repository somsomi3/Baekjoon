import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	
	static int[] dx = {-1, 1, 0, 0};//상하좌우
	static int[] dy = {0, 0, -1, 1};
//    static List<Integer> result = new ArrayList<>();
	
	static int dfs(int x, int y) {
		visited[x][y] = true;
		int count =1;
		
		for( int k =0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx<N && ny<N && nx>=0 && ny>=0){
				if(!visited[nx][ny]&& arr[nx][ny]==1) {
					count += dfs(nx, ny);
				}
			}
		}
		return count;
	}
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
		//전체를 돌면서 시작점을 찾아야 dfs를 할수 있음
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					int cnt = dfs(i, j);
		            pq.offer(cnt); // 리스트 대신 힙에 삽입
				}
			}
		}

		System.out.println(pq.size());
		while (!pq.isEmpty()) {
		    System.out.println(pq.poll()); //자동으로오름차순
		}
	}
}
