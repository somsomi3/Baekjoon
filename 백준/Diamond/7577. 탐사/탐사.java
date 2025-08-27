import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to;
        int weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        final int INF = (int) 1e9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges.add(new Edge(x - 1, y, r));
            edges.add(new Edge(y, x - 1, -r));
        }

        for (int i = 0; i < K; i++) {
            edges.add(new Edge(i, i + 1, 1));
            edges.add(new Edge(i + 1, i, 0));
        }

        int[] dist = new int[K + 2];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        // 벨만포드 K회
        for (int i = 0; i < K; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
                System.out.println("NONE");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K; i++) {
            sb.append(dist[i - 1] < dist[i] ? '#' : '-');
        }

        System.out.println(sb);
    }
}
