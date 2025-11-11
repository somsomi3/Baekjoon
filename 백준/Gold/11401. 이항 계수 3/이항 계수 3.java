import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;
    static long[] fact, invFact;

    static long modPow(long a, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k < 0 || k > n) { System.out.println(0); return; }

        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i > 0; i--) invFact[i - 1] = (invFact[i] * i) % MOD;

        long ans = fact[n];
        ans = (ans * invFact[k]) % MOD;
        ans = (ans * invFact[n - k]) % MOD;
        System.out.println(ans);
    }
}
