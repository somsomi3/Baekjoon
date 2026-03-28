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
	
	static int N, M, x, y;
	static List<Edge>[] graph;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i =1; i <=N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		for(int i = 0; i< M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			graph[a].add(new Edge(b, c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		dijkstra(x);
		
		System.out.println(dist[y]!=INF? dist[y]:"INF");
		
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge>pq = new PriorityQueue<>((a1, a2)-> a1.cost - a2.cost);
		pq.offer(new Edge(start, 0));
		dist[start]= 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to]<cur.cost)continue;
			
			for(Edge next: graph[cur.to]) {
				int nextCost = cur.cost+ next.cost;
				if(dist[next.to]>nextCost) {
					dist[next.to]= nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
	}
}
