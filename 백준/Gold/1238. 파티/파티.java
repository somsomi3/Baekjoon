import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static List<Node>[] graph, reverseGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        List<Node>[] reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) reverseGraph[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            //역그래프
            reverseGraph[v].add(new Node(u, w)); 
            
            
        }
        int[] toX = dijkstra(X, reverseGraph); // i → X (역방향 그래프, 시작점 X)
        int[] fromX = dijkstra(X, graph);      // X → i (정방향 그래프, 시작점 X)

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (toX[i] == INF || fromX[i] == INF) continue;
            answer = Math.max(answer, toX[i] + fromX[i]);
        }
        System.out.println(answer);
    }
    
    
    static int[] dijkstra(int start, List<Node>[] g) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.v] < cur.w) continue;

            for (Node nxt : g[cur.v]) {
                if (dist[nxt.v] > dist[cur.v] + nxt.w) {
                	dist[nxt.v] = dist[cur.v] + nxt.w;
                    pq.offer(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
        return dist;
    }
}