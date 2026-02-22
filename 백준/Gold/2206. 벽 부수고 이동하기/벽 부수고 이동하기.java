import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] graph;
    static boolean[][][] visited;

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[2][N][M]; // 상태를 앞으로

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 1}); // x, y, state, step
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int state = cur[2];
            int step = cur[3];

            if (x == N - 1 && y == M - 1) {
                return step;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈 칸
                if (graph[nx][ny] == 0 && !visited[state][nx][ny]) {
                    visited[state][nx][ny] = true;
                    q.offer(new int[]{nx, ny, state, step + 1});
                }

                // 벽이고 아직 안 부쉈다면
                if (graph[nx][ny] == 1 && state == 0 && !visited[1][nx][ny]) {
                    visited[1][nx][ny] = true;
                    q.offer(new int[]{nx, ny, 1, step + 1});
                }
            }
        }
        return -1;
    }
}