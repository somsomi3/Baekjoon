import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int to, cost;
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int N, M, X;
	static List<Edge>[] graph, reverseGraph;
	static int[] dist;
//	static int INF = 1_000_000_000;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		for(int i = 1; i<= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Edge(e, c));
			reverseGraph[e].add(new Edge(s, c));
		}
		
		int[] go = dijkstra(X, graph);
		int[] back = dijkstra(X, reverseGraph);
		
		int max = 0;
		for(int i = 1; i<=N; i++) {
			max = Math.max(max, go[i]+back[i]);
		}
		System.out.println(max);
	}
	static int[] dijkstra(int start, List<Edge>[] g) {
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to]<cur.cost)continue;
			
			for(Edge next: g[cur.to]) {
				int nextCost = cur.cost +next.cost;
				if(dist[next.to]>nextCost) {
					dist[next.to]= nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}	
		return dist;
	}
}