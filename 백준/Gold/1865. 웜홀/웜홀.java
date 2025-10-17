import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        Edge(int f, int t, int c) { from = f; to = t; cost = c; }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
                edges.add(new Edge(b, a, c));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, -x));
            }

            int[] dist = new int[N + 1];
            Arrays.fill(dist, 0);

            boolean updated = false;
            for (int i = 1; i <= N; i++) {
                updated = false;
                for (Edge e : edges) {
                    if (dist[e.to] > dist[e.from] + e.cost) {
                        dist[e.to] = dist[e.from] + e.cost;
                        updated = true;
                    }
                }
                if (!updated) break;
            }

            System.out.println(updated ? "YES" : "NO");
        }
    }
}
