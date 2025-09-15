import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    static int read() throws Exception {
        int c, n = 0, s = 1;
        while ((c = System.in.read()) <= 32) if (c == -1) return -1;
        if (c == '-') { s = -1; c = System.in.read(); }
        do { n = n * 10 + (c - '0'); c = System.in.read(); } while (c > 32);
        return n * s;
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        int[][] cost = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            cost[i][0] = read();
            cost[i][1] = read();
            cost[i][2] = read();
        }

        int answer = INF;
        for (int s = 0; s < 3; s++) {
            int[][] dp = new int[N + 1][3];
            for (int c = 0; c < 3; c++) dp[1][c] = (c == s) ? cost[1][c] : INF;
            for (int i = 2; i <= N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            for (int c = 0; c < 3; c++) if (c != s) answer = Math.min(answer, dp[N][c]);
        }

        System.out.println(answer);
    }
}
