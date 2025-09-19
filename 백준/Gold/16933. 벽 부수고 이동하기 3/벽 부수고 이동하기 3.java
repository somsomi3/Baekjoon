import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x, y, broken, time, day;
        public Node(int x, int y, int broken, int time, int day) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.time = time;
            this.day = day;
        }
    }

    static int N, M, K;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        visited = new boolean[N][M][K + 1][2];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 1, 0));
        visited[0][0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.time);
                return;
            }

            int nd = (cur.day + 1) % 2;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == '0' && !visited[nx][ny][cur.broken][nd]) {
                    visited[nx][ny][cur.broken][nd] = true;
                    q.offer(new Node(nx, ny, cur.broken, cur.time + 1, nd));
                } else if (map[nx][ny] == '1' && cur.broken < K) {
                    if (cur.day == 0 && !visited[nx][ny][cur.broken + 1][nd]) {
                        visited[nx][ny][cur.broken + 1][nd] = true;
                        q.offer(new Node(nx, ny, cur.broken + 1, cur.time + 1, nd));
                    } else if (cur.day == 1) {
                        q.offer(new Node(cur.x, cur.y, cur.broken, cur.time + 1, nd));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
