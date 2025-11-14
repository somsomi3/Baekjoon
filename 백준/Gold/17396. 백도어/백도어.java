import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        long cost;
        Node(int t, long c) { to = t; cost = c; }
        public int compareTo(Node o) { return Long.compare(this.cost, o.cost); }
    }

    static List<Node>[] graph;
    static long[] dist;
    static int[] watch;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        watch = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) watch[i] = Integer.parseInt(st.nextToken());
        watch[N - 1] = 0;

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dist = new long[N];
        Arrays.fill(dist, INF);

        dijkstra(0);

        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.to;
            long d = cur.cost;

            if (d > dist[v]) continue;

            for (Node next : graph[v]) {
                if (watch[next.to] == 1) continue;

                long nd = d + next.cost;
                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.offer(new Node(next.to, nd));
                }
            }
        }
    }
}
