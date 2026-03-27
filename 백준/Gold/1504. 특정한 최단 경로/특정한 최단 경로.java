import java.util.*;
import java.io.*;

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
	static int[] dist;//각 점에 대한 dist라서 일차원 배열
	static int INF= Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		for(int i  = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
			
		}
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		
		dijkstra(1);
		int a = dist[X];
		int b = dist[Y];
		
		//초기화..?
		Arrays.fill(dist, INF);
		dijkstra(X);
		int c = dist[Y];
		int d = dist[N];
		
		Arrays.fill(dist, INF);
		dijkstra(Y);
		int e = dist[N];
		int f = dist[X];
		
		int case1 = (a == INF || c == INF || e == INF) ? INF : a + c + e;
		int case2 = (b == INF || f == INF || d == INF) ? INF : b + f + d;

		int ans = Math.min(case1, case2);
		
        System.out.println(ans == INF ? -1 : ans);
		
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to]<cur.cost)continue;
			
			for(Edge next: graph[cur.to]) {
				int nextCost = cur.cost+ next.cost;
				
				if(dist[next.to]>nextCost) {//이걸 위해서 dist를 -1로 채우면 안됨
					dist[next.to] = nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
			
		}
	}
}
