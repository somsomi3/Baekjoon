import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 섬 구분 BFS
    static void bfs(int x, int y, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 다리 BFS (id 섬에서 출발)
    static int bfs2(int id) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();

        // 해당 섬의 모든 좌표를 시작점으로 넣음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == id) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 바다일 경우 다리 연장
                if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
                // 다른 섬을 만나면 다리 완성
                else if (map[nx][ny] != 0 && map[nx][ny] != id) {
                    return dist[x][y];
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 붙이기
        int id = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, id++);
                }
            }
        }

        // 다리 BFS 실행
        int ans = Integer.MAX_VALUE;
        for (int k = 2; k < id; k++) {
            ans = Math.min(ans, bfs2(k));
        }

        System.out.println(ans);
    }
}
