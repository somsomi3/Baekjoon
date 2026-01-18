import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long exp;
    static int[][] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        exp = Long.parseLong(st.nextToken());

        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans = power(mat, exp);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int[][] power(int[][] a, long e) {
        if (e == 1) return a;

        int[][] half = power(a, e / 2);
        int[][] res = mul(half, half);

        if (e % 2 == 1) {
            res = mul(res, a);
        }

        return res;
    }

    static int[][] mul(int[][] a, int[][] b) {
        int[][] res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) a[i][k] * b[k][j];
                }
                res[i][j] = (int) (sum % 1000);
            }
        }
        return res;
    }
}
