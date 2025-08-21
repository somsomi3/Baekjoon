import java.io.*;
import java.util.*;

public class Main {
    static int N, M, LOG;
    static List<Node>[] graph;
    static int[][] parent;
    static int[] depth;
    static long[] dist;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        LOG = (int) Math.ceil(Math.log(N) / Math.log(2));

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        parent = new int[LOG + 1][N + 1];
        depth = new int[N + 1];
        dist = new long[N + 1];

        bfs(1);

        for (int k = 1; k <= LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int lca = LCA(u, v);
            long answer = dist[u] + dist[v] - 2 * dist[lca];
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(root);
        visited[root] = true;
        depth[root] = 0;
        dist[root] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : graph[cur]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    depth[next.to] = depth[cur] + 1;
                    dist[next.to] = dist[cur] + next.weight;
                    parent[0][next.to] = cur;
                    q.add(next.to);
                }
            }
        }
    }

    static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }

        for (int k = LOG; k >= 0; k--) {
            if (depth[u] - (1 << k) >= depth[v]) {
                u = parent[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG; k >= 0; k--) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }
}
