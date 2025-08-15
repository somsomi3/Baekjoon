import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans;
    static char[][] board;
    static int[][] path; // 상태 캐싱용 (비트마스크 저장)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        path = new int[R][C]; // 초기값은 0 (방문 전)
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int startMask = 1 << (board[0][0] - 'A');
        dfs(0, 0, startMask, 1);

        System.out.println(ans);
    }

    static void dfs(int y, int x, int mask, int depth) {
        ans = Math.max(ans, depth);

        // 현재 상태 저장 (가지치기)
        path[y][x] = mask;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;

            int bit = 1 << (board[ny][nx] - 'A');

            // 이미 방문한 알파벳이면 스킵
            if ((mask & bit) != 0) continue;

            // 동일한 상태로 이미 방문한 좌표면 스킵
            int newMask = mask | bit;
            if (path[ny][nx] == newMask) continue;

            dfs(ny, nx, newMask, depth + 1);
        }
    }
}
