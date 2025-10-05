import java.io.*;
import java.util.*;

public class Main {
    static final InputStream in = System.in;
    static final byte[] buffer = new byte[1 << 16];
    static int ptr = 0, len = 0;

    static int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    static int nextInt() throws IOException {
        int c, n = 0, neg = 0;
        do { c = read(); } while (c <= 32 && c != -1);
        if (c == '-') { neg = 1; c = read(); }
        while (c > 32 && c != -1) {
            n = n * 10 + (c - '0');
            c = read();
        }
        return neg != 0 ? -n : n;
    }

    static class Edge implements Comparable<Edge> {
        int a, b, w;
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] parent;

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int M = nextInt();

        List<Edge> edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int a = nextInt();
            int b = nextInt();
            int w = nextInt();
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
                if (++count == N - 1) break;
            }
        }

        System.out.println(total - maxEdge);
    }
}
