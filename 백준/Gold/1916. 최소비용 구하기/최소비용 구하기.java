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
	static int N, M; 
	static List<Edge>[] graph;
	static int[] dist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i] = new ArrayList<>();
		
		dist = new int[N+1];
//		Arrays.fill(dist, -1);
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//A->B단방향
			graph[from].add(new Edge (to, cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[start] = 0;
	    pq.offer(new Edge(start, 0));
	    
	    while (!pq.isEmpty()) {
	        Edge cur = pq.poll();
	        
	        if (dist[cur.to] < cur.cost) continue;
	        
	        for (Edge next : graph[cur.to]) {
	            int nextCost = dist[cur.to] + next.cost;
	            
	            if (dist[next.to] > nextCost) {
	                dist[next.to] = nextCost;
	                pq.offer(new Edge(next.to, nextCost));
	            }
	        }
	    }
	}
}