import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static int[] indegree;
    static List<Integer> result = new ArrayList<>();

    static int read() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int k = read();
            int prev = read();
            for (int j = 1; j < k; j++) {
                int next = read();
                graph[prev].add(next);
                indegree[next]++;
                prev = next;
            }
        }

        // 위상정렬
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) if (indegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int next : graph[cur]) {
                if (--indegree[next] == 0) q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (result.size() != N) {
            sb.append(0).append("\n");
        } else {
            for (int x : result) sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}