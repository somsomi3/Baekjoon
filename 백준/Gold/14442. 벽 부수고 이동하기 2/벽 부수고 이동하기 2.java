import java.io.*;

public class Main {


    static int readInt() throws Exception {
        int c, n = 0;
        while ((c = System.in.read()) <= 32) {
            if (c == -1) return -1;
        }
        do {
            n = n * 10 + (c - '0');
            c = System.in.read();
        } while (c > 32);
        return n;
    }

    static void readGrid(byte[][] map, int N, int M) throws Exception {
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < M) {
                int c = System.in.read();
                if (c == '0' || c == '1') {
                    map[i][j++] = (byte) (c - '0');
                } else if (c == -1) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final int N = readInt();
        final int M = readInt();
        final int K = readInt();

        byte[][] map = new byte[N][M];
        readGrid(map, N, M);

        boolean[][][] visited = new boolean[N][M][K + 1];

        final int CAP = N * M * (K + 1) + 5;
        int[] qx = new int[CAP];
        int[] qy = new int[CAP];
        int[] qb = new int[CAP];
        int head = 0, tail = 0;

        // helpers
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};

        // enqueue start (0,0,0)
        qx[tail] = 0; qy[tail] = 0; qb[tail] = 0;
        if (++tail == CAP) tail = 0;
        visited[0][0][0] = true;

        int steps = 1; // 시작칸 포함

        while (head != tail) {
            int qsz = tail - head;
            if (qsz < 0) qsz += CAP;

            for (int s = 0; s < qsz; s++) {
                // dequeue
                int x = qx[head];
                int y = qy[head];
                int b = qb[head];
                if (++head == CAP) head = 0;

                // 도착
                if (x == N - 1 && y == M - 1) {
                    System.out.println(steps);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][b]) {
                            visited[nx][ny][b] = true;
                            qx[tail] = nx; qy[tail] = ny; qb[tail] = b;
                            if (++tail == CAP) tail = 0;
                        }
                    } else { // 벽
                        if (b < K && !visited[nx][ny][b + 1]) {
                            visited[nx][ny][b + 1] = true;
                            qx[tail] = nx; qy[tail] = ny; qb[tail] = b + 1;
                            if (++tail == CAP) tail = 0;
                        }
                    }
                }
            }
            steps++; // 다음 레벨(거리 +1)
        }

        System.out.println(-1);
    }
}
