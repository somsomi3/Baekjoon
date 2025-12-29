import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    static int tsp(int mask, int cur) {
        if (mask == (1 << N) - 1) {
            if (cost[cur][0] == 0) return INF;
            return cost[cur][0];
        }

        if (dp[mask][cur] != -1) return dp[mask][cur];

        int ret = INF;

        for (int next = 0; next < N; next++) {
            if ((mask & (1 << next)) != 0) continue;
            if (cost[cur][next] == 0) continue;

            int nextMask = mask | (1 << next);
            ret = Math.min(ret, tsp(nextMask, next) + cost[cur][next]);
        }

        return dp[mask][cur] = ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1 << N][N];
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(1, 0));
    }
}
