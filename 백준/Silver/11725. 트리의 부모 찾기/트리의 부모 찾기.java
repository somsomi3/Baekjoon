import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i = 1 ; i<= N; i++)graph[i] = new ArrayList<>();
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i<N-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		
		lca(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i =2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void lca(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next: graph[cur]) {
				if(!visited[next]) {
					visited[next]= true;
					parent[next] = cur;
					q.offer(next);
				}
			}
		}
		
	}
}
