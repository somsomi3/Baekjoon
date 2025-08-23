import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;
    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};
        long[] ab = fib(n >> 1);
        long a = ab[0];
        long b = ab[1];

        long twoBminusA = (2 * b % MOD - a + MOD) % MOD;
        long c = a * twoBminusA % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;

        if ((n & 1) == 0) return new long[]{c, d};
        else return new long[]{d, (c + d) % MOD};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        System.out.println(fib(n)[0] % MOD);
    }
}
