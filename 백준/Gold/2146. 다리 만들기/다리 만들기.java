import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] dist;
    static int[][] cities;
    static Queue<int[]> queue = new ArrayDeque<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        getInput();
        markCity();
        bfs();
        System.out.println(answer);
    }

    //모든 섬의 가장자리에서 동시에 출발
    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], id = curr[2];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 바다 → 다리 확장
                if (dist[nr][nc] == -1) {
                    queue.add(new int[]{nr, nc, id});
                    cities[nr][nc] = id;
                    dist[nr][nc] = dist[r][c] + 1;
                }
                // 다른 섬 만남 → 다리 길이 계산
                else if (cities[nr][nc] != id) {
                    answer = Math.min(answer, dist[nr][nc] + dist[r][c]);
                }
            }
        }
    }

    // 섬 구분하기 + "가장자리"만 큐에 넣기
    public static void markCity() {
        Queue<int[]> q = new ArrayDeque<>();
        int city = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == 0 && cities[i][j] == 0) {
                    q.add(new int[]{i, j});
                    cities[i][j] = ++city;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0], c = curr[1];

                        boolean isEdge = false;

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                            if (dist[nr][nc] == -1) {
                                //가장자리
                                isEdge = true;
                            } else if (dist[nr][nc] == 0 && cities[nr][nc] == 0) {
                                cities[nr][nc] = city;
                                q.add(new int[]{nr, nc});
                            }
                        }

                        // 가장자리만 큐에 넣기
                        if (isEdge) {
                            queue.add(new int[]{r, c, city});
                        }
                    }
                }
            }
        }
    }

    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        cities = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("0"))
                    dist[i][j] = -1;
                else
                    dist[i][j] = 0;
            }
        }
    }
}
