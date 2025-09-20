import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, time;
        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;

        int res = Integer.MAX_VALUE;
        int gramDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                res = Math.min(res, cur.time);
            }

            if (map[cur.x][cur.y] == 2) {
                int dist = cur.time + (N - 1 - cur.x) + (M - 1 - cur.y);
                gramDist = Math.min(gramDist, dist);
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny, cur.time + 1));
            }
        }

        int ans = Math.min(res, gramDist);
        System.out.println(ans <= T ? ans : "Fail");
    }
}
