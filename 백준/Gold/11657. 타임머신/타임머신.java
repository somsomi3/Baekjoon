import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE / 2;
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
        while (c <= 32) c = read();
        if (c == '-') {
            sign = -1;
            c = read();
        }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c & 15);
            c = read();
        }
        return val * sign;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int M = nextInt();

        List<Edge> edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean cycle = false;

        for (int i = 1; i <= N; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                    if (i == N) cycle = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cycle) {
            sb.append(-1).append('\n');
        } else {
            for (int i = 2; i <= N; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
