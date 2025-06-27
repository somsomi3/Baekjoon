import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] copy;
    static List<CCTV> cctvs = new ArrayList<>();

    // 방향: ↑, →, ↓, ←
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 각 CCTV 타입별 방향 조합
    static int[][][] directions = {
        {}, // 0번 CCTV 없음
        {{0}, {1}, {2}, {3}},                     // 1번
        {{0, 2}, {1, 3}},                         // 2번
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},         // 3번
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
        {{0, 1, 2, 3}}                            // 5번
    };

    static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == cctvs.size()) {
            min = Math.min(min, getBlindSpot());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] backup = copyMap(map); // 원본 백업

        for (int[] dirs : directions[cctv.type]) {
            for (int dir : dirs) {
                watch(cctv.x, cctv.y, dir);
            }
            dfs(depth + 1);
            map = copyMap(backup); // 복원
        }
    }

    static void watch(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (inRange(nx, ny) && map[nx][ny] != 6) {
            if (map[nx][ny] == 0) map[nx][ny] = -1; // 감시 표시
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int getBlindSpot() {
        int count = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == 0) count++;
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] src) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = src[i].clone();
        }
        return newMap;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
