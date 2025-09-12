import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[] fib = fibMatrix(n);
        long Fn = fib[0];
        long Fn1 = fib[1];

        long result = (Fn * Fn1) % MOD;
        System.out.println(result);
    }

    static long[] fibMatrix(long n) {
        if (n == 0) return new long[]{0, 1};
        long[] half = fibMatrix(n >> 1);
        long a = half[0], b = half[1];
        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;
        if ((n & 1) == 0) return new long[]{c, d};
        else return new long[]{d, (c + d) % MOD};
    }
}
