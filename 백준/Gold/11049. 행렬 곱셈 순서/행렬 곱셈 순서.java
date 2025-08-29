import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 행렬 개수
        int[][] size = new int[N][2]; // 각 행렬의 (행, 열)

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken()); // 행
            size[i][1] = Integer.parseInt(st.nextToken()); // 열
        }

        // DP 배열: 최소 곱셈 연산 횟수
        int[][] dp = new int[N][N];
        // 결과 행렬의 행, 열 크기 추적
        int[][] row = new int[N][N];
        int[][] col = new int[N][N];

        // 초기화: 각 행렬 자기 자신
        for (int i = 0; i < N; i++) {
            row[i][i] = size[i][0];
            col[i][i] = size[i][1];
        }

        // 길이 2부터 N까지의 구간 처리
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                             + row[i][k] * col[i][k] * col[k + 1][j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        row[i][j] = row[i][k];
                        col[i][j] = col[k + 1][j];
                    }
                }
            }
        }

        System.out.println(dp[0][N - 1]); // 최소 곱셈 연산 횟수 출력
    }
}
