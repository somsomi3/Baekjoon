import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        
        // 삼각형 입력 받기
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 꼭대기 초기화
        dp[0][0] = triangle[0][0];

        // DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 좌측 끝
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]; // 우측 끝
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // 마지막 줄에서 최대값 출력
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);
    }
}
