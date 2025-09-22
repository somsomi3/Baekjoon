import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c;
                while ((c = System.in.read()) <= 32); // 공백/개행 무시
                map[i][j] = (char) c;
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L' && isEdge(i, j)) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isEdge(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) return true;
            if (map[nr][nc] == 'W') return true;
        }
        return false;
    }

    static int bfs(int sr, int sc) {
        dist = new int[N][M];
        for (int[] d : dist) Arrays.fill(d, -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        int maxDist = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 'L' && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    maxDist = Math.max(maxDist, dist[nr][nc]);
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return maxDist;
    }

    static int read() throws Exception {
        int c, n = 0;
        while ((c = System.in.read()) <= 32); // 공백/개행 건너뜀
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}
