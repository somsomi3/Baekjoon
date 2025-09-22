import java.io.*;
import java.util.*;

public class Main {
    static int W, H;
    static char[][] map;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int x, y, dir, mirror;
        State(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    points.add(new int[]{i, j});
                }
            }
        }

        int[] start = points.get(0);
        int[] end = points.get(1);

        dist = new int[H][W][4];
        for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        Deque<State> dq = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            dist[start[0]][start[1]][d] = 0;
            dq.offerFirst(new State(start[0], start[1], d, 0));
        }

        while (!dq.isEmpty()) {
            State cur = dq.pollFirst();
            int x = cur.x, y = cur.y, dir = cur.dir, mirror = cur.mirror;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] != '*') {
                if (dist[nx][ny][dir] > mirror) {
                    dist[nx][ny][dir] = mirror;
                    dq.offerFirst(new State(nx, ny, dir, mirror));
                }
            }

            for (int nd = 0; nd < 4; nd++) {
                if (nd == dir) continue;
                int mx = x + dx[nd];
                int my = y + dy[nd];
                if (0 <= mx && mx < H && 0 <= my && my < W && map[mx][my] != '*') {
                    if (dist[mx][my][nd] > mirror + 1) {
                        dist[mx][my][nd] = mirror + 1;
                        dq.offerLast(new State(mx, my, nd, mirror + 1));
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[end[0]][end[1]][d]);
        }
        System.out.println(answer);
    }
}
