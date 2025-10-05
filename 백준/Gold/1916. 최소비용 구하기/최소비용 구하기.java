import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int v, w;
		Node(int v, int w){
			this.v =v;
			this.w = w;
		}
        public int compareTo(Node o) {
            return this.w - o.w;
        }
	}
	
	static int N, M;
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        for(int i =1; i<=N;i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i= 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        dijkstra(start, end);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.v == end) return; // end까지 최단 거리 확정 → 종료
            if (cur.w > dist[cur.v]) continue;

            for (Node nxt : graph[cur.v]) {
                if (dist[nxt.v] > dist[cur.v] + nxt.w) {
                    dist[nxt.v] = dist[cur.v] + nxt.w;
                    pq.offer(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
    }
}