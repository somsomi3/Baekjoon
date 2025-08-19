import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int len = L; len <= 100; len++) {
            int numerator = 2 * N - len * (len - 1);
            if (numerator < 0) break;

            if (numerator % (2 * len) == 0) {
                int x = numerator / (2 * len);
                for (int i = 0; i < len; i++) {
                    System.out.print((x + i) + " ");
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
