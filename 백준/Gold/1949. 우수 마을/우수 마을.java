import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        N = read();

        population = new int[N + 1];
        for (int i = 1; i <= N; i++) population[i] = read();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int a = read();
            int b = read();
            graph[a].add(b);
            graph[b].add(a);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int now) {
        visited[now] = true;
        dp[now][0] = 0;
        dp[now][1] = population[now];

        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
                dp[now][0] += Math.max(dp[next][0], dp[next][1]);
                dp[now][1] += dp[next][0];
            }
        }
    }

    static int read() throws Exception {
        int c, n = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            neg = true;
            c = System.in.read();
        }
        do n = n * 10 + c - '0';
        while ((c = System.in.read()) > 32);
        return neg ? -n : n;
    }
}
