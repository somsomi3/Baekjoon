import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int a, b;
        double w;
        Edge(int a, int b, double w) {
            this.a = a; this.b = b; this.w = w;
        }
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    static int N, M;
    static int[] parent;
    static int[] x, y;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = new int[N + 1];
        y = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double d = Math.hypot(x[i] - x[j], y[i] - y[j]);
                edges.add(new Edge(i, j, d));
            }
        }

        Collections.sort(edges);

        double ans = 0;
        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                ans += e.w;
            }
        }

        System.out.printf("%.2f\n", ans);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
