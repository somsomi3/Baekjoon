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
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i] = new ArrayList<>();

		
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
	
		}	
//		무방향= 양방향
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(1);
		int a = dist[x];
		int b = dist[y];
		
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(x);
		int c = dist[y];
		int d = dist[N];
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(y);
		int e = dist[N];
		int f = dist[x];
		
		boolean flag = false;
		int min= INF;
		if(a==INF||c==INF||e==INF)flag= false;
		else if(b==INF||f==INF||d==INF)flag= false;
		else {
			min = Math.min(a+c+e, b+f+d);
			flag = true;
		}
		if(flag)System.out.println(min);
		else System.out.println(-1);
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
		pq.offer(new Edge(start, 0));
		dist[start] =0;
		
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