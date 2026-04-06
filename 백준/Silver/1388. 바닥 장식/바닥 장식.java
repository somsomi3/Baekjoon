import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (board[x][y] == '-') {
            int ny = y + 1;
            if (ny < M && !visited[x][ny] && board[x][ny] == '-') {
                dfs(x, ny);
            }
        } else {
            int nx = x + 1;
            if (nx < N && !visited[nx][y] && board[nx][y] == '|') {
                dfs(nx, y);
            }
        }
    }
}