import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long x = M / N;

        long a = 1, b = x;

        for(long i = 1; i * i <= x; i++) {
            if(x % i == 0) {
                long j = x / i;

                if(gcd(i, j) == 1) {
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(N * a + " " + N * b);
    }

    static long gcd(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
