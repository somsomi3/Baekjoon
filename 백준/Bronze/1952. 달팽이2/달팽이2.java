import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N][M];

        // 우, 하, 좌, 상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        int dir = 0;
        int turn = 0;

        visited[0][0] = true;
        int visitedCount = 1;

        while (visitedCount <N*M) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                turn++;
                continue;
            }

            x = nx;
            y = ny;
            visited[x][y] = true;
            visitedCount++;
        }

        System.out.println(turn);
    }
}
