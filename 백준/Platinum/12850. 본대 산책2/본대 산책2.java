import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static final int SIZE = 8;
    static long[][] base = new long[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();

        int[][] adj = {
            {0,1,1,0,0,0,0,0},
            {1,0,1,1,0,0,0,0},
            {1,1,0,1,1,0,0,0},
            {0,1,1,0,1,1,0,0},
            {0,0,1,1,0,1,1,0},
            {0,0,0,1,1,0,0,1},
            {0,0,0,0,1,0,0,1},
            {0,0,0,0,0,1,1,0}
        };

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                base[i][j] = adj[i][j];

        long[][] result = power(base, D);
        System.out.println(result[0][0]);
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int k = 0; k < SIZE; k++)
                for (int j = 0; j < SIZE; j++)
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
        return res;
    }

    static long[][] power(long[][] matrix, int exp) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) res[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) res = multiply(res, matrix);
            matrix = multiply(matrix, matrix);
            exp >>= 1;
        }
        return res;
    }
}
