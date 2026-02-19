import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] box = new int[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int sum = 0;

            for (int j = 0; j < n; j++) {
                int empty = 0;

                for (int i = m - 1; i >= 0; i--) {
                    if (box[i][j] == 0) {
                        empty++;
                    } else {
                        sum += empty;
                    }
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}