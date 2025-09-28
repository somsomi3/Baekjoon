import java.io.*;
import java.util.*;

public class Main {
    static int N, K, W;
    static int[] buildTime, dp;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());  // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 건물 개수
            K = Integer.parseInt(st.nextToken());  // 규칙 개수

            // 초기화
            buildTime = new int[N + 1];
            dp = new int[N + 1];
            Arrays.fill(dp, -1); // DP 배열 초기화 (-1: 아직 계산되지 않음)
            graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 건설 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            // 건설 규칙 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[Y].add(X); // 🔹 역방향으로 저장 (트리 구조)
            }

            // 목표 건물 입력
            W = Integer.parseInt(br.readLine());

            // DFS를 통해 목표 건물까지 걸리는 최소 시간 계산
            sb.append(dfs(W)).append("\n");
        }

        System.out.println(sb.toString());
    }

    // DFS + DP로 최소 건설 시간 계산
    static int dfs(int building) {
        if (dp[building] != -1) {
            return dp[building]; // 이미 계산된 경우 반환
        }

        int maxTime = 0;
        for (int prev : graph[building]) { // 선행 건물 탐색
            maxTime = Math.max(maxTime, dfs(prev)); // 가장 오래 걸리는 건물 시간 선택
        }

        dp[building] = maxTime + buildTime[building]; // 최적 시간 저장
        return dp[building];
    }
}
