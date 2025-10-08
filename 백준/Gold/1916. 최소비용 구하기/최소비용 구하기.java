import java.io.*;
import java.util.*;

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

    static final int INF = 1_000_000_000;
    static List<Node>[] graph;
    static int[] dist;
    static int N, M;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            int c = read();
            graph[a].add(new Node(b, c)); // 단방향
        }

        int start = read();
        int end = read();

        dijkstra(start, end);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;

            if (dist[v] < w) continue;
            if (v == end) break;

            for (Node nxt : graph[v]) {
                if (dist[nxt.v] > dist[v] + nxt.w) {
                    dist[nxt.v] = dist[v] + nxt.w;
                    pq.add(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
    }

    static int read() throws Exception {
        int c, n = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32) ;
        if (c == '-') { neg = true; c = System.in.read(); }
        do n = n * 10 + c - '0';
        while ((c = System.in.read()) > 47 && c < 58);
        return neg ? -n : n;
    }
}
