import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 4000001;
    static final int MOD = 1000000007;
    static long[] fact = new long[MAX];        // 팩토리얼
    static long[] invFact = new long[MAX];     // 역팩토리얼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        precompute();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k < 0 || k > n) {
                sb.append(0).append("\n");
            } else {
                long result = binomial(n, k);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long binomial(int n, int k) {
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    static void precompute() {
        fact[0] = invFact[0] = 1;

        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);

        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    static long power(long x, long n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) result = result * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return result;
    }
}
