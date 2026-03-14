import java.io.*;
import java.util.*;
import java.math.BigInteger;

////공식2nCr=(n−1Cr−1)+(n−1Cr)

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[101][101];
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = BigInteger.ONE;
            dp[i][i] = BigInteger.ONE;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}