import java.io.*;
import java.util.*;

public class Main {
	static int N, R, Q;
	static List<Integer>[] graph;
	static int[] tree;
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i] = new ArrayList<>();
		
		parent = new int[N + 1];
		tree = new int[N+1];
		for(int i = 1; i<= N; i++) {
			parent[i] = i;
			tree[i] = 1;//가중치가 다 1
		}
		visited = new boolean[N+1];
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			//트리는 양방향?
			graph[U].add(V);
			graph[V].add(U);
			
		}
		
		dfs(R);
		
		for(int i = 0; i<Q; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(tree[x]).append("\n");
		}
		System.out.println(sb);
		
	}
	//일단은 tree안쓰고 큐를 써서 해도 되지않을가. parent가 visited역할을 하니까.
	//아냐 누적할게 없네.
	static void dfs(int start) {
		Queue<Integer>q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next: graph[cur]) {
				if(!visited[next]) {
					dfs(next);
					tree[cur]+= tree[next];
//					q.offer(next); //=>이건 굳이 있어야할 이유가...
				}
			}
		}
		
	}
	
}
