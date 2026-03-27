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
	static List<Edge>[] reverseGraph;
	static int[] dist;
	static int[] reverseDist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
//		dist = new int[N+1];
		reverseDist = new int[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//단방향이다. 그래프 두개 만들어서 넣어라.
			graph[from].add(new Edge(to, cost));
			reverseGraph[to].add(new Edge(from, cost));
			
		}
		//다익스트라 값을 배열안에 넣어주기
		int[] go = dijkstra(X, graph);        // X → i
		int[] back = dijkstra(X, reverseGraph); // i → X
		
		int max = 0;

		for (int i = 1; i <= N; i++) {
		    max = Math.max(max, go[i] + back[i]);
		}

		System.out.println(max);
	
	}
	static int[] dijkstra(int start, List<Edge>[] g) {//타입주의
	    int[] dist = new int[N+1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost-o2.cost);
		dist[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
//			if(cur.to < cur.cost)continue;
			if(cur.cost > dist[cur.to]) continue;
			
			for(Edge next : g[cur.to]) {
				int nextCost = cur.cost + next.cost;
				if(dist[next.to]> nextCost) {
					dist[next.to]= nextCost;
					pq.offer(new Edge(next.to, nextCost));
				}
			}
		}
		return dist;
		
		
	}
}