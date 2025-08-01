import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1}; // 위, 중간, 아래 순서
    static int[] dy = {1, 1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean dfs(int x, int y) {
        visited[x][y] = true;

        if (y == C - 1) return true;

        for (int dir = 0; dir < 3; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    if (dfs(nx, ny)) return true; // 한 번 성공하면 바로 리턴
                }
            }
        }

        return false;
    }
}
