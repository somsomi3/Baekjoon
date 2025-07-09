import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        backtrack(0, 0);

        System.out.println(min);
    }

    // N명 중 N/2명을 선택하는 조합
    static void backtrack(int idx, int count) {
        if (count == N / 2) {
            // 팀 나누기 완료 → 능력치 계산
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 능력치 계산
    static void calculate() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        if (diff == 0) {
            // 더 이상 탐색할 필요 없음 → 정답!
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, diff);
    }
}
