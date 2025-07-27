import java.util.Scanner;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        dp = new int[N][1 << N];

        // 비용 배열 입력
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                W[i][j] = sc.nextInt();

        // dp 배열 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < (1 << N); j++)
                dp[i][j] = -1;

        // 0번 도시부터 시작한다고 가정
        int result = tsp(0, 1);
        System.out.println(result);
    }

    // 현재 도시가 current, 방문 상태가 visited일 때 최소 비용 반환
    static int tsp(int current, int visited) {
        if (visited == (1 << N) - 1) {
            if (W[current][0] == 0) return INF; // 갈 수 없으면 무한
            return W[current][0]; // 시작점으로 복귀
        }

        if (dp[current][visited] != -1) return dp[current][visited];

        int minCost = INF;

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[current][next] != 0) {
                int newVisited = visited | (1 << next);
                int cost = W[current][next] + tsp(next, newVisited);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[current][visited] = minCost;
    }
}
