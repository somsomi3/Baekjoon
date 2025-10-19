import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            d = ((d % 360) + 360) % 360; // 음수 각도 보정
            int turn = (d / 45) % 8;
            if (turn == 0) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) sb.append(arr[i][j]).append(' ');
                    sb.append('\n');
                }
                continue;
            }

            for (int t = 0; t < turn; t++) {
                int[][] tmp = new int[N][N];
                int mid = N / 2;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        tmp[i][j] = arr[i][j];
                    }
                }

                for (int i = 0; i < N; i++) {
                    tmp[i][mid] = arr[i][i];// 정대각선에 중앙세로줄을 넣는다. 최종: 중앙세로줄
                    tmp[i][N - 1 - i] = arr[i][mid];
                    tmp[mid][N - 1 - i] = arr[i][N - 1 - i];
                    tmp[i][i] = arr[mid][i];
                }

                arr = tmp;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) sb.append(arr[i][j]).append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
