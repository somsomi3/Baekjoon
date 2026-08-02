import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;
    static int[][] cost = {
            {1,7,6,7,5,4,5,3,2,3},
            {7,1,2,4,2,3,5,4,5,6},
            {6,2,1,2,3,2,3,5,4,5},
            {7,4,2,1,5,3,2,6,5,4},
            {5,2,3,5,1,2,4,2,3,5},
            {4,3,2,3,2,1,2,3,2,3},
            {5,5,3,2,4,2,1,5,3,2},
            {3,4,5,6,2,3,5,1,2,4},
            {2,5,4,5,3,2,3,2,1,2},
            {3,6,5,4,5,3,2,4,2,1}
    };

    public int solution(String numbers) {

        int[][] dp = new int[10][10];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[4][6] = 0;
        for (char ch : numbers.toCharArray()) {

            int x = ch - '0';
            int[][] next = new int[10][10];
            for (int i = 0; i < 10; i++) {
                Arrays.fill(next[i], INF);
            }

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {

                    if (dp[j][k] == INF) continue;

                    if (k != x) {
                        next[x][k] = Math.min(
                                next[x][k],
                                dp[j][k] + cost[j][x]
                        );
                    }
                    if (j != x) {
                        next[j][x] = Math.min(
                                next[j][x],
                                dp[j][k] + cost[k][x]
                        );
                    }
                }
            }

            dp = next;
        }
        int answer = INF;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[i][j]);
            }
        }

        return answer;
    }
}