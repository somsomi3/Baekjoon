import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int x, y, dist;
        boolean hole;

        MoveResult(int x, int y, int dist, boolean hole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hole = hole;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.depth >= 10) continue;

            for (int d = 0; d < 4; d++) {

                MoveResult red = move(cur.rx, cur.ry, d);
                MoveResult blue = move(cur.bx, cur.by, d);

                if (blue.hole) continue;

                if (red.hole) return cur.depth + 1;

                if (red.x == blue.x && red.y == blue.y) {
                    if (red.dist > blue.dist) {
                        red.x -= dx[d];
                        red.y -= dy[d];
                    } else {
                        blue.x -= dx[d];
                        blue.y -= dy[d];
                    }
                }

                if (!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    q.offer(new State(red.x, red.y, blue.x, blue.y, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static MoveResult move(int x, int y, int dir) {

        int nx = x;
        int ny = y;
        int dist = 0;

        while (board[nx + dx[dir]][ny + dy[dir]] != '#') {
            nx += dx[dir];
            ny += dy[dir];
            dist++;

            if (board[nx][ny] == 'O') {
                return new MoveResult(nx, ny, dist, true);
            }
        }

        return new MoveResult(nx, ny, dist, false);
    }
}