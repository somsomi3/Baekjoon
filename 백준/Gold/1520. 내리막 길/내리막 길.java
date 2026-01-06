import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int dfs(int x, int y) {
        //끝까지 도달하여서 하나의경로가 완성되면, 
    	//dfs는 return 1을 한다.
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if (map[nx][ny] < map[x][y]) {
                //트리에서 부모의 이하 것들은 자식들을 모두 더하는 거랑 비슷함
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
}
