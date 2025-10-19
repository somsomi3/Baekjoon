import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        while (true) {
            if (!visited[r][c]) {
                visited[r][c] = true;
                count++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            if (arr[bx][by] == 1) break;

            r = bx;
            c = by;
        }

        System.out.println(count);
    }
}
