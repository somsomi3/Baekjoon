import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int to, cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static final int INF = 1_000_000_000;
	static List<Node>[] graph;
	static int[] dist;
	static int N;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(1);
		
		//출력: 최단거리// N값이 도착점 출력에서 뽑고, 
		//다익에서 는 N이면 break로 시간단축
		for (int i = 1; i <= N; i++) {
            if (i==N) {
            	System.out.println(dist[i]); 
            }
		}
	}
	static void dijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		dist[1]=0;
		
		while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;
            if (cur.to == N) break;  
            
            for (Node next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}