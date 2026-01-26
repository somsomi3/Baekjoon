import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                	//문자가 다를때,
//                	A의 i, B의 j까지 봤을 때
//                	지금 문자는 못 쓰지만,
//                	이전까지 만들어 둔 LCS는 그대로 가져가자
//                	dp를 안 채우면:
//                	나중에 예전값을 참고할때에, 기준이 되는 자리가 없음. => DP가 끊어짐
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}