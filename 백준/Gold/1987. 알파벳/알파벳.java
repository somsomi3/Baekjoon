import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans;
    static char[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int startMask = 1 << (board[0][0] - 'A');
        dfs(0, 0, startMask, 1);

        System.out.println(ans);
    }

    static void dfs(int y, int x, int mask, int depth) {
        ans = Math.max(ans, depth);
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;

            int bit = 1 << (board[ny][nx] - 'A');
            if ((mask & bit) == 0) {
                dfs(ny, nx, mask | bit, depth + 1);
            }
        }
    }
}
