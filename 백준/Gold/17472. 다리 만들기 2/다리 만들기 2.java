import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int a, b, w;
        Edge(int a, int b, int w) {
            this.a = a; this.b = b; this.w = w;
        }
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static class uni {
        int[] p;
        uni(int n) {
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x) {
            return p[x] == x ? x : (p[x] = find(p[x]));
        }
        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            p[b] = a;
            return true;
        }
    }

    static void dfs(int x, int y, int id) {
        visited[x][y] = true;
        map[x][y] = id;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visited[nx][ny] && map[nx][ny] == 1)
                dfs(nx, ny, id);
        }
    }

    static void makeBridge(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            int len = 0;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                if (map[nx][ny] == num) break;
                if (map[nx][ny] == 0) {
                    len++;
                    continue;
                }
                if (map[nx][ny] != num) {
                    if (len >= 2)
                        edges.add(new Edge(num, map[nx][ny], len));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int island = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1)
                    dfs(i, j, ++island);
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] != 0)
                    makeBridge(i, j, map[i][j]);

        Collections.sort(edges);
        uni unii = new uni(island);
        int cnt = 0, sum = 0;

        for (Edge e : edges) {
            if (unii.union(e.a, e.b)) {
                sum += e.w;
                cnt++;
                if (cnt == island - 1) break;
            }
        }

        int root = unii.find(1);
        for (int i = 2; i <= island; i++) {
            if (unii.find(i) != root) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sum);
    }
}
