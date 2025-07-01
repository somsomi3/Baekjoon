import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static Shark[][] map;
    static int[] dr = {0, -1, 1, 0, 0}; // 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
    static int[] dc = {0, 0, 0, 1, -1};
    static int answer = 0;

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 속력 최적화
            if (d == 1 || d == 2) {
                s = s % (2 * (R - 1));
            } else {
                s = s % (2 * (C - 1));
            }

            map[r][c] = new Shark(r, c, s, d, z);
        }

        // 낚시왕 이동
        for (int king = 1; king <= C; king++) {
            catchShark(king); // 상어 잡기
            moveSharks();     // 상어 이동
        }

        System.out.println(answer);
    }

    static void catchShark(int kingCol) {
        for (int row = 1; row <= R; row++) {
            if (map[row][kingCol] != null) {
                answer += map[row][kingCol].z;
                map[row][kingCol] = null;
                break;
            }
        }
    }

    static void moveSharks() {
        Shark[][] newMap = new Shark[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] != null) {
                    Shark shark = map[r][c];
                    int nr = shark.r;
                    int nc = shark.c;
                    int d = shark.d;
                    int s = shark.s;

                    // 한 칸씩 이동해도 되고,
                    // or 수식으로 반사 처리
                    while (s-- > 0) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 1 || nr > R || nc < 1 || nc > C) {
                            // 방향 반전
                            if (d == 1) d = 2;
                            else if (d == 2) d = 1;
                            else if (d == 3) d = 4;
                            else if (d == 4) d = 3;

                            // 반전하고 한 칸 더 이동
                            nr += dr[d] * 2;
                            nc += dc[d] * 2;
                        }
                    }

                    shark.r = nr;
                    shark.c = nc;
                    shark.d = d;

                    // 충돌 처리
                    if (newMap[nr][nc] == null || newMap[nr][nc].z < shark.z) {
                        newMap[nr][nc] = shark;
                    }
                }
            }
        }

        map = newMap;
    }
}
