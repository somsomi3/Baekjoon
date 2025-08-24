import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] seat;
    static List<Integer> valid;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            seat = new int[N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                int bit = 0;
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == '.') {
                        bit |= (1 << j);
                    }
                }
                seat[i] = bit;
            }

            valid = new ArrayList<>();
            for (int mask = 0; mask < (1 << M); mask++) {
                if ((mask & (mask << 1)) == 0) {
                    valid.add(mask);
                }
            }

            dp = new int[N][1 << M];
            for (int[] row : dp) Arrays.fill(row, -1);

            int ans = 0;
            for (int mask : valid) {
                if ((mask & seat[0]) == mask) {
                    dp[0][mask] = Integer.bitCount(mask);
                    ans = Math.max(ans, dp[0][mask]);
                }
            }

            int limitMask = (1 << M) - 1;

            // DP
            for (int i = 1; i < N; i++) {
                for (int mask : valid) {
                    if ((mask & seat[i]) != mask) continue;
                    for (int prev : valid) {
                        if (dp[i - 1][prev] == -1) continue;
                        if ((mask & ((prev << 1) & limitMask)) == 0 &&
                            (mask & (prev >> 1)) == 0) {
                            dp[i][mask] = Math.max(dp[i][mask],
                                    dp[i - 1][prev] + Integer.bitCount(mask));
                            ans = Math.max(ans, dp[i][mask]);
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
