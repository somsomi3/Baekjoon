import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        long a = 0;
        long b = 1;

        for (int i = 2; i <= N; i++) {
            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println(b);
    }
}
