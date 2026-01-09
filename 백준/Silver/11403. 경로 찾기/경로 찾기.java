import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] graph;
	static int[][] ans;
	static int N;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N =Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		ans = new int[N][N];
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<N; i++) {
			bfs(i);
		}
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<N; i++) {
//			st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static void bfs(int start) {
//		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		//한 행= i에 대한 visited라서 1차원이다
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next =0; next<N; next++) {
				if(graph[cur][next] ==1&&!visited[next]) {
					visited[next]= true;
					//cur이 아니라, bfs(1)로 들어온 start부터의 시작점이 1이되었다.
                    ans[start][next] = 1;
					q.add(next);
				}
			}
		}
	}
}