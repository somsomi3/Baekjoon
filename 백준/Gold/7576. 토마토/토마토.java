import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int N, M;
//	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];

		for(int i =0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
		            q.offer(new int[]{i, j}); 
				}
			}
		}
		bfs();
        
		int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, graph[i][j]);
            }
        }
        //토마토는 원래 초기에 1이어서, -1 을 해서 진짜 최소날짜를 구해주는 것.
        System.out.println(max - 1);
    }
    static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (graph[nx][ny] != 0) continue;

                graph[nx][ny] = graph[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}