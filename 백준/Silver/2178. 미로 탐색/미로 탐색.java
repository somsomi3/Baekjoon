import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dist = new int[N][M];
        visited = new boolean[N][M];

        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        dist[sx][sy] = 1;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == '0') continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
