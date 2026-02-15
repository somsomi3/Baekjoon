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
	static List<Edge>[] graph;
	static List<Edge>[] rgraph;
	
	static boolean[] visited;
	static int[] dist; 
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i =1; i<=N; i++)graph[i] = new ArrayList<>();
		
		rgraph = new ArrayList[N+1];
		for(int i =1; i<=N; i++)rgraph[i] = new ArrayList<>();
		
//		dist = new int[N+1];
//		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//진짜
			graph[from].add(new Edge(to, cost));
			
			//역 그래프
			rgraph[to].add(new Edge(from, cost));
		}
		
		//진짜방향
		int[] go = dijkstra(graph, X);
		int[] back = dijkstra(rgraph, X);
		
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }

        System.out.println(answer);
    }
	
	static int[] dijkstra(List<Edge>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
		PriorityQueue<Edge> pq = new PriorityQueue<>(
				(a, b)-> a.cost-b.cost
		);
		dist[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
        	Edge cur = pq.poll();
        	if(cur.cost>dist[cur.to])continue;
        	//dist[cur.to]: 현재까지 모은 최단의 cost들.
        	
        	for(Edge next: g[cur.to]) {
//        		if(dist[next.to] > cur.cost + next.cost) {
//        			dist[next.to] = cur.cost + next.cost;
        		if(dist[next.to] > dist[cur.to] + next.cost) {
        			dist[next.to] = dist[cur.to]+ next.cost;
        			pq.offer(new Edge(next.to, dist[next.to]));
        		}
        	}
        	
        }
        
        
        return dist;
	}
}