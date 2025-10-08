import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
		int v, w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		public int compareTo(Node o) {
			return this.w -o.w;
		}
	}
    public int solution(int N, int[][] road, int K) {
        final int INF = 1_000_000_000;
        List<Node>[] graph = new ArrayList[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        // 도로 정보 (양방향)
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 다익스트라 시작 (항상 1번 마을)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v, w = cur.w;
            if (dist[v] < w) continue;

            for (Node nxt : graph[v]) {
                if (dist[nxt.v] > dist[v] + nxt.w) {
                    dist[nxt.v] = dist[v] + nxt.w;
                    pq.add(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }

        // K 이하 거리 마을 수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }
}