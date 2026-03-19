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
	static int N, D; 
	static List<Edge>[] graph;
	static int[] dist;
    static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[D+1];
		for(int i = 0; i<=D; i++)graph[i] = new ArrayList<>();
		
		dist = new int[D+1];
        Arrays.fill(dist, INF);
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
            if (to <= D) {
			//A->B단방향
            	graph[from].add(new Edge (to, cost));
            }
		}
	
		dijkstra(0);
		
		System.out.println(dist[D]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
	    dist[start] = 0;
	    pq.offer(new Edge(start, 0));
	    
	    while (!pq.isEmpty()) {
	        Edge cur = pq.poll();
	        
	        if (dist[cur.to] < cur.cost) continue;
	        
	        if (cur.to + 1 <= D) {
                if (dist[cur.to + 1] > dist[cur.to] + 1) {
                    dist[cur.to + 1] = dist[cur.to] + 1;
                    pq.offer(new Edge(cur.to + 1, dist[cur.to + 1]));
                }
            }
	           
	        for (Edge next : graph[cur.to]) {
	            int nextCost = dist[cur.to] + next.cost;
	            
	            if (dist[next.to] > nextCost) {
	                dist[next.to] = nextCost;
	                pq.offer(new Edge(next.to, nextCost));
	            }
	        }
	        
	        //if->for문 순서로 실행(조건만 맞으면)
	    }
	}
}