import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Edge>[] graph;
    static boolean[] visited;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight; // 가중치 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight)); // 무방향
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int total = 0;

        pq.offer(new Edge(1, 0)); // 시작 정점(1번)에서 시작

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue; // 이미 방문했으면 스킵
            visited[cur.to] = true;
            total += cur.weight;

            // 현재 정점에서 연결된 간선을 모두 pq에 넣음
            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(total);
    }
}
