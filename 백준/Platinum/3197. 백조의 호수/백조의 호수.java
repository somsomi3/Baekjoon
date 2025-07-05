import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] waterVisited;
    static boolean[][] swanVisited;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> nextWaterQ = new LinkedList<>();
    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> nextSwanQ = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] swan1, swan2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        waterVisited = new boolean[R][C];
        swanVisited = new boolean[R][C];

        int swanCount = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] != 'X') {
                    waterQ.offer(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
                if (map[i][j] == 'L') {
                    if (swanCount == 0) {
                        swan1 = new int[]{i, j};
                        swanCount++;
                    } else {
                        swan2 = new int[]{i, j};
                    }
                }
            }
        }

        swanQ.offer(swan1);
        swanVisited[swan1[0]][swan1[1]] = true;

        int day = 0;

        while (true) {
            if (moveSwan()) break;
            meltIce();
            swanQ = nextSwanQ;
            waterQ = nextWaterQ;
            nextSwanQ = new LinkedList<>();
            nextWaterQ = new LinkedList<>();
            day++;
        }

        System.out.println(day);
    }

    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (swanVisited[nx][ny]) continue;

                swanVisited[nx][ny] = true;

                if (map[nx][ny] == '.') {
                    swanQ.offer(new int[]{nx, ny});
                } else if (map[nx][ny] == 'X') {
                    nextSwanQ.offer(new int[]{nx, ny});
                } else if (map[nx][ny] == 'L') {
                    return true; // 두 백조 만남
                }
            }
        }
        return false;
    }

    static void meltIce() {
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (waterVisited[nx][ny]) continue;

                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    nextWaterQ.offer(new int[]{nx, ny});
                    waterVisited[nx][ny] = true;
                }
            }
        }
    }
}
