import java.io.*;
import java.util.*;

public class Main {
    static int N, M, fuel;
    static int[][] map;
    static boolean[][] visited;

    static int taxiX, taxiY;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Passenger {
        int startX, startY, endX, endY;

        public Passenger(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 1이면 벽
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken()) - 1;
        taxiY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(sx, sy, ex, ey));
        }

        for (int i = 0; i < M; i++) {
            int[] next = findNearestPassenger();
            if (next == null) {
                System.out.println(-1);
                return;
            }

            int px = next[0], py = next[1], distToPassenger = next[2];
            Passenger target = null;

            for (Passenger p : passengers) {
                if (p.startX == px && p.startY == py) {
                    target = p;
                    break;
                }
            }

            if (target == null) {
                System.out.println(-1);
                return;
            }

            if (fuel < distToPassenger) {
                System.out.println(-1);
                return;
            }

            fuel -= distToPassenger;
            taxiX = px;
            taxiY = py;

            int distToDest = bfs(taxiX, taxiY, target.endX, target.endY);
            if (distToDest == -1 || fuel < distToDest) {
                System.out.println(-1);
                return;
            }

            fuel -= distToDest;
            fuel += distToDest * 2;

            taxiX = target.endX;
            taxiY = target.endY;
            passengers.remove(target);
        }

        System.out.println(fuel);
    }

    // 승객 중 가장 가까운 사람 찾기
    static int[] findNearestPassenger() {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        List<int[]> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (dist > minDist) break;

            for (Passenger p : passengers) {
                if (p.startX == x && p.startY == y) {
                    candidates.add(new int[]{x, y, dist});
                    minDist = dist;
                    break;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        if (candidates.isEmpty()) return null;

        candidates.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return candidates.get(0); // 가장 가까운 승객 좌표 및 거리
    }

    // 목적지까지의 거리 계산
    static int bfs(int sx, int sy, int ex, int ey) {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == ex && y == ey) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}
