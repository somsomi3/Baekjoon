import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long g = gcd(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g; i++) {
            sb.append('1');
        }

        System.out.println(sb);
    }
}
