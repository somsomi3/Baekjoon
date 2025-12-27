import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
//	static int[] parent;
	static int[] subtree;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		//그래프만들기
		graph = new ArrayList[N+1];
		for(int i =1; i<=N; i++)graph[i] = new ArrayList<>();
		
		visited = new boolean[N+1];
		subtree = new int[N+1];
		
		for(int i =0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(R);
		//for(int i= 0; i<Q; i++) {
		//	int x  = Integer.parseInt(br.readLine());
		//	System.out.println(subtree[x]);
		//}
        // 최적화
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<Q; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(subtree[x]).append('\n');
		}
        System.out.print(sb);
	}
	static void dfs(int cur) {
		visited[cur] = true;
		//
	    subtree[cur] = 1;
		
		for(int nxt : graph[cur]) {
			if(!visited[nxt]) {
//				parent[cur]++;
				dfs(nxt);
				subtree[cur] += subtree[nxt];//자식 값을 더해준다.
			}
		}
	}
}
