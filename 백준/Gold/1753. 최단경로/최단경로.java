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
	
	static int V, E;
	static List<Edge>[] graph;
	static int[] dist;//각점에 대한 dist라서 일차원 배열
	// visited 는 필요없음.
	static int INF= Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i = 1; i<= V; i++)graph[i] = new ArrayList<>();
		
		dist = new int[V+1];
//		Arrays.fill(dist, -1);
		Arrays.fill(dist, INF);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//방향그래프 이므로, 단방향이다.
			graph[a].add(new Edge(b, cost));
			
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; i++) {
			if(dist[i]!=INF) {
				sb.append(dist[i]).append('\n');
			}else {
				sb.append("INF").append('\n');
			}
		}
		System.out.println(sb);
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		dist[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
	        if (cur.cost > dist[cur.to]) continue;

			for(Edge next: graph[cur.to]) {	
				int nextCost = cur.cost+ next.cost;
				
                if(dist[next.to]> nextCost) {
					dist[next.to]= nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
	}
}
