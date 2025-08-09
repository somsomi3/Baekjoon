import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, b, d;
        Node(int x, int y, int b, int d) {
            this.x = x; this.y = y; this.b = b; this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        System.out.println(bfs(map, N, M, K));
    }

    static int bfs(int[][] map, int N, int M, int K) {
        // visited[x][y][b] : (x,y)에 벽 b개 부순 상태로 방문했는가
        boolean[][][] visited = new boolean[N][M][K + 1];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) return cur.d;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈칸: 부순 횟수 그대로
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][cur.b]) {
                        visited[nx][ny][cur.b] = true;
                        q.add(new Node(nx, ny, cur.b, cur.d + 1));
                    }
                } else { // 벽: 아직 더 부술 수 있으면 +1
                    if (cur.b < K && !visited[nx][ny][cur.b + 1]) {
                        visited[nx][ny][cur.b + 1] = true;
                        q.add(new Node(nx, ny, cur.b + 1, cur.d + 1));
                    }
                }
            }
        }
        return -1;
    }
}
