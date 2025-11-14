import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph[to].add(new Node(from, time));
            }

            dist[start] = 0;

            int infectedCnt = 0;
            int maxTime = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {

                Node cur = pq.poll();
                int now = cur.idx;

                if (!visited[now]) {
                    visited[now] = true;

                    for (Node next : graph[now]) {

                        if (dist[next.idx] > dist[now] + next.cost) {
                            dist[next.idx] = dist[now] + next.cost;
                            pq.add(new Node(next.idx, dist[next.idx]));
                        }
                    }
                }
            }

            for (int i = 0; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    infectedCnt++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            sb.append(infectedCnt).append(" ").append(maxTime).append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
