import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (e <= D) {
                graph[s].add(new Node(e, c));
            }
        }

        dist = new int[D + 1];
        Arrays.fill(dist, INF);

        dijkstra(0);

        System.out.println(dist[D]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph[cur.to]) {
                int nextCost = dist[cur.to] + next.cost;
                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }
    }
}
