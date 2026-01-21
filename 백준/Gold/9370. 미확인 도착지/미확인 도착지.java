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

    static final int INF = 1_000_000_000;
    static List<Node>[] graph;
    static int n, m, t, s, g, h;
    static int ghCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            ghCost = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));

                if ((a == g && b == h) || (a == h && b == g)) {
                    ghCost = d;
                }
            }

            int[] candidates = new int[t];
            for (int i = 0; i < t; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(candidates);

            int[] distS = dijkstra(s);
            //int[] distS에는 dist의 모든 값이 저장된다.
            //dijkstra함수가 나중에 return dist를 한다.
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            for (int x : candidates) {
            	// = s~g+ ghCost+ h~x까지
                int path1 = distS[g] + ghCost + distH[x];
                
                // = s~h+ ghCost+ g~x까지
                int path2 = distS[h] + ghCost + distG[x];

                if (distS[x] == path1 || distS[x] == path2) {
                    out.append(x).append(" ");
                }
            }
            out.append("\n");
        }

        System.out.print(out);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph[cur.to]) {
                int newCost = dist[cur.to] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }
}