import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) { // 익은 토마토는 BFS 시작점
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs(q);

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0 && dist[i][j] == 0) { // 안 익은 게 남아있다면
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dist[i][j]);
            }
        }
        System.out.println(result);
    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (box[nx][ny] != 0) continue;

                box[nx][ny] = 1; // 토마토 익음
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
