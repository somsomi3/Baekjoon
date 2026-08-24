import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {

        boolean[][][] dp = new boolean[info.length + 1][n][m];

        dp[0][0][0] = true;

        for (int i = 0; i < info.length; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {

                    if (!dp[i][a][b]) continue;

                    // A가 훔침
                    int na = a + info[i][0];

                    if (na < n) {
                        dp[i + 1][na][b] = true;
                    }

                    // B가 훔침
                    int nb = b + info[i][1];

                    if (nb < m) {
                        dp[i + 1][a][nb] = true;
                    }
                }
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[info.length][a][b]) {
                    return a;
                }
            }
        }

        return -1;
    }
}