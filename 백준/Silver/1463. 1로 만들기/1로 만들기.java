import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X + 1];

        dp[1] = 0; // 1은 연산 없이 1

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1; // 기본: 1을 뺀 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[X]);
    }
}
