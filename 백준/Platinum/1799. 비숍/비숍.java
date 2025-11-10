import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[] d1, d2;
    static int maxBlack, maxWhite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        d1 = new boolean[2 * N];
        d2 = new boolean[2 * N];

        dfs(0, 0, 0, true);   // black
        dfs(0, 1, 0, false);  // white (fixed start at y=1)

        System.out.println(maxBlack + maxWhite);
    }

    static void dfs(int x, int y, int cnt, boolean isBlack) {
        if (y >= N) {
            x++;
            y = (y % 2 == 0) ? 1 : 0;
        }
        if (x >= N) {
            if (isBlack) maxBlack = Math.max(maxBlack, cnt);
            else maxWhite = Math.max(maxWhite, cnt);
            return;
        }

        if (board[x][y] == 1 && !d1[x + y] && !d2[x - y + N]) {
            d1[x + y] = d2[x - y + N] = true;
            dfs(x, y + 2, cnt + 1, isBlack);
            d1[x + y] = d2[x - y + N] = false;
        }

        dfs(x, y + 2, cnt, isBlack);
    }
}
