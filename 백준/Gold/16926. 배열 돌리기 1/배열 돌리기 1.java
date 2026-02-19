import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layer = Math.min(N, M) / 2;

        for (int l = 0; l < layer; l++) {
            int perimeter = 2 * (N - 2 * l) + 2 * (M - 2 * l) - 4;
            int rotate = R % perimeter;

            for (int r = 0; r < rotate; r++) {

                int temp = arr[l][l];

                for (int i = l; i < M - l - 1; i++)
                    arr[l][i] = arr[l][i + 1];

                for (int i = l; i < N - l - 1; i++)
                    arr[i][M - l - 1] = arr[i + 1][M - l - 1];

                for (int i = M - l - 1; i > l; i--)
                    arr[N - l - 1][i] = arr[N - l - 1][i - 1];

                for (int i = N - l - 1; i > l + 1; i--)
                    arr[i][l] = arr[i - 1][l];

                arr[l + 1][l] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
