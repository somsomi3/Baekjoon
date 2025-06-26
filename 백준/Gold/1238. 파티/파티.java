import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int to, cost;
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, M, X;
    static List<Edge>[] graph;
    static List<Edge>[] reverseGraph;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 마을 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 파티 마을

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            reverseGraph[to].add(new Edge(from, cost)); // 역방향 저장
        }

        int[] go = dijkstra(graph, X);       // X → i
        int[] back = dijkstra(reverseGraph, X); // i → X (역방향 그래프에서 X 시작)

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, go[i] + back[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(List<Edge>[] g, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;

            if (cost > dist[now]) continue;

            for (Edge next : g[now]) {
                if (dist[next.to] > dist[now] + next.cost) {
                    dist[next.to] = dist[now] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }
}
