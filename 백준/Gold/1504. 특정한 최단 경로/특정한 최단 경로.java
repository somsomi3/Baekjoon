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
	
	//점을 주로 한다. 고로 List<>[] graph
	static List<Edge>[] graph;
	static int N, E;
    static int[] dist;
    static final int INF = 200000000;
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
	    
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//무방향 = 양방향
			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
			
		}
		
		st= new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
//		//고정값 다익스트라
//		dijkstra(v1, v2);
//		//시작에서 끝 
//		dijkstra(1, v1);
//		dijkstra(v2, N);
//		dijkstra(1, v2);
//		dijkstra(v1, N);
		
        
//		1 → v1 → v2 → N
//		1 → v2 → v1 → N
		//1번 정점에서 모든 정점까지의 최단거리
		dijkstra(1);
        int d1v1 = dist[v1];
        int d1v2 = dist[v2];

        dijkstra(v1);
        int dv1v2 = dist[v2];
        int dv1N = dist[N];

        dijkstra(v2);
        int dv2v1 = dist[v1];
        int dv2N = dist[N];
        
        
        long case1 = (long)d1v1 + dv1v2 + dv2N;
        long case2 = (long)d1v2 + dv2v1 + dv1N;

        if (d1v1 >= INF || dv1v2 >= INF || dv2N >= INF) case1 = INF;
        if (d1v2 >= INF || dv2v1 >= INF || dv1N >= INF) case2 = INF;

        long answer = Math.min(case1, case2);

        System.out.println(answer >= INF ? -1 : answer);
    }
	
    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
        	Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                if (dist[next.to] > cur.cost + next.cost) {
                    dist[next.to] = cur.cost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }
}