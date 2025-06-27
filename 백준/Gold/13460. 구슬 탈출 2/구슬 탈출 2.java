import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Ball {
        int rx, ry, bx, by, depth;
        Ball(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<Ball> queue = new LinkedList<>();
        queue.add(new Ball(rx, ry, bx, by, 1));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Ball cur = queue.poll();

            if (cur.depth > 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] nRed = move(cur.rx, cur.ry, dx[d], dy[d]);
                int[] nBlue = move(cur.bx, cur.by, dx[d], dy[d]);

                int nrx = nRed[0], nry = nRed[1], rCount = nRed[2];
                int nbx = nBlue[0], nby = nBlue[1], bCount = nBlue[2];

                if (map[nbx][nby] == 'O') continue; // 파란 공이 빠지면 실패
                if (map[nrx][nry] == 'O') return cur.depth; // 빨간 공만 빠짐 → 성공

                if (nrx == nbx && nry == nby) {
                    if (rCount > bCount) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.add(new Ball(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    // 구슬 굴리기
    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (true) {
            if (map[x + dx][y + dy] == '#' || map[x][y] == 'O') break;
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }
}
