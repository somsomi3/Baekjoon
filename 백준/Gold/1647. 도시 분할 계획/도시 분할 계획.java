import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int a, b, w;
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        public int compareTo(Edge o) {
            return this.w - o.w;  // 비용 오름차순
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int total = 0;
        int maxEdge = 0;
        int count = 0;

        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                total += e.w;
                maxEdge = e.w;
                count++;
                if (count == N - 1) break;
            }
        }

        System.out.println(total - maxEdge);
    }
}
