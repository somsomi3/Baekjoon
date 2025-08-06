import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime, sangTime;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> fireQ;
    static Queue<int[]> sangQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            sangTime = new int[h][w];
            fireQ = new LinkedList<>();
            sangQ = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    fireTime[i][j] = -1;
                    sangTime[i][j] = -1;

                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        sangQ.offer(new int[]{i, j});
                        sangTime[i][j] = 0;
                    }
                }
            }

            bfs(fireQ, fireTime); 
            bfs(sangQ, sangTime);   

            int answer = Integer.MAX_VALUE;

            // 가장자리 칸들 중 상근이가 불보다 먼저 도착 가능한 칸 찾기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                        if (map[i][j] == '#') continue;              // 벽이면 탈출 불가
                        if (sangTime[i][j] == -1) continue;          // 상근이 도달 못함

                        int fire = fireTime[i][j] == -1 ? Integer.MAX_VALUE : fireTime[i][j];
                        int sang = sangTime[i][j];

                        if (sang < fire) {
                            answer = Math.min(answer, sang + 1);     // 탈출 성공 시간 기록
                        }
                    }
                }
            }

            if (answer == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer); // 최단 탈출 시간
            }
        }
    }

    // 일반 BFS: 주어진 큐를 기반으로 도달 시간 기록
    static void bfs(Queue<int[]> q, int[][] time) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == '#' || time[nx][ny] != -1) continue;

                time[nx][ny] = time[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
