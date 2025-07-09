import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        long cost;
        int pave; // 현재까지 포장한 횟수

        public Node(int to, long cost, int pave) {
            this.to = to;
            this.cost = cost;
            this.pave = pave;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M, K;
    static List<Node>[] adj;
    static long[][] dist; // dist[node][포장횟수]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        K = Integer.parseInt(st.nextToken()); // 포장 가능 횟수

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w, 0));
            adj[v].add(new Node(u, w, 0));
        }

        dist = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        dijkstra();

        long answer = Long.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            answer = Math.min(answer, dist[N][i]);
        }
        System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to][cur.pave] < cur.cost) continue;

            for (Node next : adj[cur.to]) {
                // 1) 포장 안 하고 가는 경우
                if (dist[next.to][cur.pave] > dist[cur.to][cur.pave] + next.cost) {
                    dist[next.to][cur.pave] = dist[cur.to][cur.pave] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to][cur.pave], cur.pave));
                }

                // 2) 포장 하고 가는 경우 (포장 횟수 초과 X)
                if (cur.pave < K && dist[next.to][cur.pave + 1] > dist[cur.to][cur.pave]) {
                    dist[next.to][cur.pave + 1] = dist[cur.to][cur.pave];
                    pq.offer(new Node(next.to, dist[next.to][cur.pave + 1], cur.pave + 1));
                }
            }
        }
    }
}
