import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N, P;
    static int[][] cost;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        // 비용 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 켜진 발전소 상태 입력
        String status = br.readLine();
        int start = 0;
        for (int i = 0; i < N; i++) {
            if (status.charAt(i) == 'Y') {
                start |= (1 << i);
            }
        }

        P = Integer.parseInt(br.readLine());

        // 시작 상태에서 이미 P개 이상 켜져있으면 바로 0 출력
        if (Integer.bitCount(start) >= P) {
            System.out.println(0);
            return;
        }

        // DP 초기화
        int totalState = 1 << N;
        dp = new int[totalState];
        Arrays.fill(dp, INF);
        dp[start] = 0;

        // 상태 전이
        for (int bit = 0; bit < totalState; bit++) {
            if (dp[bit] == INF) continue;

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) == 0) continue; // i번 발전소가 꺼져 있으면 패스

                for (int j = 0; j < N; j++) {
                    if ((bit & (1 << j)) != 0) continue; // j번이 이미 켜져 있음

                    int next = bit | (1 << j);
                    dp[next] = Math.min(dp[next], dp[bit] + cost[i][j]);
                }
            }
        }

        // 가능한 상태 중 P개 이상 켜진 상태 중 최소 비용 찾기
        int answer = INF;
        for (int bit = 0; bit < totalState; bit++) {
            if (Integer.bitCount(bit) >= P) {
                answer = Math.min(answer, dp[bit]);
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
