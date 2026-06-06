import java.util.*;
import java.io.*;

class Solution {

    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] change = {
            {},
            {0, 1, 2, 3},
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {1, 2},
            {0, 2}
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = bfs();

            System.out.println("#" + tc + " " + ans);
        }
    }

    static int bfs() {

        Queue<int[]> q = new ArrayDeque<>();

        visited[R][C] = true;
        q.offer(new int[]{R, C, 1});

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (time >= L) continue;
            
            // 현재 칸의 번호
            int tunnelNum = map[x][y];

            for (int dir : change[tunnelNum]) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                if (!isConnected(dir, map[nx][ny])) continue;

                visited[nx][ny] = true;
                cnt++;

                q.offer(new int[]{nx, ny, time + 1});
            }
        }

        return cnt;
    }

    static boolean isConnected(int dir, int nextTunnel) {
        if (dir == 0) {
            for (int d : change[nextTunnel]) {
                if (d == 1) return true;
            }
        } else if (dir == 1) {
            for (int d : change[nextTunnel]) {
                if (d == 0) return true;
            }
        } else if (dir == 2) {
            for (int d : change[nextTunnel]) {
                if (d == 3) return true;
            }
        } else {
            for (int d : change[nextTunnel]) {
                if (d == 2) return true;
            }
        }

        return false;
    }
}