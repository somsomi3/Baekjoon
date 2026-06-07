import java.util.*;
import java.io.*;

class Solution {

    static int N;
    static int[][] map;
    static boolean[] dessert;
    static int answer;
    static int startX, startY;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    startX = i;
                    startY = j;

                    dessert = new boolean[101];
                    dessert[map[i][j]] = true;

                    dfs(i, j, 0, 1);
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int x, int y, int dir, int cnt) {

        for (int d = dir; d <= dir + 1 && d < 4; d++) { //같은 사각형을 여러 번 탐색을 막기위해, 방향제한을 만듬
		//현재 방향			허용
		//0 				0 , 1 
		//1 				1 , 2 
		//2 				2 , 3 
		//3 				3 
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (nx == startX && ny == startY && cnt >= 4) {
                answer = Math.max(answer, cnt);
                continue;
            }

            int num = map[nx][ny];

            if (dessert[num]) {
                continue;
            }

            dessert[num] = true;

            dfs(nx, ny, d, cnt + 1);

            dessert[num] = false;
        }
    }
}