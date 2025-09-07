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
        int c, sign = 1, val = 0;
        c = read();
        while (c <= 32) {
            if (c == -1) return Integer.MIN_VALUE;
            c = read();
        }
        if (c == '-') {
            sign = -1;
            c = read();
        }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c & 15); // val*10 + digit
            c = read();
        }
        return val * sign;
    }

    static double nextDouble() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (c <= 32) c = read();
        while (c > 32) {
            sb.append((char)c);
            c = read();
        }
        return Double.parseDouble(sb.toString());
    }

    static class Edge implements Comparable<Edge> {
        int u, v;
        double w;
        Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();

        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            stars[i][0] = nextDouble();
            stars[i][1] = nextDouble();
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double dist = Math.sqrt(dx * dx + dy * dy);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        double result = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                result += e.w;
                cnt++;
                if (cnt == n - 1) break;
            }
        }

        System.out.printf("%.2f\n", result);
    }
}
