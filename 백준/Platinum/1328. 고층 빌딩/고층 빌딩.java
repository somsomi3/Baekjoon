import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        dp = new int[N + 1][L + 1][R + 1];
        dp[1][1][1] = 1;  // 빌딩 1개일 때는 무조건 양쪽에서 1개 보임

        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    // 1. 가장 왼쪽에 가장 큰 건물
                    dp[n][l][r] = (dp[n][l][r] + dp[n - 1][l - 1][r]) % MOD;

                    // 2. 가장 오른쪽에 가장 큰 건물
                    dp[n][l][r] = (dp[n][l][r] + dp[n - 1][l][r - 1]) % MOD;

                    // 3. 중간에 가장 큰 건물
                    dp[n][l][r] = (dp[n][l][r] + (int)((long)(n - 2) * dp[n - 1][l][r] % MOD)) % MOD;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
