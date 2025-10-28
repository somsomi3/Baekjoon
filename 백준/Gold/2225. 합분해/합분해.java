import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[K + 1][N + 1];
        final int MOD = 1_000_000_000;
        
        for (int i = 0; i <= N; i++) dp[1][i] = 1;
        
        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        System.out.println(dp[K][N]);
    }
}
