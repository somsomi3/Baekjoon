import java.io.*;

public class Main {
    static int N, count = 0;
    static int[] col; // 각 행에 퀸을 놓은 열 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        dfs(0); // 0번째 행부터 시작
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++; // 퀸을 N개 다 놓았으면 정답 카운트 증가
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i; // row행 i열에 퀸 놓기 시도
            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열 or 대각선에 있으면 false
            if (col[row] == col[i]) return false;
            if (Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}
