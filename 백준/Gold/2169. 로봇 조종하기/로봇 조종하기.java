import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 줄 초기화
        dp[0][0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        // 2번째 줄부터 각 행마다 좌->우, 우->좌 두 번 탐색
        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];

            // 왼쪽에서 오는 경우
            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + map[i][j];
            }

            // 오른쪽에서 오는 경우
            right[M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + map[i][j];
            }

            // 둘 중 최대값 선택
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
