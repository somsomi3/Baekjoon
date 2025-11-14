import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        long cost;
        Node(int t, long cost) { this.to = t; this.cost = cost; }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static long[] dist;
    static ArrayList<ArrayList<Node>> graph;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[N - 1] = 0;

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        dist = new long[N];
        Arrays.fill(dist, INF);
        visited = new boolean[N];

        dijkstra();

        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;

            if (visited[now]) continue;
            visited[now] = true;

            if (cur.cost > dist[now]) continue;

            for (Node next : graph.get(now)) {
                if (arr[next.to] == 1) continue;

                long nd = cur.cost + next.cost;

                if (!visited[next.to] && nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.add(new Node(next.to, nd));
                }
            }
        }
    }
}
