import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static char[][] graph;
    static int[][] water;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        water = new int[R][C];
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(water[i], -1);
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> wQueue = new LinkedList<>();
        Queue<int[]> sQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);

                if (graph[i][j] == '*') {
                    wQueue.offer(new int[]{i, j});
                    water[i][j] = 0;
                }

                if (graph[i][j] == 'S') {
                    sQueue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!wQueue.isEmpty()) {
            int[] cur = wQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (graph[nx][ny] == 'X' || graph[nx][ny] == 'D') continue;
                if (water[nx][ny] != -1) continue;

                water[nx][ny] = water[cur[0]][cur[1]] + 1;
                wQueue.offer(new int[]{nx, ny});
            }
        }

        while (!sQueue.isEmpty()) {
            int[] cur = sQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (graph[nx][ny] == 'X') continue;
                if (dist[nx][ny] != -1) continue;

                if (water[nx][ny] != -1 && water[nx][ny] <= dist[cur[0]][cur[1]] + 1) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                sQueue.offer(new int[]{nx, ny});
            }
        }
        int answer = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'D') {
                    answer = dist[i][j];
                }
            }
        }
        if (answer == -1) System.out.println("KAKTUS");
        else System.out.println(answer);
    }
}