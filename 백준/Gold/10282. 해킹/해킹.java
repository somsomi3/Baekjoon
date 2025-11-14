
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to;
        int cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            dist = new int[n + 1];
            visited = new boolean[n + 1];
            Arrays.fill(dist, INF);

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph[y].add(new Node(x, z));
            }

            dijkstra(c);

            int count = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    count++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node next : graph[now]) {
                int newCost = dist[now] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}
