import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long g = gcd(N, M);

        StringBuilder sb = new StringBuilder();
        for(long i = 0; i < g; i++) {
            sb.append("1");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        while(b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
