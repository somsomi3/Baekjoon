import java.io.*;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long G = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        long x = L / G;

        long p = 0, q = 0;

        for (long i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                long a = i;
                long b = x / i;

                if (gcd(a, b) == 1) {
                    p = a;
                    q = b;
                }
            }
        }

        System.out.println((p * G) + " " + (q * G));
    }
}
