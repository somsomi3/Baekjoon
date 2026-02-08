import java.io.*;
import java.util.*;

public class Main {
    static long a, b, c;

    static long pow(long x, long y) {
        if (y == 0) return 1;
        long v = pow(x, y / 2);
        v = (v * v) % c;
        if (y % 2 == 1) v = (v * x) % c;
        return v;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b));
    }
}
