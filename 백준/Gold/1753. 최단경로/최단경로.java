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
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V + 1];
		for(int i = 1; i<=V; i++)graph[i] = new ArrayList<>();
		dist = new int[V + 1];

		Arrays.fill(dist, INF);
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//방향그래프
			graph[u].add(new Edge(v, w));
			
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=V; i++) {
			if(dist[i]!= INF) {
				sb.append(dist[i]).append("\n");
			}else {
				sb.append("INF").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to]<cur.cost)continue;
			
			for(Edge next: graph[cur.to]) {
				int nextCost = cur.cost + next.cost;
				if(dist[next.to]> nextCost) {
					dist[next.to] = nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
	}
	
}