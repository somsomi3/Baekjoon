import java.io.*;
import java.util.*;

public class Main {
    static int read() throws Exception {
        int c, n = 0, s = 1;
        do { c = System.in.read(); } while (c <= 32);
        if (c == '-') { s = -1; c = System.in.read(); }
        while (c > 32) {
            n = n * 10 + (c - '0');
            c = System.in.read();
        }
        return n * s;
    }

    static class IntQueue {
        int[] q;
        int head = 0, tail = 0, cap;
        IntQueue(int capacity) { q = new int[capacity]; cap = capacity; }
        boolean isEmpty() { return head == tail; }
        void add(int x) {
            q[tail++] = x;
            if (tail == cap) tail = 0;
        }
        int poll() {
            int v = q[head++];
            if (head == cap) head = 0;
            return v;
        }
    }

    static int N, M;
    static int[] head, to, w, next;    
    static int[] headR, toR, wR, nextR; 
    static int edgePtr = 0, edgePtrR = 0;

    static void addEdge(int u, int v, int cost) {
        to[edgePtr] = v; w[edgePtr] = cost; next[edgePtr] = head[u]; head[u] = edgePtr++;
        toR[edgePtrR] = u; wR[edgePtrR] = cost; nextR[edgePtrR] = headR[v]; headR[v] = edgePtrR++;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        head  = new int[N + 1];
        headR = new int[N + 1];
        Arrays.fill(head,  -1);
        Arrays.fill(headR, -1);

        // 간선 배열 크기는 M (정방향)과 M (역방향)
        to = new int[M]; w = new int[M]; next = new int[M];
        toR = new int[M]; wR = new int[M]; nextR = new int[M];

        int[] indeg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            int t = read();
            addEdge(a, b, t);
            indeg[b]++;
        }

        int start = read();
        int end = read();

        // 1) 위상정렬 + 최장거리 DP
        int[] dist = new int[N + 1];

        IntQueue q = new IntQueue(N + 5);
        for (int i = 1; i <= N; i++) if (indeg[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int ei = head[u]; ei != -1; ei = next[ei]) {
                int v = to[ei];
                int cost = w[ei];
                // 최장 거리 갱신
                if (dist[v] < dist[u] + cost) dist[v] = dist[u] + cost;

                if (--indeg[v] == 0) q.add(v);
            }
        }

        // 2) 역방향 그래프에서 임계 간선 수 세기
        boolean[] vis = new boolean[N + 1];
        IntQueue rq = new IntQueue(N + 5);
        rq.add(end);
        vis[end] = true;
        int criticalEdges = 0;

        while (!rq.isEmpty()) {
            int cur = rq.poll();
            for (int ei = headR[cur]; ei != -1; ei = nextR[ei]) {
                int prev = toR[ei];
                int cost = wR[ei];
                // 임계 간선 조건: dist[cur] == dist[prev] + cost
                if (dist[cur] == dist[prev] + cost) {
                    criticalEdges++;
                    if (!vis[prev]) {
                        vis[prev] = true;
                        rq.add(prev);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n').append(criticalEdges).append('\n');
        System.out.print(sb.toString());
    }
}
