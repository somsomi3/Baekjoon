import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static final int INF = 200_000_000;
    static List<List<Node>> graph;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 3번
        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long path1 = (long) dist1[v1] + distV1[v2] + distV2[N];
        long path2 = (long) dist1[v2] + distV2[v1] + distV1[N];

        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}
