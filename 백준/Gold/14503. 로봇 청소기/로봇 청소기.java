import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cleanedCount = 0;

    // 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 시작 행
        int c = Integer.parseInt(st.nextToken()); // 시작 열
        int d = Integer.parseInt(st.nextToken()); // 시작 방향

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(cleanedCount);
    }

    static void dfs(int x, int y, int dir) {
        // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (!visited[x][y]) {
            visited[x][y] = true;
            cleanedCount++;
        }

        // 2. 주변 4칸 확인
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isInRange(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, dir); // 이동 후 재귀 호출
                return; // 이동했으면 현재 위치에서 탐색 끝
            }
        }

        // 3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우, 후진
        int back = (dir + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (isInRange(bx, by) && map[bx][by] == 0) {
            dfs(bx, by, dir); // 방향 유지한 채 후진
        }
        // 후진도 못하면 종료 (재귀 종료)
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
