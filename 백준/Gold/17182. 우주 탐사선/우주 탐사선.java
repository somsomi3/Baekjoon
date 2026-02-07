import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static int[][] w;
    static int[][] dp;
    static int all;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (w[i][j] > w[i][k] + w[k][j]) {
                        w[i][j] = w[i][k] + w[k][j];
                    }
                }
            }
        }

        all = (1 << n) - 1;
        dp = new int[1 << n][n];
        for (int[] r : dp) Arrays.fill(r, INF);

        dp[1 << s][s] = 0;

        for (int m = 0; m <= all; m++) {
            for (int cur = 0; cur < n; cur++) {
                if ((m & (1 << cur)) == 0) continue;
                if (dp[m][cur] == INF) continue;

                for (int nxt = 0; nxt < n; nxt++) {
                    if ((m & (1 << nxt)) != 0) continue;
                    int nm = m | (1 << nxt);
                    dp[nm][nxt] = Math.min(dp[nm][nxt], dp[m][cur] + w[cur][nxt]);
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[all][i]);
        }

        System.out.println(ans);
    }
}