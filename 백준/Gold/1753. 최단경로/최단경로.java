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
	
	static int V, E, K;
	static List<Edge>[] graph;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i =1; i<= V; i++)graph[i] = new ArrayList<>();
		Arrays.fill(dist, INF);
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//양방향아닌 듯.
			graph[a].add(new Edge(b, c));
			
		}
		
		dijkstra(K);
		
		for(int i = 1; i<= V; i++) {
			if(dist[i]==INF)sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to]<cur.cost)continue;
			
			for(Edge next : graph[cur.to]) {
				int nextCost = cur.cost+ next.cost;
				if(dist[next.to]>nextCost) {
					dist[next.to] = nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
	}
}
