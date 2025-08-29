import java.io.*;

public class Main {
    static int[][] dp;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2]; // 각 행렬의 크기 저장
        p = new int[N + 1];             // 행렬 곱셈용 차원 배열 (p[0]~p[N])

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(input[0]);
            matrix[i][1] = Integer.parseInt(input[1]);
        }

        p[0] = matrix[0][0];
        for (int i = 0; i < N; i++) {
            p[i + 1] = matrix[i][1];
        }

        dp = new int[N + 1][N + 1];

        //DP
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
