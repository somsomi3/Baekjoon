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
	static int N, E;
	static List<Edge>[] graph;
	static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph= new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//dijkstra(시작점)
		//1 → v1 → v2 → N
		//1 → v2 → v1 → N
		dijkstra(1);
		//dist[v1], dist[v2]
		int oneToV1 = dist[v1];
        int oneToV2 = dist[v2];

		dijkstra(v1);
		//dist[v2], dist[N]
		int v1ToV2 = dist[v2];
        int v1ToN = dist[N];
        
		dijkstra(v2);
		//dist[v1], dist[N]
        int v2ToV1 = dist[v1];
        int v2ToN = dist[N];
        
        long case1 = (long) oneToV1 + v1ToV2 + v2ToN;
        long case2 = (long) oneToV2 + v2ToV1 + v1ToN;

        if (oneToV1 == INF || v1ToV2 == INF || v2ToN == INF) case1 = INF;
        if (oneToV2 == INF || v2ToV1 == INF || v1ToN == INF) case2 = INF;

        long ans = Math.min(case1, case2);

        System.out.println(ans >= INF ? -1 : ans);
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