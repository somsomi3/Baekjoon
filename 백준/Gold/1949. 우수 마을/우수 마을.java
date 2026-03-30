import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[][] dp;
    static int[] people;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        people = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) people[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int cur) {
        visited[cur] = true;

        dp[cur][1] = people[cur];  // cur가 우수마을인 경우
        dp[cur][0] = 0;            // cur가 우수마을이 아닌 경우

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);

                dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
                dp[cur][1] += dp[next][0];
            }
        }
    }
}
