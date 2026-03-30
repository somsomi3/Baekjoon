import java.io.*;
import java.util.*;

//값을 누적해야 하는 문제 이므로 dfs를 쓴다

public class Main {
	static int N, R, Q;
	static List<Integer>[] graph;
	static int[] child;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i] = new ArrayList<>();
		child = new int[N+1];
		
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
			
		}
		
		dfs(R, 0);
		
		for(int i = 0; i< Q; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(child[x]).append("\n");
		}
		System.out.println(sb);
		
	}
	static void dfs(int cur, int parent) {
		child[cur] = 1;
		
		for(int next : graph[cur]) {
			if(next!= parent) {
				dfs(next, cur);
				child[cur] +=child[next];
			}
		}	
	}
}