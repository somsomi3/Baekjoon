import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static List<Node>[] graph;
    static int[] dist;
    static int n, m, t;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++)
                graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // 트릭: 모든 간선 2배
                d = d * 2;

                // g-h 간선만 홀수로 만들기
                if((a == g && b == h) || (a == h && b == g)) {
                    d -= 1;  // 홀수로!
                }

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }

            int[] arr = new int[t];
            for(int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            // 다익스트라 1번만 필요
            dijkstra(s);

            Arrays.sort(arr);

            for(int x : arr) {
                // dist[x] 가 홀수이면 g-h 간선을 지난 것
                if (dist[x] != INF && dist[x] % 2 == 1) {
                    sb.append(x).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.to;
            int curDist = cur.cost;

            if(curDist > dist[curNode]) continue;

            for(Node next : graph[curNode]) {
                int nd = curDist + next.cost;

                if(nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.offer(new Node(next.to, nd));
                }
            }
        }
    }
}
