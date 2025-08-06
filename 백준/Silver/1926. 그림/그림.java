import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = readInt(br);
        M = readInt(br);

        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < M) {
                int c = br.read();
                if (c == ' ' || c == '\n') continue;
                map[i][j++] = (c == '1');
            }
        }

        int count = 0, maxArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j]) {
                    count++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || !map[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
            }
        }
        return area;
    }

    static int readInt(BufferedReader br) throws IOException {
        int val = 0, c;
        while ((c = br.read()) <= ' ') ; // skip space/newline
        do {
            val = val * 10 + (c - '0');
        } while ((c = br.read()) >= '0' && c <= '9');
        return val;
    }
}
