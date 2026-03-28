import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int from, to, cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int[] parent;
	
	static int V, E;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for(int i = 0; i<=V; i++)parent[i] = i;
		
		Edge[] edges = new Edge[E];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost - o2.cost);
		
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
//			edges[i] = new Edge(a, b, c);
			pq.offer(new Edge(a, b, c));
		}
	
		
		int result = 0;
		
		
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(find(cur.from)!=find(cur.to)) {
				union(cur.from, cur.to);
				result += cur.cost;
			}
		}
		System.out.println(result);
		
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parent[rootB] = rootA;
		}
		
	}
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	
}