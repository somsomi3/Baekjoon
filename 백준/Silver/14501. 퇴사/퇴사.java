import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] T, P, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        T = new int[N + 2];  // 1-based
        P = new int[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // DP 역순으로 채우기
        for (int i = N; i >= 1; i--) {
            int next = i + T[i];
            if (next <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[next]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
