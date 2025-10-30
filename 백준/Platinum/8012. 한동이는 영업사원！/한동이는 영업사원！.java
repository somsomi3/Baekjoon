import java.io.*;
import java.util.*;

public class Main {
    static int N, M, LOG = 17;
    static List<Integer>[] graph;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[LOG + 1][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1, 0);

        for (int i = 1; i <= LOG; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        int cur = 1;
        long ans = 0;

        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(br.readLine());
            ans += getDist(cur, next);
            cur = next;
        }

        System.out.println(ans);
    }

    static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;

        for (int next : graph[node]) {
            if (!visited[next]) {
                parent[0][next] = node;
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = LOG; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[i][a];
            }
        }

        if (a == b) return a;

        for (int i = LOG; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }

    static int getDist(int a, int b) {
        int c = lca(a, b);
        return depth[a] + depth[b] - 2 * depth[c];
    }
}
