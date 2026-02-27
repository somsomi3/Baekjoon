import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int bfs(int s) {
        boolean[] v = new boolean[N + 1];
        int[] d = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        v[s] = true;

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int n : graph[c]) {
                if (!v[n]) {
                    v[n] = true;
                    d[n] = d[c] + 1;
                    q.offer(n);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += d[i];
        }
        return sum;
    }
}