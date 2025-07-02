import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 오름차순 (Min Heap)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        // 인접 리스트
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];         // 최단 거리
        int[] prev = new int[N + 1];         // 경로 복원용
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) continue;
            visited[cur.idx] = true;

            for (Edge next : adj[cur.idx]) {
                if (dist[next.to] > dist[cur.idx] + next.cost) {
                    dist[next.to] = dist[cur.idx] + next.cost;
                    prev[next.to] = cur.idx; // 경로 기록
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n"); // 최소 비용

        // 경로 복원
        Stack<Integer> path = new Stack<>();
        int node = end;
        while (node != 0) {
            path.push(node);
            node = prev[node];
        }

        sb.append(path.size()).append("\n"); // 경로에 포함된 도시 개수
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
