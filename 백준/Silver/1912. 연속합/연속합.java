import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 시작
        dp[0] = arr[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
