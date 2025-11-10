import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N;

    //행렬곱셈
    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < N; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    //행렬 거듭제곱
    static long[][] power(long[][] A, long exp) {
        long[][] res = new long[N][N];
        for (int i = 0; i < N; i++) res[i][i] = 1;//단위행렬
        while (exp > 0) {
            if ((exp & 1) == 1) res = multiply(res, A);
            A = multiply(A, A);
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] A = new long[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            A[a][b] = (A[a][b] + 1) % MOD;
            A[b][a] = (A[b][a] + 1) % MOD;
        }

        int D = Integer.parseInt(br.readLine());

        long[][] AD = power(A, D);
        System.out.println(AD[0][0] % MOD);
    }
}
