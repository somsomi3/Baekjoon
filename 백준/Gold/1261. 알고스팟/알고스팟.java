import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(dist[N - 1][M - 1]);
    }
    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                int cost = dist[x][y] + arr[nx][ny];

                if (dist[nx][ny] > cost) {
                    dist[nx][ny] = cost;

                    if (arr[nx][ny] == 0) dq.addFirst(new int[]{nx, ny});
                    else dq.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}