import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        K = read();
        W = read();
        H = read();

        map = new int[H][W];
        visited = new boolean[K + 1][H][W];

        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                map[i][j] = read();

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == H - 1 && cur.y == W - 1)
                return cur.dist;

            // 원숭이 이동 (상하좌우)
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (isInRange(nx, ny) && !visited[cur.horse][nx][ny] && map[nx][ny] == 0) {
                    visited[cur.horse][nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.horse, cur.dist + 1));
                }
            }

            // 말 이동
            if (cur.horse < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + hx[d];
                    int ny = cur.y + hy[d];

                    if (isInRange(nx, ny) && !visited[cur.horse + 1][nx][ny] && map[nx][ny] == 0) {
                        visited[cur.horse + 1][nx][ny] = true;
                        q.offer(new Node(nx, ny, cur.horse + 1, cur.dist + 1));
                    }
                }
            }
        }
        return -1;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }

    static class Node {
        int x, y, horse, dist;

        Node(int x, int y, int horse, int dist) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.dist = dist;
        }
    }

    // 입력 최적화: 정수 read
    static int read() throws Exception {
        int c, n = System.in.read();
        while (n <= 32) n = System.in.read();
        n &= 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
