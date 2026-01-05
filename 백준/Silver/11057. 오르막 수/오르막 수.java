import java.io.*;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        // 길이 1 초기값
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // DP 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }

        // 정답: dp[N][0..9] 합
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + dp[N][j]) % MOD;
        }

        System.out.println(ans);
    }
}
